public  class AdvertisementType { // AdvertisementType class
    private String description; // description of the advertisement type
    private int code; // code of the advertisement 
    private AdvertisingAgency agency; // the agency which provides the ad type and has a tax number

    public AdvertisementType(String description, int code,AdvertisingAgency agency) { // Constructor for AdvertisementType
        this.description = description;
        this.code = code;
        this.agency = agency;
    }

    public String getDescription() { // Getter for description of the advertisement type
        return description;
    }

    public int getCode() { // Getter for code of the advertisement
        return code;
    }

    public AdvertisingAgency getAgency() { // Getter for the agency which provides the ad type and has a tax number
        return agency;
    }

    @Override
    public String toString() { // toString method for AdvertisementType
        return "Type: " + this.getDescription() + "\nCode: " + this.getCode() + "\nAd Agency: " + this.getAgency().getBrandName()
                + "\nTax ID Number: " + this.getAgency().getIdNumber();
    }
}