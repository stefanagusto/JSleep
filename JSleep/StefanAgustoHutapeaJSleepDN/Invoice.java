package StefanAgustoHutapeaJSleepDN;

//subclass of Serializable
public class Invoice extends Serializable
{
    public int buyerId, renterId;
    public String time;
    /*Two overloading constructor*/

    protected Invoice(int id, int buyerId, int renterId, String time)
    {
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }

    public Invoice(int id, Account buyer, Renter renter, String time)
    {
        super(id);
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = time;
    }

    public String print()
    {
        return  "Buyer ID: " + buyerId + "\nRenter ID: " + renterId + "\nTime: " + time;
    }
}
