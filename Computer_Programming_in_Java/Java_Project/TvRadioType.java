public class TvRadioType extends AdvertisementType{ // TvRadioType class which extends AdvertisementType class
    private int priceMorning; // price of add per second in the morning
    private int priceNoon; // price of add per second in the noon
    private int priceAfterNoon; // price of add per second in the afternoon
    private int priceNight; // price of add per second in the night

    public TvRadioType(String description, int code, AdvertisingAgency agency, 
     int priceMorning, int priceNoon, int priceAfterNoon, int priceNight) { // Constructor for TvRadioType
        super(description, code, agency);
        this.priceMorning = priceMorning;
        this.priceNoon = priceNoon;
        this.priceAfterNoon = priceAfterNoon;
        this.priceNight = priceNight;
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

    public int getPriceMorning() { // Getter for price of add per second in the morning
        return priceMorning;
    }

    public int getPriceNoon() { // Getter for price of add per second in the noon
        return priceNoon;
    }

    public int getPriceAfterNoon() { // Getter for price of add per second in the afternoon
        return priceAfterNoon;
    }

    public int getPriceNight() { // Getter for price of add per second in the night
        return priceNight;
    }

    @Override
    public String toString() { // toString method for TvRadioType
        return super.toString() + "\nPrice in the Morning: " + this.priceMorning + "\nPrice in the Noon: " + this.priceNoon
                +"\nPrice in the AfterNoon : " + this.priceAfterNoon + "\nPrice in the Night: " + this.priceNight;
    }
}