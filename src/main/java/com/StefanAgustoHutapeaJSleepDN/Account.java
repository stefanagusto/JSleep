package com.StefanAgustoHutapeaJSleepDN;

//subclass of Serializable
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;

    //REGEX_EMAIL (ex: local@domain, local : only number and alphabet, no whitespace. domain : only alphabet, no whitespace, ending with top level domain and no dot at the end)
    public static final String REGEX_EMAIL = "^\\w+@\\w+([\\.-]?\\w+)*.?\\w+$";
    //REGEX_PASSWORD (min 8 char, no whitespace, must contain at least 1 uppercase, 1 lowercase, and 1 number)
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    
    public Account(String name, String email, String password)
    {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String toString()
    {
        return "\nName: " + name + "\nEmail: " + email + "\nPassword: " + password + "\nAccount ID: " + id;
    }

    public boolean validate()
    {
        if (email.matches(REGEX_EMAIL) && password.matches(REGEX_PASSWORD))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}    