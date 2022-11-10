package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.Payment;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


public class PaymentController {
    public static JsonTable<Payment> paymentTable;

    @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\src\\json\\payment.json")

    @PostMapping("/{id}/cancel")
    public PaymentController cancel(
            @RequestParam int id
    ){
        return null;
    }

    @PostMapping("/{id}/accept")
    public boolean accept (
            @RequestParam int id) {
        return false;
    }

    public static JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/create")
    public Payment create (
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int roomId,
            @RequestParam String from,
            @RequestParam String to){
        return null;
    }

    @PostMapping("/{id}/submit")
    public PaymentController submit() {

        return null;
    }
}
