package StefanAgustoHutapeaJSleepDN;
/**
 * Case Study Modul 2
 * Stefan Agusto Hutapea
 * 2106700744
 */





public class JSleep
{   
    
    //metode createRoom()-> initiate object room with parameter name, size, price, facility
    public static Room createRoom()
    {
        Price price = new Price(100000, 5);
        Room room = new Room("Hotel", 30, price, Facility.AC);
        return room;
    }

    //method entry point(main)
    public static void main(String[] args){
        Room test = createRoom();
        System.out.println(test.name);
        System.out.println(test.size);
        System.out.println(test.price.price);
        System.out.println(test.facility);
    }
}
