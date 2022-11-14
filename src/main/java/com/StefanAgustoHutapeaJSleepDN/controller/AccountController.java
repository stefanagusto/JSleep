package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.Account;
import com.StefanAgustoHutapeaJSleepDN.Algorithm;
import com.StefanAgustoHutapeaJSleepDN.Renter;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;
import java.util.regex.Pattern;


public class AccountController implements BasicGetController<Account>{
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    public static final String REGEX_PATTER_PASSWORD = (Pattern.compile(REGEX_PASSWORD)).pattern();
    public static final String REGEX_EMAIL = "^\\w+@\\w+([\\.-]?\\w+)*.?\\w+$";
    public static final String REGEX_PATTERN_EMAIL = (Pattern.compile(REGEX_EMAIL)).pattern();

    @JsonAutowired(value = Account.class, filepath = "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\src\\json\\account.json")
    public static JsonTable<Account> accountTable;

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
        //Hash on password with MD5 algorithm
        password = Algorithm.hashMD5(password);
        Account account = new Account(name, email, password);
        accountTable.add(account);
        for (Account a : accountTable){
            if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                return null;
            }
        }
        return new Account(name, email, password);
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ){
        //Hash on password with MD5 algorithm
        password = Algorithm.hashMD5(password);
        for (Account data : accountTable){
            if(data.email.equals(email) && data.password.equals(password)){
                return data;
            }
        }
        return null;
    }
    @PostMapping("/{id}/registerRenter")
    Renter registerRenter(
            @RequestParam int id,
            @RequestParam String username,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        for (Account account : getJsonTable()){
            if(account.id == id){
                Renter renter = new Renter(username, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        }
        return null;
    }
}