package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    public static JsonTable<Payment> paymentTable;

    @JsonAutowired(value = Payment.class, filepath = "src/json/payment.json")

    @PostMapping("/payment/{id}/cancel")
    public boolean cancel(
            @PathVariable int id
    ){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment != null && payment.status == Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.FAILED;
            Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.getRoomId());
            buyer.balance += room.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/payment/{id}/accept")
    public boolean accept (
            @PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment == null) return false;
        if(payment.status == Invoice.PaymentStatus.WAITING)
            return false;
        payment.status = Invoice.PaymentStatus.SUCCESS;
        return true;
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/payment/create")
    public Payment create (
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to) throws ParseException {
        Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == buyerId);
        double price = room.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = sdf.parse(from);
        Date dateTo = sdf.parse(to);

        if(acc == null)
            return null;
        if(room == null)
            return null;
        if(acc.balance <= room.price.price)
            return null;
        if(!Payment.availability(dateFrom, dateTo, room))
            return null;

        Payment payment = new Payment(buyerId, renterId, roomId, dateFrom, dateTo);
        acc.balance -= price;
        payment.status = Invoice.PaymentStatus.WAITING;
        if(Payment.makeBooking(dateFrom, dateTo, room)) {
            paymentTable.add(payment);
            return payment;
        }
        else return null;
    }
}