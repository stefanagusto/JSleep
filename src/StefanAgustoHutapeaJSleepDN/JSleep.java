package StefanAgustoHutapeaJSleepDN;

import java.util.ArrayList;
import java.util.List;


/**
 * Case Study 6
 * Stefan Agusto Hutapea
 * 2106700744
 */

public class JSleep
{   
    public static void main(String[] args)
    {
        Renter testRegex = new Renter("Netlab_", "081234567890", "Jl. Margonda Raya");
        Renter testRegexFail = new Renter("netlab", "081", "Jalan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        try
        {
            String filepath = "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\src\\json\\randomRoomList.json";

            JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
            List<Room> filterTableRoom = filterByCity(tableRoom, "medan", 0, 5);
            filterTableRoom.forEach(room -> System.out.println(room.toString()));
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }
    }

    public static Room createRoom(){
        return new Room(1, "Room 1", 2, new Price(1, 100000), Facility.AC, City.JAKARTA, "Jl. Jalan");
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize)
    {
        List<Room> result = new ArrayList<>();
        int start = page * pageSize;
        int end = start + pageSize;
        for (int i = start; i < end; i++)
        {
            Room room = list.get(i);
            if (room.city.name().toLowerCase().contains(search.toLowerCase()))
            {
                result.add(room);
            }
        }
        return result;
    }

    public static List<Room> filterByPrice(List<Room> list, double minPrice, double maxPrice)
    {
        List<Room> result = new ArrayList<>();
        for (Room room : list)
        {
            if (room.price.price >= minPrice && room.price.price <= maxPrice)
            {
                result.add(room);
            }
        }
        return result;
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize)
    {
        List<Room> result = new ArrayList<>();
        int start = page * pageSize;
        int end = start + pageSize;
        for (int i = start; i < end; i++)
        {
            Room room = list.get(i);
            if (room.accountId == accountId)
            {
                result.add(room);
            }
        }
        return result;
    }
}