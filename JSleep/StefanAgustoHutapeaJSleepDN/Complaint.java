package StefanAgustoHutapeaJSleepDN;

public class Complaint extends Serializable
{
    public String desc, date;
    /*Two overloading constructor*/

    protected Complaint(int id, String date, String desc)
    {
        super(id);
        this.date = date;
        this.desc = desc;
    }

    //return String from instance variable class
    public String toString()
    {
        return "Date: " + date + "\nComplaint: " + desc;
    } 
}