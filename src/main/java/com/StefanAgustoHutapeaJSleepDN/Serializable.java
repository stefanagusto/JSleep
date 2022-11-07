package com.StefanAgustoHutapeaJSleepDN;
import java.util.HashMap;

public class Serializable
{
    public final int id;
    //Variabel Instance name mapCounter with data type HashMap with generic Class<?> as Key and Integer as Value that is serial.
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();


    protected Serializable()
    {
        Integer id;
        if (mapCounter.containsKey(this.getClass()))
        {
            id = mapCounter.get(this.getClass());
            id++;
        }
        else
        {
            id = 0;
        }
        mapCounter.put(this.getClass(), id);
        this.id = id;
    }

    public int compareTo(Serializable other)
    {
        return ((Integer) this.id).compareTo(other.id);
    }

    public boolean equals(Object other)
    {
        return (other instanceof Serializable) && (this.id == ((Serializable) other).id);
    }

    public boolean equals(Serializable other)
    {
        return this.id == other.id;
    }

    public <T> Integer setClosingId(Class<T> set, int num)
    {
        return mapCounter.put(set, num);
    }

    public <T> Integer getClosingId(Class<T> get)
    {
        return mapCounter.get(get);
    }
}