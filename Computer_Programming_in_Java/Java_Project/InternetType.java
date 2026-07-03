public class InternetType extends AdvertisementType{ // InternetType class which extends AdvertisementType
    private int priceDay; // price of ad per day
    private int costAuto; // price of automatic refresh
    private int pricePage; // price of every extra page
 
    public InternetType(String description, int code, AdvertisingAgency agency , int priceDay,
       int costAuto, int pricePage) { // Constructor for InternetType
         super(description, code, agency);
         this.priceDay = priceDay;
         this.costAuto = costAuto;
         this.pricePage = pricePage;
     }
 
     @Override
    public String getDescription() { // Getter for description of the advertisement type
         return super.getDescription();
     }
 
     @Override
    public int getCode() { // Getter for code of the advertisement
         return super.getCode();
     }
 
     @Override
    public AdvertisingAgency getAgency() { // Getter for the agency which provides the ad type and has a tax number
         return super.getAgency();
     }
 
    public int getPriceDay() { // Getter for price of ad per day
         return priceDay;
     }
 
    public int getCostAuto() { // Getter for price of automatic refresh
         return costAuto;
     }
 
    public int getPricePage() { // Getter for price of every extra page
         return pricePage;
     }
 
     @Override
     public String toString() { // toString method for InternetType
         return super.toString() + "\nPrice per Day: " + this.priceDay + "\nAutomatic Refresh Cost: " + this.costAuto
                 + "\nPrice for every Extra Page: " + this.pricePage;
     }
 }