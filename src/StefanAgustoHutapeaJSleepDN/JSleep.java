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
        Account testRegex = new Account("stefan", "stefan@ui.ac.id", "Stefan123");
        Account testRegexFail = new Account("Stefan", "stefan_hutapea@ui.ac.id", "stefan");
        System.out.println(testRegex.validate());
        System.out.println(testRegexFail.validate());

        /*try-catch on making JsonTable with generic account named tableAccount
        that can write to local file */
        try
        {
            String filepath = "C:\\Users\\ACER NITRO 5\\OneDrive - UNIVERSITAS INDONESIA\\DTE\\Mata Kuliah\\Sem 3\\Pemrograman Berorientasi Objek & Praktikum\\JSleep\\JSleep\\src\\json\\account.json";

            JsonTable<Account> tableAccount = new JsonTable<Account>(Account.class, filepath);
            tableAccount.add(new Account("Stefan", "stefanhutapea@gmail.com", "stefan123"));
            tableAccount.writeJson();

            tableAccount.forEach(account -> System.out.println(account.toString()));
        }
        catch (Throwable t)
        {
            t.printStackTrace();
        }

        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++)
        {
            Thread thread = new Thread(new ThreadingObject("Thread " + i));
            threads.add(thread);
        }
        threads.forEach(Thread::start);
    }

    public static Room createRoom(){
        return new Room(1, "Room 1", 2, new Price(1, 100000), Facility.AC, City.JAKARTA, "Jl. Jalan");
    }

    public static List<Room> filterByCity(List<Room> list, String search, int page, int pageSize)
    {
        List<Room> result = new ArrayList<>();
        for (Room room : list)
        {
            if (room.city.name().toLowerCase().contains(search.toLowerCase()))
            {
                result.add(room);
            }
        }
        return result.subList(page * pageSize, Math.min((page + 1) * pageSize, result.size()));
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
        return result.subList(0, Math.min(5, result.size()));
    }

    public static List<Room> filterByAccountId(List<Room> list, int accountId, int page, int pageSize)
    {
        List<Room> result = new ArrayList<>();
        for (Room room : list)
        {
            if (room.accountId == accountId)
            {
                result.add(room);
            }
        }
        return result.subList(page * pageSize, Math.min((page + 1) * pageSize, result.size()));
    }
}