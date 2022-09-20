package StefanAgustoHutapeaJSleepDN;

public class Price
{
    // instance variables - replace the example below with your own
    public double price, rebate;
    public int discount;

    //constructor Price(double price) -> instance variable price with parameter price, instance variable discount with value 0, instance variable rebate with value 0
    public Price(double price)
    {
        // initialise instance variables
        this.price = price;
        this.rebate = 0.0d;
        this.discount = 0;
    }

    //constructor Price(double price, int discount) -> instance variable rebate -> 0
    public Price(double price, int discount)
    {
        // initialise instance variables
        this.price = price;
        this.rebate = 0.0d;
        this.discount = discount;
    }

    public Price(double price, double rebate)
    {
        // initialise instance variables
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }

    /*method getDiscountedPrice() -> return price - (price * discount / 100), if discount > 100 -> discount = 100, if discount = 100 -> return 0,
    return after discount price */
    public double getDiscountedPrice()
    {
        if(this.discount > 100){
            this.discount = 100;
        }else if(this.discount == 100){
            return 0;
        }
        return this.price - (this.price * this.discount / 100);
    } 

    /* methodgetRebatedPrice() -> if rebate > price -> rebate = price, return price - rebate, */
    public double getRebatedPrice()
    {
        if(this.rebate > this.price){
        this.rebate = this.price;
        }
    return this.price - this.rebate;
    }
}
