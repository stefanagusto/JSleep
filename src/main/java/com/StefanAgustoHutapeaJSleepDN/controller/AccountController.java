package com.StefanAgustoHutapeaJSleepDN.controller;

import com.StefanAgustoHutapeaJSleepDN.*;
import com.StefanAgustoHutapeaJSleepDN.dbjson.*;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.*;
/**
 * Javadoc
 * @author Stefan Agusto Hutapea
 */

/**
 * AccountController is a class that provides functionality for managing user accounts.
 * It implements the BasicGetController interface, which defines the getJsonTable method.
 * The class defines two regular expressions for validating email and password strings, and two static Pattern objects that can be used to match these regular expressions.
 * The class also has a JsonTable object that is used to store and retrieve user accounts.
 *
 * The class defines two methods:
 * - login: This method takes a user's email and password, hashes the password using the MD5 algorithm, and then compares it to the accounts stored in the JsonTable object. If a match is found, the matching account is returned. Otherwise, null is returned.
 * - register: This method takes a user's name, email, and password, validates them, and then creates a new Account object. The new account is added to the JsonTable object and then returned.
 */

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account> {
    /**
     * REGEX_PASSWORD is a static final field that defines a regular expression for validating a password string.
     * The regular expression requires that the password must contain at least one lowercase letter, one uppercase letter, one numeric character, and must be at least 8 characters long.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    /**
     * REGEX_EMAIL is a static final field that defines a regular expression for validating an email string.
     */
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    /**
     * REGEX_PATTERN_EMAIL is a static Pattern object that can be used to match the REGEX_EMAIL regular expression.
     */
    public static Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    /**
     * REGEX_PATTERN_PASSWORD is a static Pattern object that can be used to match the REGEX_PASSWORD regular expression.
     */
    public static Pattern  REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    /**
     * accountTable is a JsonTable object that is used to store and retrieve user accounts.
     */
    @JsonAutowired(value = Account.class, filepath = "json/account.json")
    public static JsonTable<Account> accountTable;

    /**
     * getJsonTable is a method that returns the JsonTable object that is used to store user accounts.
     * This method is required by the BasicGetController interface.
     *
     * @return The JsonTable object that is used to store user accounts.
     */
    @GetMapping("/account")
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    /**
     * login is a method that takes a user's email and password, hashes the password using the MD5 algorithm, and then compares it to the accounts stored in the JsonTable object.
     * If a match is found, the matching account is returned. Otherwise, null is returned.
     *
     * @param email The email of the user trying to log in.
     * @param password The password of the user trying to log in.
     * @return The matching Account object if the login was successful, or null if no match was found.
     */
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

    /**
     * register is a method that takes a user's name, email, and password, validates them, and then creates a new Account object.
     * The new account is added to the JsonTable object and then returned.
     *
     * @param name The name of the user to be registered.
     * @param email The email of the user to be registered.
     * @param password The password of the user to be registered.
     * @return The newly created Account object if the registration was successful, or null if the registration failed.
     */
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

    /**
     * Registers a new renter for the given account.
     *
     * @param id the ID of the account to register the renter for
     * @param username the username for the new renter
     * @param address the address for the new renter
     * @param phoneNumber the phone number for the new renter
     * @return the newly created Renter object
     */
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
    /**
     * Adds a given amount to the balance of the account with the given ID.
     *
     * @param id the ID of the account to add the balance to
     * @param balance the amount to add to the account's balance
     * @return true if the balance was added successfully, false otherwise
     */
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