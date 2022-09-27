package StefanAgustoHutapeaJSleepDN;

//subclass of Serializable
public class Renter extends Serializable 
{
    /** Initializes default value field address as empty string
    default phoneNumber is 0*/
    public String address = "";
    public int phoneNumber = 0;
    public String username;

    /**4 Overloading constructor*/
    public Renter(int id, String username)
    {
        super(id);
        this.username = username;
    }

    public Renter(int id, String username, String address)
    {
        super(id);
        this.username = username;
        this.address = address;

    }

    public Renter(int id, String username, int phoneNumber)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public Renter(int id, String username, int phoneNumber, String address)
    {
        super(id);
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}