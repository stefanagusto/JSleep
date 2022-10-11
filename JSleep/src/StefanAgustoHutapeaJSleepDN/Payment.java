package StefanAgustoHutapeaJSleepDN;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//subclass of Invoice
public class Payment extends Invoice
{
    public Date to, from;
    private int roomId;


    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to)
    {
        super(id, buyerId, renterId);
        this.to = new Date(to.getTime());
        this.from = new Date(from.getTime());
        this.roomId = roomId;
    }

    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to)
    {
        super(id, buyer, renter);
        this.to = new Date(to.getTime());
        this.from = new Date(from.getTime());
        this.roomId = roomId;
    }

    public String getTime()
    {
        //Return field time of Payment class
        return new SimpleDateFormat("'Formatted Date = 'dd MMMM yyyy").format(time.getTime());
    }

    public static boolean availability(Date from,Date to,Room room)
    {
        if(from.after(to) ||to.before(from)||from.equals(to))
        {
            return false;
        }
        for(Date i: room.booked)
        {
            if (from.equals(i)){
                return false;
            }
            else if(from.before(i) && to.after(i))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from, Date to, Room room)
    {
        if(availability(from,to,room))
        {
            while(from.before(to))
            {
                room.booked.add(from);
                Calendar c = Calendar.getInstance();
                c.setTime(from);
                c.add(Calendar.DATE,1);
                from = c.getTime();
            }
            return true;
        }
        else
        {
            return false;
        }
        
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
