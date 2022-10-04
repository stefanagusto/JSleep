package StefanAgustoHutapeaJSleepDN;
import java.util.Calendar;
import java.text.SimpleDateFormat;

//subclass of Invoice
public class Payment extends Invoice
{
    public Calendar to, from;
    private int roomId;

    public Payment(int id, int buyerId, int renterId, int roomId)
    {
        super(id, buyerId, renterId);
        this.to = Calendar.getInstance();
        this.from = Calendar.getInstance();
        this.roomId = roomId;
        //To = 2 days after From
        to.add(Calendar.DATE, 2);
    }

    public Payment(int id, Account buyer, Renter renter, int roomId)
    {
        super(id, buyer, renter);
        this.to = Calendar.getInstance();
        this.from = Calendar.getInstance();
        this.roomId = roomId;
        //To = 2 days after From
        to.add(Calendar.DATE, 2);
    }

    public String getTime()
    {
        //Return field time of Payment class
        return new SimpleDateFormat("'Formatted Date = 'dd MMMM yyyy").format(time.getTime());
    }

    public String getDuration()//Return duration from and to with simple date format
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        return SDFormat.format(from.getTime()) + " - " + SDFormat.format(to.getTime());
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
