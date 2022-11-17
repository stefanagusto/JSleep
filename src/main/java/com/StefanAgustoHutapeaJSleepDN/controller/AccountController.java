package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.Account;
import com.StefanAgustoHutapeaJSleepDN.Algorithm;
import com.StefanAgustoHutapeaJSleepDN.Renter;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.JsonAutowired;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")

public class AccountController implements BasicGetController<Account>{
    @JsonAutowired(filepath = "src/json/account.json", value = Account.class)
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);


    public static JsonTable<Account> accountTable;

    @Override
    public JsonTable<Account> getJsonTable() {

        return accountTable;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp(@PathVariable int id, @RequestParam double balance){
        for(Account singleAccount : accountTable){
            if(singleAccount.id == id){
                singleAccount.balance += balance;
                return true;
            }
        }
        return false;
    }

    @PostMapping("/register")
    Account register(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    ) throws NoSuchAlgorithmException {
        //Hash on password with MD5 algorithm
        if(!name.isBlank()){
            if(REGEX_PATTERN_EMAIL.matcher(email).matches()){
                if(REGEX_PATTERN_PASSWORD.matcher(password).matches()){
                    String hash = hash(password);
                    Account account = new Account(name, email, hash);
                    accountTable.add(account);
                    return account;
                }
            }
        }
        return null;
    }

    @PostMapping("/login")
    Account login(
            @RequestParam String email,
            @RequestParam String password
    ) throws NoSuchAlgorithmException {
       for(Account account :getJsonTable()){
           String hash = hash(password);
           if(account.email.equals(email) && account.password.equals(hash)){
               return account;
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
        for (Account account : accountTable){
            if(account.id == id){
                Renter renter = new Renter(username, address, phoneNumber);
                account.renter = renter;
                return renter;
            }
        }
        return null;
    }

    public static String hash(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}