package com.StefanAgustoHutapeaJSleepDN;
import java.util.ArrayList;

public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less)
    {
        ArrayList<Double> result = new ArrayList<>();
        for (Price price : list)
        {
            if (less == true)
            {
                if (price.price <= value)
                {
                    //return Arraylist 
                    result.add(price.price);                    
                }
            }
            else 
            {
                if (price.price > value)
                {
                    //return Arraylist
                    result.add(price.price);
                }
            }
        }
        return result;
    }
}