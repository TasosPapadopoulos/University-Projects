public class TvRadioAdvertisement extends Advertisement{ // TvRadioAdvertisement class which extends Advertisement
    private int sec; // how many seconds lasts the ad
    private String time; // when the ad is live on air

    public TvRadioAdvertisement(AdvertisementType codeType, Product product,
    String details,int days, int sec,int time) { // Constructor for TvRadioAdvertisement
        super(codeType, product, days, details); 
        this.sec = sec;
        switch (time){
            case 1 -> this.time = "Morning";
            case 2 -> this.time = "Noon";
            case 3 -> this.time = "Afternoon";
            default -> this.time = "Night";
        }

    }

    @Override
    public int cost() { // cost method for TvRadioAdvertisement which calculates the cost of the advertisement
        int cost = 0; // initialize the cost to 0
        switch (time.toUpperCase()){ // switch statement for the time of the day
            case "MORNING" -> cost = ((TvRadioType)getCodeType()).getPriceMorning() * sec * getDays();

            // if the time is morning, the cost is the price of the morning * number of seconds * number of days

            case "NOON" -> cost = ((TvRadioType)getCodeType()).getPriceNoon() * sec * getDays();

            // if the time is noon, the cost is the price of the noon * number of seconds * number of days

            case "AFTERNOON" -> cost = ((TvRadioType)getCodeType()).getPriceAfterNoon() * sec * getDays();

            // if the time is afternoon, the cost is the price of the afternoon * number of seconds * number of days

            default -> cost = ((TvRadioType)getCodeType()).getPriceNight() * sec * getDays();

            // if the time is night, the cost is the price of the night * number of seconds * number of days
        }
        return cost; // return the cost
    }
    @Override
    public Product getProduct() { // Getter for the product 
        return super.getProduct();
    }

    @Override
    public int getDays() { // Getter for the number of days 
        return super.getDays();
    }

    @Override
    public String toString() { // toString method for TvRadioAdvertisement which prints the details of the advertisement
        return super.toString() + "\nNumber of seconds: " + this.sec + "\nTime of the day: " + this.time;
    }
    public String toStringCost(){ // toStringCost method for TvRadioAdvertisement which prints the details of the advertisement and the cost
        return toString() + "\nTotal Cost: " +cost()+"$" ;
    }
}