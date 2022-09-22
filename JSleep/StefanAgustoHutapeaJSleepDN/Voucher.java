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

    public Voucher(String name, int code, double minimum, Type type, double cut)
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
        if(type == Type.DISCOUNT)//if the type is discount, then the price will be discounted
        {
            return price.price - (price.price * cut/100);
        }
        else//if the type is rebate, then price will be rebated
        {
            return price.price - cut;
        }
    }
}