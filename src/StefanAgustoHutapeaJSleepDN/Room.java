package StefanAgustoHutapeaJSleepDN;
import java.util.Date;
import java.util.ArrayList;


//subclass of Serializable
public class Room extends Serializable implements FileParser
{
    public int size;
    public Price price;
    public Facility facility;
    public String name;
    public String address;
    public BedType bedType;
    public City city;
    public ArrayList<Date> booked = new ArrayList<>();

    public Room(String name, int size, Price price, Facility facility, City city, String address)
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
        return "Room ID: " + id + "\nName: " + name + "\nSize: " + size + "\n" + price + "\nFacility: " + facility + "\nCity: " + city + "\nAddress: " + address;
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