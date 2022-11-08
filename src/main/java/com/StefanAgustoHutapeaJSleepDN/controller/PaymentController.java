package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.Account;
import com.StefanAgustoHutapeaJSleepDN.Payment;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


public class PaymentController {
    public static JsonTable<Payment> paymentTable;


    @PostMapping("/{id}/cancel")
    public PaymentController cancel(
            @RequestParam int id
    ){
        return null;
    }
    
    @PostMapping("/payment")
    public boolean accept (
            @RequestParam int id) {
        return false;
    }

    public static JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

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
