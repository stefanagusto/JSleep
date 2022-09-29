package StefanAgustoHutapeaJSleepDN;

//subclass of Serializable
public class Room extends Serializable
{
    public int size;
    public Price price;
    public Facility facility;
    public String name;
    public String address;
    public BedType bedType;
    public City city;

    public Room(int id, String name, int size, Price price, Facility facility, City city, String address)
    {
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }

    public String toString()
    {
        return "Room ID: " + id + "\nName: " + name + "\nSize: " + size + "\n" + price + "\nFacility: " + facility + "\nCity: " + city + "\nAddress: " + address;
    }
}