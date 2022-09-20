package StefanAgustoHutapeaJSleepDN;


public class Room
{
    public String name;
    public int size;
    public Price price;
    public Facility facility;
    
    public Room(String name, int size, Price price, Facility facility)
    {
        // initialise instance variables
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        
    }
}
