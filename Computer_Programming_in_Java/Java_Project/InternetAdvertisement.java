public class InternetAdvertisement extends Advertisement{ // InternetAdvertisement class which extends Advertisement
    private int autoAppearance; // the values 1 or 0 of automatic appearance
    private int extraPages; // the number of extra pages in the ad

    public InternetAdvertisement(AdvertisementType codeType, Product product,
    String details, int days, int autoAppearance, int extraPages) { // Constructor for InternetAdvertisement
        super(codeType, product, days, details);
        this.autoAppearance = autoAppearance;
        this.extraPages = extraPages;
    }

    public int getAutoAppearance() { // Getter for the values 1 or 0 of automatic appearance
        return autoAppearance;
    }

    public int getExtraPages() { // Getter for the number of extra pages in the ad
        return extraPages;
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
    public int cost() { // cost method for InternetAdvertisement which calculates the cost of the advertisement
        return ((InternetType)getCodeType()).getPriceDay()*getDays() +
                autoAppearance * ((InternetType)getCodeType()).getCostAuto() +
                ((InternetType)getCodeType()).getPricePage() * extraPages;
                // the cost is the price per day * number of days + the cost of automatic appearance
                //  + the price per extra page * number of extra pages

    }

    @Override
    public String toString() { // toString method for InternetAdvertisement which prints the details of the advertisement
        return super.toString() + "\nAutomatic Appearance: " + autoAppearance + "\nNumber of Extra Pages: " + this.extraPages;
    }

    public String toStringCost(){ // toStringCost method for InternetAdvertisement which prints the details of the advertisement and the cost
        return toString() + "\nTotal Cost: " +cost()+"$" ;
    }
}