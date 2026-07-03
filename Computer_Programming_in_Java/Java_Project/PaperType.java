public class PaperType extends AdvertisementType{ // PaperType class which extends AdvertisementType class
    private int priceFirst; // price for every word in the first page
    private int priceMiddle; // price for every word in the middle pages
    private int priceLast; // price for every word in the last page

    public PaperType(String description, int code, AdvertisingAgency agency, 
    int priceFirst, int priceMiddle, int priceLast) { // Constructor for PaperType
        super(description,code,agency);
        this.priceFirst = priceFirst;
        this.priceMiddle = priceMiddle;
        this.priceLast = priceLast;
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

    public int getPriceFirst() { // Getter for price for every word in the first page
        return priceFirst;
    }

    public int getPriceMiddle() { // Getter for price for every word in the middle pages
        return priceMiddle;
    }

    public int getPriceLast() { // Getter for price for every word in the last page
        return priceLast;
    }

    @Override
    public String toString() { // toString method for PaperType
        return super.toString() + "\nFirst Page Price: " + this.priceFirst + "\nMiddle Page Price: " + this.priceMiddle
        + "\nLast Page Price: " + this.priceLast;
    }
}