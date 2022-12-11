package com.StefanAgustoHutapeaJSleepDN;

import com.StefanAgustoHutapeaJSleepDN.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Date;


//subclass of Serializable
public class Room extends Serializable
{
    public int size, accountId;
    public Price price;
    public ArrayList<Facility> facility = new ArrayList<>();
    public String name;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();

    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, String address, BedType bedType)
    {
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = new ArrayList<>(facility);
        this.city = city;
        this.address = address;
        this.booked = new ArrayList<Date>();
        this.bedType = bedType;
    }

    public String toString()
    {
        return "Name: " + name + "\nBedType: " + bedType + "\nSize: " + size + "\n" + price + "\nFacility: " + facility + "\nCity: " + city + "\nAddress: " + address + "\nID:"  + id;
    }
}