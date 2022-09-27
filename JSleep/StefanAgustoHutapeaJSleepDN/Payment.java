package StefanAgustoHutapeaJSleepDN;

//subclass of Invoice
public class Payment extends Invoice
{
    public String to, from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to)
    {
        super(id, buyerId, renterId, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to)
    {
        super(id, buyer, renter, time);
        this.to = to;
        this.from = from;
        this.roomId = roomId;
    }

    public String print()
    {
        return "Room ID: " + roomId + "\nFrom: " + from + "\nTo: " + to;
    }

    public int getRoomId()
    {
        return roomId;
    }
}
