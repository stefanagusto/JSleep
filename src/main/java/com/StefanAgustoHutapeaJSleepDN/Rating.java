package com.StefanAgustoHutapeaJSleepDN;

public class Rating
{
    private long total,count;
    
    public Rating()
    {
        total = 0;
        count = 0;
    }
    //method insert(int rating) -> add variable total with parameter rating, add variable count with value 1
    public void insert(int rating)
    {
        total += rating;
        count++;
    }
    //method getAverage() -> return total / count, with condition no NaN or exception division by zero
    public double getAverage()
    {
        if(count == 0){
            return 0;
        }else{
            return total / count;
        }
    }
    //method getCount() -> return count
    public long getCount()
    {
        return count;
    }
    //method getTotal() -> return total
    public long getTotal()
    {
        return total;
    }

    public String toString()
    {
        return "Total: " + total + "\nCount: " + count;
    }
    
}
