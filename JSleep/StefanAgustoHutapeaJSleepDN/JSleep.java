package StefanAgustoHutapeaJSleepDN;
/**
 * Case Study Modul 3
 * Stefan Agusto Hutapea
 * 2106700744
 */

public class JSleep
{   
    public static void main(String[] args)
    {
    Complaint testComplaint = new Complaint(1, "23 Augustus 2022", "Bad Quality");
    Price testPrice = new Price(100000, 20000);
    Room testRoom = new Room(1, "Presidential Suite", 5, testPrice, Facility.FitnessCenter, City.DEPOK, "JL. Margonda Raya");
    Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
    Rating testRating = new Rating();
    System.out.println(testComplaint.toString());
    System.out.println(testRoom.toString());
    System.out.println(testAccount.toString());
    System.out.println(testPrice.toString());
    System.out.println(testRating.toString());
    }
}