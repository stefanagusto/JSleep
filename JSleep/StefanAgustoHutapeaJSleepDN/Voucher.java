package StefanAgustoHutapeaJSleepDN;

public class Voucher
{
    // instance variables 
    public Type type;
    public double cut;
    public String name;
    public int code;
    public double minimum;
    private boolean used;

    //constructor
    public Voucher(String name, int code, Type type, double minimum, double cut)
    {
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.minimum = minimum;
        this.type = type;
        this.cut = cut;
        this.used = false;
    }
    //return variables instance used
    public boolean isUsed()
    {
        return used;
    }
    //method canApply() -> if price >= minimum and used == false return true
    public boolean canApply(Price price)
    {
        if(price.price >= minimum && used == false)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    /*method apply(Price price) -> return price after apply voucher
    calling this method will change used to true*/
    public double apply(Price price)
    {
        used = true;
        //checking type
        if(type == Type.DISCOUNT)//if the type is discount, then the price will be discounted, but price can't be negative
        {
            if(price.price - (price.price * cut / 100) >= 0)
            {
                return price.price - (price.price * cut / 100);
            }
            else
            {
                return 0;
            }
        }
        else if(type ==Type.REBATE)//if the type is rebate, then the price will be discounted, but price can't be negative
        {
            if(price.price - cut < 0)
            {
                return 0;
            }
            else
            {
                return price.price - cut;
            }
        }
        else
        {
            return price.price;
        }
    }
}