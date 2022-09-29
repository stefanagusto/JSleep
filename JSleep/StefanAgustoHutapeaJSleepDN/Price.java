package StefanAgustoHutapeaJSleepDN;

public class Price
{
    // instance variables - replace the example below with your own
    public double price, discount;

    //constructor Price(double price) -> instance variable price with parameter price, instance variable discount with value 0, instance variable rebate with value 0
    public Price(double price)
    {
        // initialise instance variables
        this.price = price;
        this.discount = 0;
    }
    //constructor Price(double price, int discount) -> instance variable rebate -> 0
    public Price(double price, double discount)
    {
        // initialise instance variables
        this.price = price;
        this.discount = discount;
    }
    public String toString()
    {
        return "Price: " + price + "\nDiscount: " + discount;
    }
}