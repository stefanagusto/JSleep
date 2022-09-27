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
    Payment testRoom = new Payment(1, 1, 1, "", 1, "", "");
    Invoice testInvoice = new Invoice(2, 2, 2, "");
    System.out.println(testRoom.print());
    System.out.println(testInvoice.print());
    }
}