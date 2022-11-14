package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class PaymentController implements BasicGetController<Payment> {
    public static JsonTable<Payment> paymentTable;

    @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\src\\json\\payment.json")

    @PostMapping("/payment/{id}/cancel")
    public boolean cancel(
            @RequestParam int id
    ){
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if(payment != null && payment.status == Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.FAILED;
            Account acc = Algorithm.<Account>find(AccountController.accountTable, pred -> pred.id == payment.buyerId);
            Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == payment.renterId);
            acc.balance += room.price.price;
            return true;
        }
        return false;
    }

    @PostMapping("/payment/{id}/accept")
    public boolean accept (
            @RequestParam int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if(payment != null && payment.status == Invoice.PaymentStatus.WAITING){
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

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
        Room room = Algorithm.<Room>find(RoomController.roomTable, pred -> pred.id == roomId && pred.accountId == roomId);
        double price = room.price.price;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFrom = sdf.parse(from);
        Date dateTo = sdf.parse(to);

        if(acc.balance >= price && acc != null && room != null){
            Payment payment = new Payment(acc.id, buyerId, renterId, roomId, dateFrom, dateTo);
            acc.balance -= price;
            payment.status= Invoice.PaymentStatus.WAITING;
            payment.makeBooking(dateFrom, dateTo, room);
            paymentTable.add(payment);
            return payment;
        }
        return null;
    }
}