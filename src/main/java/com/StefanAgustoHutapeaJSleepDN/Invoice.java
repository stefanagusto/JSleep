package com.StefanAgustoHutapeaJSleepDN;

import com.StefanAgustoHutapeaJSleepDN.dbjson.Serializable;


//subclass of Serializable
public class Invoice extends Serializable
{
    public int buyerId, renterId;

    public RoomRating rating;
    public PaymentStatus status;
    //enum
    public enum RoomRating
    {
        NONE, BAD, NEUTRAL, GOOD
    }

    //enum
    public enum PaymentStatus
    {
        FAILED, WAITING, SUCCESS
    }

    /*Two overloading constructor*/

    protected Invoice(int buyerId, int renterId)
    {
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;

        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public Invoice(Account buyer, Renter renter)
    {
        super();
        this.buyerId = buyer.id;
        this.renterId = renter.id;

        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public String print()
    {
        return  "Buyer ID: " + buyerId + "\nRenter ID: " + renterId ;
    }
}