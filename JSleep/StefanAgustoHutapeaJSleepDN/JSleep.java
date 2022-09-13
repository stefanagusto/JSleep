package StefanAgustoHutapeaJSleepDN;
/**
 * Case Study Modul 1
 * Stefan Agusto Hutapea
 * 2106700744
 */
public class JSleep
{    
    //metode getHotelID = Return 0
    public int getHotelID(){
        return 0;
    }

    //metode getHotelName = Return hotelName
    public String getHotelName(){
        return "Hotel Antares";
    }

    //metode isDiscount = Return true
    public boolean isDiscount(){
        return true;
    }

    //metode getDiscountPercentage(int beforeDiscount, int afterDiscount) = Return discountPercentage, before discount, after discount\
    //constrain : if beforeDiscount < afterDiscount, no discount
    //if no discount, return 0.0f
    public float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        float discountPercentage = 0.0f;
        if(beforeDiscount < afterDiscount){//no discount
            discountPercentage = 0.0f;
        }else{
            discountPercentage = (float)(beforeDiscount - afterDiscount) / beforeDiscount;
        }
        return discountPercentage;
    }

    //metode getDiscountedprice(int price, float discountPercentage) = Return discountedPrice
    //constrain : if discountPercentage > 100.0f, discountPercentage = 100.0f
    public int getDiscountedPrice(int price, float discountPercentage){
        int discountedPrice = 0;
        if(discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }
        discountedPrice = (int)(price - (price * discountPercentage));
        return discountedPrice;
    }

    //metode getOriginalPrice(int discountedPrice, float discountPercentage) = Return originalPrice
    public int getOriginalPrice(int discountedPrice, float discountPercentage){
        int originalPrice = 0;
        originalPrice = (int)(discountedPrice / (1 - discountPercentage));
        return originalPrice;
    }

    //metode getAdminFeePercentage = Return adminFeePercentage with commission 5%
    public float getAdminFeePercentage(){
        float adminFeePercentage = 0.0f;
        adminFeePercentage = 0.05f;
        return adminFeePercentage;
    }

    //metode getAdminFee(int price) = Return adminFee, adminFee =from getAdminFeePercentage
    public int getAdminFee(int price){
        int adminFee = 0;
        adminFee = (int)(price * getAdminFeePercentage());
        return adminFee;
    }

    //metode getTotalPrice(int price, int numberOfNight) = Return totalPrice after numberOfNight * price + adminFee
    //to get adminFee, use getAdminFee and pass price * numberOfNight
    public int getTotalPrice(int price, int numberOfNight){
        int totalPrice = 0;
        totalPrice = (price * numberOfNight) + getAdminFee(price * numberOfNight);
        return totalPrice;
    }

    //method entry point(main)
    public static void main(String[] args){
        JSleep jSleep = new JSleep();
        System.out.println("Hotel ID : " + jSleep.getHotelID());
        System.out.println("Hotel Name : " + jSleep.getHotelName());
        System.out.println("Discount : " + jSleep.isDiscount());
        System.out.println("Discount Percentage : " + jSleep.getDiscountPercentage(100000, 90000));
        System.out.println("Discounted Price : " + jSleep.getDiscountedPrice(100000, 0.1f));
        System.out.println("Original Price : " + jSleep.getOriginalPrice(90000, 0.1f));
        System.out.println("Admin Fee Percentage : " + jSleep.getAdminFeePercentage());
        System.out.println("Admin Fee : " + jSleep.getAdminFee(100000));
        System.out.println("Total Price : " + jSleep.getTotalPrice(100000, 2));
    }
}
