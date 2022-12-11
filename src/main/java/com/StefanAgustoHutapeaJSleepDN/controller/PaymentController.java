package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Javadoc
 * @author Stefan Agusto Hutapea
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    @JsonAutowired(filepath = "json/payment.json", value = Payment.class)
    public static JsonTable<Payment> paymentTable;

    @Override
    @GetMapping("/payment")
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @PostMapping("/{id}/cancel")
    public boolean cancel(
            @PathVariable int id
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

    @PostMapping("/{id}/accept")
    public boolean accept (
            @PathVariable int id) {
        Payment payment = Algorithm.<Payment>find(paymentTable, pred -> pred.id == id);
        if (payment != null && payment.status == Invoice.PaymentStatus.WAITING) {
            payment.status = Invoice.PaymentStatus.SUCCESS;
            return true;
        }
        return false;
    }

    @PostMapping("/create")
    public Payment create( @RequestParam int buyerId, @RequestParam int renterId, @RequestParam int roomId,  @RequestParam String from,@RequestParam String to){
        Room roomCheck = Algorithm.<Room>find(RoomController.roomTable, room -> room.id == roomId);
        Account accountCheck = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == buyerId);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromTgl = sdf.parse(from);
            Date toTgl = sdf.parse(to);
            long day = toTgl.getTime() - fromTgl.getTime();
            double totalPay = roomCheck.price.price * (TimeUnit.MILLISECONDS.toDays(day));
            if(accountCheck != null && roomCheck != null && totalPay <= accountCheck.balance && Payment.availability(fromTgl, toTgl, roomCheck)){
                Payment paid = new Payment(buyerId, renterId, roomId, fromTgl, toTgl);
                accountCheck.balance -= totalPay;
                paid.totalPrice = totalPay;
                paid.status = Invoice.PaymentStatus.WAITING;
                Payment.makeBooking(fromTgl, toTgl, roomCheck);
                paymentTable.add(paid);
                return paid;
            }else{
                return null;
            }
        } catch (ParseException p) {
            p.printStackTrace();
        }
        return null;
    }
}