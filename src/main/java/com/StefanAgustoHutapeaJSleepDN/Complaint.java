package com.StefanAgustoHutapeaJSleepDN;

import com.StefanAgustoHutapeaJSleepDN.dbjson.Serializable;

public class Complaint extends Serializable
{
    public String desc, date;
    /*Two overloading constructor*/

    protected Complaint(String date, String desc)
    {
        super();
        this.date = date;
        this.desc = desc;
    }

    //return String from instance variable class
    public String toString()
    {
        return "Complaint ID: " + id + "\nDate: " + date + "\nDescription: " + desc;
    } 
}