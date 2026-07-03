public class Product { // Product class
    private int productCode; // Product Code of the Product
    private String description; // Description of the Product
    private int supplierTaxIDNumber; // Tax ID Number of the Supplier of the Product
    private int totalAdCost; // Total Advertising Cost of the Product in euros  
    private int numberAd; // Number of Advertisements of the Product

    public Product(int productCode, String description, int supplierTaxIDNumber) { // Constructor for Product

        this.productCode = productCode;
        this.description = description;
        this.supplierTaxIDNumber = supplierTaxIDNumber;

    }

    public int getProductCode() { // Getter for Product Code of the Product
        return this.productCode;
    }

    public String getDescription() { // Getter for Description of the Product
        return this.description;
    }

    public int getSupplierTaxIDNumber() { // Getter for Tax ID Number of the Supplier of the Product
        return this.supplierTaxIDNumber;
    }

    public int getNumberAd() { // Getter for Number of Advertisements of the Product
        return numberAd;
    }

    public void setNumberAd(int numberAd) { // Setter for Number of Advertisements of the Product
        this.numberAd = numberAd;
    }

    public int getTotalAdCost() { // Getter for Total Advertising Cost of the Product in euros
        return totalAdCost;
    }

    public void setTotalAdCost(int totalAdCost) { // Setter for Total Advertising Cost of the Product in euros
        this.totalAdCost = totalAdCost;
    }

    public String toString() { // toString method for Product
        return "Product Code:" + this.productCode +
                "\nDescription: " + this.description +
                "\nSupplier's Tax ID Number: " + this.supplierTaxIDNumber+"\n";
    }
}
