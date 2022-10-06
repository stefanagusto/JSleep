package StefanAgustoHutapeaJSleepDN;
import java.sql.Date;

/**
 * Case Study Modul 3
 * Stefan Agusto Hutapea
 * 2106700744
 */

public class JSleep
{   
    public static Room createRoom(){
        Room room = new Room(1, "Room 1", 2, new Price(1, 100000), Facility.AC, City.JAKARTA, "Jl. Jalan");
        return room;
    }

    public static void main(String[] args)
    {
        Room RoomA = JSleep.createRoom();
        Room RoomB = JSleep.createRoom();
        System.out.println("Membuat booking dari tanggal 15 hingga 20");
        Date start = Date.valueOf("2022-8-15");
        Date end = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start, end,RoomA));
        System.out.println("Membuat booking dari tanggal 18 hingga 20");
        Date start2 = Date.valueOf("2022-8-18");
        Date end2 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start2, end2,RoomA));
        System.out.println("Membuat booking dari tanggal 18 hingga 20 untuk kamar berbeda");
        Date start3 = Date.valueOf("2022-8-18");
        Date end3 = Date.valueOf("2022-8-20");
        System.out.println(Payment.makeBooking(start3, end3,RoomB));
        System.out.println("Membuat booking dari tanggal 20 hingga 15");
        Date start4 = Date.valueOf("2022-8-20");
        Date end4 = Date.valueOf("2022-8-15");
        System.out.println(Payment.makeBooking(start4, end4,RoomA));
    }
}