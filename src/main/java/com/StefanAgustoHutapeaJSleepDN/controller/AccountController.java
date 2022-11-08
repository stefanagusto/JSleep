package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.Account;
import com.StefanAgustoHutapeaJSleepDN.Algorithm;
import com.StefanAgustoHutapeaJSleepDN.Renter;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import java.util.regex.Pattern;



public class AccountController implements BasicGetController<Account>{
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final String REGEX_EMAIL = "^\\w+@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PATTERN_EMAIL = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
    public static final String REGEX_PATTER_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    @JsonAutowired(value = Account.class, filepath = "src/json/account.json")
    public static JsonTable<Account> accountTable;


    @Override
    @GetMapping("/account")
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance){
        return false;
    }

    @PostMapping("/register")
     Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
            ){
        return null;
     }

    @PostMapping("/login")
     Account login(
            @RequestParam String email,
            @RequestParam String password
            ){
        return null;
     }
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @RequestParam int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
            ){
        return null;
    }
}
