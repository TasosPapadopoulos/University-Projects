public class AdvertisingAgency { // Advertising Agency class
    private int idNumber; // Tax ID Number of the Advertising Agency
    private String brandName; // Brand Name of the Advertising Agency

    public AdvertisingAgency (int idNumber, String brandName) { // Constructor for Advertising Agency
        this.idNumber = idNumber;
        this.brandName = brandName;

    }

    public int getIdNumber() { // Getter for Tax ID Number of the Advertising Agency
        return this.idNumber;
    }

    public String getBrandName() { // Getter for Brand Name of the Advertising Agency
        return this.brandName;
    }

    public String toString() { // toString method for Advertising Agency
        return "Brand Name: " + this.brandName +"\nTax ID Number: " + this.idNumber;
    }

}