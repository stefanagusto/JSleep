package com.StefanAgustoHutapeaJSleepDN;
import com.StefanAgustoHutapeaJSleepDN.BedType;
import com.StefanAgustoHutapeaJSleepDN.City;
import com.StefanAgustoHutapeaJSleepDN.Facility;
import com.StefanAgustoHutapeaJSleepDN.Price;
import com.StefanAgustoHutapeaJSleepDN.dbjson.Serializable;

import java.util.Date;
import java.util.ArrayList;


//subclass of Serializable
public class Room extends Serializable
{
    public int size, accountId;
    public Price price;
    public Facility facility;
    public String name;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();

    public Room(int accountId, String name, int size, Price price, Facility facility, City city, String address)
    {
        super();
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
        this.bedType = BedType.SINGLE;
    }

    public String toString()
    {
        return "Name: " + name + "\nBedType: " + bedType + "\nSize: " + size + "\n" + price + "\nFacility: " + facility + "\nCity: " + city + "\nAddress: " + address + "\nID:"  + id;
    }

    public Object write()
    {
        return null;
    }
    public boolean read(String content)
    {
        return false;
    }
}