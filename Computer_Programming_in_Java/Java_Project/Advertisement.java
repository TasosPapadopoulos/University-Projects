public  class Advertisement  { // Advertisement class
    private AdvertisementType codeType;// which type is the ad
    private Product product; // the product of the ad
    private int days; // the number of days that the ad lasts
    private String details; // the details of every ad

    public Advertisement(AdvertisementType codeType,Product product, 
     int days,String details) { // Constructor for Advertisement
        this.product = product;
        this.days = days;
        this.codeType = codeType;
        this.details = details;

    }

    public AdvertisementType getCodeType() { // Getter for which type is the ad
        return codeType;
    }

    public Product getProduct() { // Getter for the product of the ad
        return product;
    }

    public int getDays() { // Getter for the number of days that the ad lasts
        return days;
    }

    public int cost(){ // the cost of the ad. This method is overridden in the subclasses
         return 0;
    }

    @Override
    public String toString() { // toString method for Advertisement
        return "Type: " + this.codeType.getDescription() +"\nCode: " + this.codeType.getCode() + "\nProduct Name: " + this.product.getDescription()
                + "\nProduct Code: " +this.product.getProductCode() + "\nNumber of days: " +this.days + "\nAd Description: " + this.details;
    }
    public String toStringCost(){ // toString method for Advertisement cost.This method is overridden in the subclasses
         return "";
    }

}