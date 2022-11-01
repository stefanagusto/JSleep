package StefanAgustoHutapeaJSleepDN;

public class Voucher extends Serializable
{
    // instance variables 
    public String name;
    private boolean used;
    public int code;
    public Type type;
    public double minimum, cut;

    //constructor
    public Voucher(String name, int code, Type type, boolean used, double minimum, double cut)
    {
        super();
        this.name = name;
        this.code = code;
        this.type = type;
        this.used = used;
        this.minimum = minimum;
        this.cut = cut;
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

    public Object write()
    {
        return null;
    }
    public boolean read(String content)
    {
        return false;
    }
}