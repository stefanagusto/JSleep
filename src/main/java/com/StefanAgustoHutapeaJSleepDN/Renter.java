package com.StefanAgustoHutapeaJSleepDN;

//subclass of Serializable
public class Renter extends Serializable 
{
    /** Initializes default value field address as empty string
    default phoneNumber is 0*/
    public String address;
    public String phoneNumber;
    public String username;

    //REGEX_PHONE(Min 9 digits, Max 12 digits, only number)
    public static final String REGEX_PHONE = "^[0-9]{9,12}$";
    //REGEX_NAME(Capital first letter, only alphabet,digit,underscore), min 4 char, max 20 char, no space, where 5th-21th char is true and 4th/22th char is false
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public Renter(String username,String phoneNumber,String address)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate()
    {
        if (username.matches(REGEX_NAME) && phoneNumber.matches(REGEX_PHONE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}