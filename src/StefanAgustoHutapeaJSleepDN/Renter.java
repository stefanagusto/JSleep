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
    public Renter(String username)
    {
        super();
        this.username = username;
    }

    public Renter(String username, String address)
    {
        super();
        this.username = username;
        this.address = address;

    }

    public Renter(String username, int phoneNumber)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
    }

    public Renter(String username, int phoneNumber, String address)
    {
        super();
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}