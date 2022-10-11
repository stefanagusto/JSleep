package StefanAgustoHutapeaJSleepDN;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Case Study Modul 5
 * Stefan Agusto Hutapea
 * 2106700744
 */

public class JSleep
{   
    public static Room createRoom(){
        return new Room("Room 1", 2, new Price(1, 100000), Facility.AC, City.JAKARTA, "Jl. Jalan");
    }

    public static void main(String[] args)
    {
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        for(int i = 0; i<5; i++){
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
    }
}