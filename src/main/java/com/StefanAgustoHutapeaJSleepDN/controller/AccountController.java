package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.*;


@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    public static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static Pattern  REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    @JsonAutowired(value = Account.class, filepath = "json/account.json")
    public static JsonTable<Account> accountTable;

    @GetMapping("/account")
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    @PostMapping("/login")
    Account login( @RequestParam String email, @RequestParam String password) {
        try {
            MessageDigest MD = MessageDigest.getInstance("MD5");
            MD.update(password.getBytes());
            byte[] bytes = MD.digest();
            StringBuilder strBuild = new StringBuilder();
            int i = 0;
            while (i < bytes.length) {
                strBuild.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
                i++;
            }
            password = strBuild.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        for (Account data : accountTable) {
            if (data.password.equals(password) && data.email.equals(email)) {return data;}
        }
        return null;
    }

    @PostMapping("/register")
    Account register( @RequestParam String name, @RequestParam String email, @RequestParam String password) {
        String generatedPassword = null;
        for (Account account : accountTable){
            if(account.email.equals(email) || (name.isBlank()) || account.validate()){
                return null;
            }
        }
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Account newAccount = new Account(name, email, generatedPassword);
        accountTable.add(newAccount);
        return newAccount;
    }

    @PostMapping("/{id}/registerRenter")
    Renter registerRenter (@PathVariable int id,
                           @RequestParam String username,
                           @RequestParam String address,
                           @RequestParam String phoneNumber) {
        for (Account account : getJsonTable()) {
            if (account.id == id || account.renter == null) {
                Renter renter = new Renter (username, phoneNumber, address);
                account.renter = renter;
                return renter;
            }
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp (@PathVariable int id, @RequestParam double balance) {
        Account found = Algorithm.<Account>find(getJsonTable(), acc -> acc.id == id);
        if(found != null){
            found.balance += balance;
            return true;
        }else{
            return false;
        }
    }
}