public class PaperAdvertisement extends Advertisement{ // PaperAdvertisement class which extends Advertisement
    private int numberW;// the number of words
    private String position; // the position on paper



    public PaperAdvertisement(AdvertisementType codeType, Product product,String details,
    int days, int numberW,int position) { // Constructor for PaperAdvertisement
        super(codeType, product, days, details);
        this.numberW = numberW;
        switch (position){
            case 1 -> this.position = "First";
            case 2 -> this.position = "Middle";
            default -> this.position = "Last";
        }
    }

    @Override
     public int cost() { // cost method for PaperAdvertisement which calculates the cost of the advertisement
        int cost = 0;
        switch (position.toUpperCase().charAt(0)){
            case 'F' -> cost = ((PaperType)getCodeType()).getPriceFirst() * numberW * getDays(); 

            // if the position is first, the cost is the price of the first word * number of words * number of days

            case 'M' -> cost = ((PaperType)getCodeType()).getPriceMiddle() * numberW * getDays();

            // if the position is middle, the cost is the price of the middle word * number of words * number of days

            default -> cost = ((PaperType)getCodeType()).getPriceLast() * numberW *getDays();
            
            // if the position is last, the cost is the price of the last word * number of words * number of days
        }
        return cost; // return the cost
    }

     int getNumberW() {  // Getter for the number of words
        return numberW;
    }

     String getPosition() { // Getter for the position on paper
        return position;
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
    public String toString() {
         // toString method for PaperAdvertisement which prints the details of the advertisement
        return super.toString() + "\nNumber of words: " + this.numberW + "\nPosition in the paper: " + this.position;
    }
    public String toStringCost(){
        // toString method for PaperAdvertisement which prints the details of the advertisement and the cost
        return toString() + "\nTotal Cost: " +cost()+"$" ;
    }

}