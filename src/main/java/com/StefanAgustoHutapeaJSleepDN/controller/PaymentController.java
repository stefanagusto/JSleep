package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(filepath = "src/json/payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;

    @Override
    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/payment/{id}/cancel")
    public boolean cancel(
            @RequestParam int id
    ){
        Payment payment = Algorithm.<Payment>find(getJsonTable(), pred -> pred.id == id);
        if(payment != null && payment.status == Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.FAILED;
            Account buyer = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            buyer.balance += room.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/payment/{id}/accept")
    public boolean accept (
            @RequestParam int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    @PostMapping("/payment/create")
    public Payment create (
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to) throws ParseException {
        Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == buyerId && pred.id == buyerId);
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId && pred.accountId == roomId);
        double price = room.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = sdf.parse(from);
        Date dateTo = sdf.parse(to);

        if(acc.balance >= price && acc != null && room != null  ){
            Payment payment = new Payment(acc.id, buyerId, renterId, roomId, dateFrom, dateTo);
            acc.balance -= price;
            payment.status=Invoice.PaymentStatus.WAITING;
            Payment.makeBooking(dateFrom, dateTo, room);
            paymentTable.add(payment);
            return payment;
        }
        return null;
    }
}