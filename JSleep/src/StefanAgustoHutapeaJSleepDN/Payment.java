package StefanAgustoHutapeaJSleepDN;
import java.util.Date;
import java.text.SimpleDateFormat;

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
        //if room available in that time(checking with booked arraylist), return true, else return false
        if(room.booked.isEmpty())
        {
            return true;
        }
        //ERROR HANDLING 
        //if to < from, return false
        else if(to.compareTo(from) < 0)
        {
            return false;
        }
        else//
        {
            for(int i = 0; i < room.booked.size(); i++)
            {
                if(room.booked.get(i).compareTo(from) == 0 || room.booked.get(i).compareTo(to) == 0)
                {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean makeBooking(Date from, Date to, Room room)
    {
        //if room available, date is added to booked arraylist and return true
        //if room not available, return false
        if(availability(from, to, room))
        {
            room.booked.add(from);
            room.booked.add(to);
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
