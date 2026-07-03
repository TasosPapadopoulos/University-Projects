import java.util.*;
import java.util.concurrent.TimeUnit;

public class mainApp  {
    static Scanner scanner = new Scanner(System.in);// adding an instance of the Scanner class for input
    // the instance is static so that it can be used in all methods of the class that is needed

    public static void main(String[] args) throws Exception{


        //--------------Initializing The Four Lists Of Our Classes-----------------

        List<AdvertisementType> adTypes = new ArrayList<>();
        List<AdvertisingAgency> adAgencies = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Advertisement> ads = new ArrayList<>();

        //------------------Adding Advertisement Agencies---------------------------

        adAgencies.add(new AdvertisingAgency(12345, "Telecom"));
        adAgencies.add(new AdvertisingAgency(13242, "Teleperformance"));
        adAgencies.add(new AdvertisingAgency(23456, "Televise"));
        adAgencies.add(new AdvertisingAgency(56742, "AdWorld"));

        //-----------------Adding Products for Advertisements-----------------------

        products.add(new Product(12423, "Dish Washer", 678535));
        products.add(new Product(43595, "Coffee Machine", 345246));
        products.add(new Product(23563, "Dry Cleaner", 789642));
        products.add(new Product(43652, "Speakers", 473246));


        //------------------------------Adding Advertisement Types----------------------------------------

        adTypes.add(new PaperType("Paper 1", 100, adAgencies.get(0), 150, 60, 100));
        adTypes.add(new TvRadioType("Radio 1", 100, adAgencies.get(2), 200, 120, 150, 220));
        adTypes.add(new InternetType("Internet 1", 100, adAgencies.get(1), 300, 40, 150));
        adTypes.add(new PaperType("Paper 2", 101, adAgencies.get(3), 180, 80, 120));
        adTypes.add(new TvRadioType("Television 1", 101, adAgencies.get(0), 240, 140, 130, 240));
        adTypes.add(new InternetType("Internet 2", 101, adAgencies.get(3), 250, 30, 120));
        adTypes.add(new PaperType("Paper 3", 102, adAgencies.get(2), 170, 80, 130));
        adTypes.add(new TvRadioType("Radio 2", 102, adAgencies.get(1), 150, 80, 110, 130));
        adTypes.add(new InternetType("Internet 3", 102, adAgencies.get(0), 180, 30, 120));

        //------------------------------Adding Advertisements----------------------------------------------

        ads.add(new PaperAdvertisement(adTypes.get(0), products.get(1), "First Page add", 6, 70, 1));
        ads.add(new PaperAdvertisement(adTypes.get(0), products.get(3), "Middle Page add", 7, 50, 2));
        ads.add(new PaperAdvertisement(adTypes.get(0), products.get(2), "Tiny LastPage add", 3, 34, 3));
        ads.add(new PaperAdvertisement(adTypes.get(0), products.get(0), "Long FrontPage add", 10, 70, 1));

        ads.add(new TvRadioAdvertisement(adTypes.get(1), products.get(2), "short afternoon reel", 20, 7, 3));
        ads.add(new TvRadioAdvertisement(adTypes.get(1), products.get(1), "9:30", 14, 10, 1));
        ads.add(new TvRadioAdvertisement(adTypes.get(1), products.get(2), "Long add", 4, 25, 2));
        ads.add(new TvRadioAdvertisement(adTypes.get(1), products.get(3), "Night add", 8, 20, 4));

        ads.add(new InternetAdvertisement(adTypes.get(2), products.get(0), "Expensive add", 5, 1, 3));
        ads.add(new InternetAdvertisement(adTypes.get(2), products.get(3), "Singe page add", 7, 0, 0));
        ads.add(new InternetAdvertisement(adTypes.get(2), products.get(2), "3Page add", 10, 1, 2));
        ads.add(new InternetAdvertisement(adTypes.get(2), products.get(0), "Multiple Pages", 3, 0, 4));

        ads.add(new PaperAdvertisement(adTypes.get(3), products.get(1), "Short time add", 3, 78, 2));
        ads.add(new PaperAdvertisement(adTypes.get(3), products.get(3), "One week add ", 7, 45, 3));
        ads.add(new PaperAdvertisement(adTypes.get(3), products.get(2), "Morning paper add", 1, 23, 1));
        ads.add(new PaperAdvertisement(adTypes.get(3), products.get(3), "60 words add", 4, 60, 2));

        ads.add(new TvRadioAdvertisement(adTypes.get(4), products.get(2), "21:30", 3, 11, 4));
        ads.add(new TvRadioAdvertisement(adTypes.get(4), products.get(2), "8:00", 5, 16, 1));
        ads.add(new TvRadioAdvertisement(adTypes.get(4), products.get(1), "Long", 4, 23, 4));
        ads.add(new TvRadioAdvertisement(adTypes.get(4), products.get(0), "Afternoon", 12, 10, 3));

        ads.add(new InternetAdvertisement(adTypes.get(5), products.get(3), "Auto Appeared", 4, 1, 2));
        ads.add(new InternetAdvertisement(adTypes.get(5), products.get(2), "Short", 6, 0, 0));
        ads.add(new InternetAdvertisement(adTypes.get(5), products.get(0), "Long run", 12, 1, 1));
        ads.add(new InternetAdvertisement(adTypes.get(5), products.get(1), "No extra pages", 2, 1, 0));

        ads.add(new PaperAdvertisement(adTypes.get(6), products.get(1), "First paged", 2, 24, 1));
        ads.add(new PaperAdvertisement(adTypes.get(6), products.get(2), "Last paged", 5, 45, 3));
        ads.add(new PaperAdvertisement(adTypes.get(6), products.get(3), "Long", 14, 67, 2));
        ads.add(new PaperAdvertisement(adTypes.get(6), products.get(2), "Many days", 6, 34, 1));

        ads.add(new TvRadioAdvertisement(adTypes.get(7), products.get(1), "30sec", 12, 30, 1));
        ads.add(new TvRadioAdvertisement(adTypes.get(7), products.get(2), "Many days", 20, 12, 3));
        ads.add(new TvRadioAdvertisement(adTypes.get(7), products.get(3), "Late night", 10, 34, 4));
        ads.add(new TvRadioAdvertisement(adTypes.get(7), products.get(0), "Lunch time", 15, 25, 2));

        ads.add(new InternetAdvertisement(adTypes.get(8), products.get(2), "2 extras", 3, 1, 2));
        ads.add(new InternetAdvertisement(adTypes.get(8), products.get(1), "dozen days", 12, 0, 1));
        ads.add(new InternetAdvertisement(adTypes.get(8), products.get(3), "no auto appeared", 4, 0, 4));
        ads.add(new InternetAdvertisement(adTypes.get(8), products.get(0), "1 week", 7, 1, 0));

        //--------------------------------------The Menu Of The App----------------------------------------------------
        boolean isRunning = true;
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\tWelcome to our Advertisement menu!!!");
        while (isRunning) {
            int menuChoice;
            TimeUnit.SECONDS.sleep(2);
            System.out.println("\nPlease select one of the following options:");
            System.out.println("""
                    \t1. For adding a new advertising agency
                    \t2. For adding a new advertising type
                    \t3. For adding a new advertisement
                    \t4. For displaying all advertisements
                    \t5. For displaying all advertisements of an agency
                    \t6. For calculation of total advertisement cost of an agency
                    \t7. For displaying all advertisements by product
                    \t8. For calculation of total advertisement cost of a product
                    \t9. For displaying total advertisement cost of all products
                    \t10.For exiting the menu""");
            menuChoice = isValid(1, 10);
            switch (menuChoice) { //The switch case for the menu options of the app

                  case 1 -> {  //Adding a new advertising agency
                    String brandName = ""; //The brand name of the agency that will be added

                    int idNumber=0; //The tax ID number of the agency that will be added

                    boolean isThere = false; //A boolean variable that will be used to check if the brand name is already in the list

                    while (!isThere){
                        System.out.print("Enter the brand name of the agency: ");
                        TimeUnit.SECONDS.sleep(1);
                        brandName = scanner.next();
                        System.out.println("Please wait...");
                        TimeUnit.SECONDS.sleep(2);
                        for (AdvertisingAgency adAgency : adAgencies) { //This loop will check if the brand name is already in the list
                            if (adAgency.getBrandName().equalsIgnoreCase(brandName)) { 

                                // If the brand name is already in the list, the user will be asked to enter a new one

                                System.out.println("The brand name you added is already in the list, please try again!!\n");
                                TimeUnit.SECONDS.sleep(2); 
                                break;
                            }
                            isThere = true; //The boolean variable will be true and the while loop will continue 
                            break;
                        }
                    }
                    System.out.println("Brand name has been saved successfully!!\n");
                    TimeUnit.SECONDS.sleep(1);
                    isThere = false; //The boolean variable will be false again for the Tax Id number 
                    while (!isThere){ 
                        System.out.print("Enter the tax ID number of the agency: ");
                        TimeUnit.SECONDS.sleep(1);
                        idNumber = scanner.nextInt();
                        System.out.println("Please wait...");
                        TimeUnit.SECONDS.sleep(2);
                        for (AdvertisingAgency adAgency : adAgencies) { //This loop will check if the tax ID number is already in the list
                            if (adAgency.getIdNumber() == idNumber) { 
                                // If the tax ID number is already in the list, the user will be asked to enter a new one

                                System.out.println("There is already an advertising agency with that ID number, please try again!!\n");
                                TimeUnit.SECONDS.sleep(1);
                                break;
                            }
                            isThere = true; //The boolean variable will be true and the while loop will continue
                            break;
                        }
                    
                    }
                    // If the tax ID number is not in the list, the user will be informed that the agency has been added

                    System.out.println("The ID tax number has been saved successfully!!\n");
                    TimeUnit.SECONDS.sleep(1);
                    adAgencies.add(new AdvertisingAgency(idNumber, brandName.substring(0,1).toUpperCase()+brandName.substring(1)));
                    System.out.println("New Advertising agency added!!\n\n");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Values are the following:\n" + adAgencies.get(adAgencies.size()-1).toString());
                    TimeUnit.SECONDS.sleep(3);
                }
                case 2 -> { //Adding a new advertising type
                    boolean isValid = false; //A boolean variable that will be used to check if the ID code that is given is valid
                    while (!isValid) {
                        System.out.print("Enter the tax ID code of the agency which has the type: ");
                        int taxIdNumber = scanner.nextInt();
                        System.out.println("Please wait...");
                        TimeUnit.SECONDS.sleep(2);
                        for (AdvertisingAgency adAgency : adAgencies) { //This loop will check if the tax ID number is in the list
                            if (taxIdNumber == adAgency.getIdNumber()) {  
                                System.out.println("\nSelect one of the following options for advertisement types:");

                                // If the tax ID number is in the list, the user will be asked to select one of the following options

                                System.out.println("""
                                        \t 1. For Paper advertisement type
                                        \t 2. For Radio or Television advertisement type
                                        \t 3. For Internet advertisement type
                                        """);
                                int numberType = isValid(1, 3);
                                int count = 0; //A counter that will be used to count the number of advertisement types of the same type
                                switch (numberType) {
                                    case 1 -> {

                                        // If the user selects the first option, the user will be asked to enter the values for the Paper advertisement type

                                        System.out.print("Enter the price for a FirstPage ad: ");
                                        int priceFirst = scanner.nextInt();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.print("Enter the price for a MiddlePage ad: ");
                                        int priceMiddle = scanner.nextInt();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.print("Enter the price for a LastPage ad: ");
                                        int priceLast = scanner.nextInt();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        for (AdvertisementType adType : adTypes) { //This loop will count the number of advertisement types of the same type
                                            if (adType instanceof PaperType) {
                                                count++; //The counter will be increased by one
                                            }
                                        }
                                        // this loop is used in order to create the description and the code of the next advertisement type that will be added
                                        
                                        adTypes.add(new PaperType("Paper " + (count+1), count + 100, adAgency,
                                                priceFirst, priceMiddle, priceLast));

                                            // The new advertisement type will be added in the list of advertisement types 
                                            // and the user will be informed that the type has been added

                                        System.out.println("New Paper Advertisement Type added!!\n\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Values are the following:\n" + adTypes.get(adTypes.size()-1).toString());
                                    }
                                    case 2 -> { 
                                        //If the user selects the second option, the user will be asked to enter the values for the Radio or Television advertisement type

                                        System.out.print("Enter the price of the type in the Morning: ");
                                        int priceMorning = scanner.nextInt();
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.print("Enter the price of the type in the Noon: ");
                                        int priceNoon = scanner.nextInt();
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.print("Enter the price of the type in the Afternoon: ");
                                        int priceAfternoon = scanner.nextInt();
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.print("Enter the price of the type in the Night: ");
                                        int priceNight = scanner.nextInt();
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        // The user will be asked to select one of the following options

                                        System.out.println("""
                                                \n  Please select one of the following options:
                                                \t 1. Radio advertisement type
                                                \t 2. Television advertisement type
                                                """);
                                        int choice = isValid(1, 2);
                                        if (choice == 1) {
                                            // If the user selects the first option, the new advertisement type will be a Radio advertisement type
                                            for (AdvertisementType adType : adTypes) {
                                                if (adType instanceof TvRadioType && adType.getDescription().charAt(0) == 'R') {
                                                    count++;
                                                }
                                                // This loop will count the number of Radio advertisement types that are in the list
                                                // We use this loop to create the description and the code of the next advertisement type that will be added
                                            }
                                            // The new advertisement type will be added in the list of advertisement types

                                            adTypes.add(new TvRadioType("Radio " + (count+1), count + 100, adAgency, priceMorning,
                                                    priceNoon, priceAfternoon, priceNight));

                                                    // The user will be informed that the type has been added

                                            System.out.println("New Radio Advertisement type has been added successfully!!\n");
                                        } else {
                                            // If the user selects the second option, the new advertisement type will be a Television advertisement type
                                            for (AdvertisementType adType : adTypes) {
                                                if (adType instanceof TvRadioType && adType.getDescription().charAt(0) == 'T') {
                                                    count++;
                                                }
                                                // This loop will count the number of Television advertisement types that are in the list
                                                // We use this loop to create the description and the code of the next advertisement type that will be added
                                            }
                                            adTypes.add(new TvRadioType("Television " + (count+1), count + 100, adAgency, priceMorning,
                                                    priceNoon, priceAfternoon, priceNight));
                                                    // The new advertisement type will be added in the list of advertisement types
                                            System.out.println("New Television Advertisement type has been added successfully!!\n");
                                            // The user will be informed that the type has been added

                                        }
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Values are the following:\n" + adTypes.get(adTypes.size()-1).toString());
                                    }
                                    default -> {

                                        // If the user selects the third option, the user will be asked to enter the values for the Internet advertisement type

                                        System.out.print("Enter the everyday price of the First page of the ad type: ");
                                        int priceDay = scanner.nextInt();
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.print("Enter the price for Automatic Refresh: ");
                                        int autoRefresh = scanner.nextInt();
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.print("Enter the price of every extra page: ");
                                        int extraPagePrice = scanner.nextInt();
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The price has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        for (AdvertisementType adType : adTypes) {
                                            if (adType instanceof InternetType) {
                                                count++;
                                            }
                                            // This loop will count the number of Internet advertisement types that are in the list
                                            // We use this loop to create the description and the code of the next advertisement type that will be added
                                        }
                                        adTypes.add(new InternetType("Internet " + (count+1), count + 100, adAgency,
                                                priceDay, autoRefresh, extraPagePrice));
                                                // The new advertisement type will be added in the list of advertisement types
                                                // The user will be informed that the type has been added
                                        System.out.println("New Internet Advertisement type has been added successfully!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Values are the following:\n" + adTypes.get(adTypes.size()-1).toString());
                                    }
                                }
                                isValid = true;
                                break;
                                // The loop will be terminated
                            }
                        }
                        if (!isValid) {
                            // If the user enters a  tax ID Number that doesen't belong to an ad agency, the user will be informed and the loop will be repeated
                            System.out.println("There is no advertising agency with this tax ID Number, please try again!!\n");
                        }
                        TimeUnit.SECONDS.sleep(3);
                    }
                }
                case 3 -> {// Adding a new advertisement
                    // The user will be asked to enter the values for the new advertisement
                    System.out.print("Enter the timeline of the ad in days: ");
                    int days = scanner.nextInt();
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("Please wait...");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println("The timeline has been saved successfully!!!\n");
                    TimeUnit.SECONDS.sleep(1); 
                    System.out.println("Select which product you want to advertise:");
                    TimeUnit.SECONDS.sleep(2);
                    int number = 1; // This variable will be used to print the products that are in the list in an order
                    for(Product product : products){ 
                        // This loop will print all the products that are in the list
                        System.out.println(number+".\n" + product);
                        TimeUnit.SECONDS.sleep(2);
                        number++;
                    }
                    int choice = isValid(1,products.size());

                    int productCode = products.get(choice-1).getProductCode(); // The product code of the product that the user selected
                    for (Product product : products) {
                        // This loop will search for the product that the user selected
                        if (productCode == product.getProductCode()) { 
                            // If the product is found, the user will be asked to enter the type for the new advertisement
                            System.out.println("Please select one of the following options: ");
                            System.out.println("""
                                    \t\t1. For Paper advertisement
                                    \t\t2. For Tv or Radio advertisement
                                    \t\t3. For Internet advertisement
                                    """);
                            choice = isValid(1, 3);
                            int adChoice; // This variable will be used to store the advertisement type choice of the user
                            String description; // This variable will be used to store the description of the new advertisement
                            number=1; // This variable will be used to print the advertisement types of the same t that are in the list in an order
                            switch (choice) {
                                case 1 -> {
                                    // If the user selects the first option, the new advertisement type will be a Paper advertisement type
                                    // the user will be asked to enter the description of the new advertisement

                                        System.out.print("Enter the description of the ad in a one word:\t");
                                        description = scanner.next();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The description has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please select one of the following Paper advertisement types: ");
                                        TimeUnit.SECONDS.sleep(2);
                                        // This loop will print all the Paper advertisement types that are in the list
                                        for (AdvertisementType type : adTypes) {
                                            if (type instanceof PaperType) {
                                                System.out.println(number + ".\n" + type + "\n");
                                                TimeUnit.SECONDS.sleep(2);
                                                number++;
                                            }
                                        }
                                        adChoice = isValid(1, number); // The user will be asked to select one of the Paper advertisement types

                                        // The user will be asked to enter the number of words of the new advertisement

                                        System.out.print("Give me the number of words of the ad: ");
                                        int words = scanner.nextInt();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The number of words has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);

                                        // The user will be asked to select the position of the new advertisement

                                        System.out.println("Select one of the following options for the position of the ad:\n");
                                        System.out.println("""
                                                1. First Page
                                                2. Second Page
                                                3. Last Page
                                                """);
                                        int position = isValid(1, 3);
                                        number = 1; // this variable will be used to check which Paper advertisement type the user selected
                                        for (AdvertisementType adType : adTypes) { 
                                            // This loop will search for the Paper advertisement type that the user selected
                                            if (adType instanceof PaperType){ 
                                                if(number == adChoice) {
                                                    // When the Paper advertisement type is found, the new advertisement will be added in the list

                                                    ads.add(new PaperAdvertisement(adType, product, description, days, words, position));

                                                    // The user will be informed that the new advertisement has been added

                                                    System.out.println("New Paper Advertisement  added!!\n\n");
                                                    TimeUnit.SECONDS.sleep(1);
                                                    System.out.println("Values are the following:\n" + ads.get(ads.size()-1).toString());
                                                    break;
                                                }
                                                number++;
                                            }
                                        }
                                    }
                                case 2 -> {
                                    // If the user selects the second option, the new advertisement type will be a Tv or Radio advertisement type
                                    // the user will be asked to enter the description of the new advertisement

                                        System.out.print("Enter the description of the ad in one word:\t");
                                        description = scanner.next();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The description has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);

                                        // The user will be asked to select one of the Tv or Radio advertisement types

                                        System.out.print("Please select one of the following Television or Radio advertisement types:\n");
                                        TimeUnit.SECONDS.sleep(2);
                                        for (AdvertisementType type : adTypes) {
                                            if (type instanceof TvRadioType) {

                                                // This loop will print all the Tv or Radio advertisement types that are in the list

                                                System.out.println(number + ".\n" + type + "\n");
                                                TimeUnit.SECONDS.sleep(2);
                                                number++;
                                            }
                                        }
                                        adChoice = isValid(1, number);

                                        // The user will be asked to enter the number of seconds of the new advertisement

                                        System.out.print("Enter the number of seconds of the ad: ");
                                        int sec = scanner.nextInt();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The number of seconds has been saved successfully!!!\n");
                                        TimeUnit.SECONDS.sleep(1);

                                        // The user will be asked to select the time of the new advertisement

                                        System.out.println("Select one of the following options for the time of the ad\n");
                                        System.out.println("""
                                                1. Morning
                                                2. Noon
                                                3. Afternoon
                                                4. Night
                                                """);
                                        int time = isValid(1, 4);
                                        number = 1;
                                        for (AdvertisementType adType : adTypes) {
                                            // This loop will search for the Tv or Radio advertisement type that the user selected
                                            if (adType instanceof TvRadioType) {
                                                if(number == adChoice) {

                                                    // When the Tv or Radio advertisement type is found, the new advertisement will be added in the list

                                                    ads.add(new TvRadioAdvertisement(adType, product, description, days, sec, time));

                                                    // The user will be informed that the new advertisement has been added

                                                    System.out.println("New TvRadio Advertisement  added!!\n\n");
                                                    TimeUnit.SECONDS.sleep(1);
                                                    System.out.println("Values are the following:\n" + ads.get(ads.size()-1).toString());
                                                    break;
                                                }
                                                number++;
                                            }
                                        }
                                    }
                                default -> {
                                    // If the user selects the third option, the new advertisement type will be an Internet advertisement type
                                    // the user will be asked to enter the description of the new advertisement
                                        System.out.print("Enter the description of the ad in one word:\t");
                                        description = scanner.next();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The description has been saved successfully!!!\n");
                                        System.out.println("Please select one of the following Internet advertisement types: ");
                                        TimeUnit.SECONDS.sleep(2);
                                        for (AdvertisementType type : adTypes) {

                                            // This loop will print all the Internet advertisement types that are in the list

                                            if (type instanceof InternetType) {
                                                System.out.println(number + ".\n" + type + "\n");
                                                TimeUnit.SECONDS.sleep(2);
                                                number++;
                                            }
                                        }
                                        adChoice = isValid(1, number);

                                        // The user will be asked to select if he wants the automatic refresh option

                                        System.out.println("Would you like to have the automatic refresh option?");                                      
                                        System.out.println("""
                                                \nSelect:
                                                \t\t\t 1. Yes
                                                \t\t\t 2. No
                                                """);
                                        int option = isValid(1, 2) - 1;

                                        // The user will be asked to enter the number of extra pages of the new advertisement

                                        System.out.print("Enter the number of extra pages you want to have on the ad: ");
                                        int extra = scanner.nextInt();
                                        TimeUnit.SECONDS.sleep(1);
                                        System.out.println("Please wait...");
                                        TimeUnit.SECONDS.sleep(2);
                                        System.out.println("The number of pages has been saved successfully!!!\n");
                                        number = 1;
                                        for (AdvertisementType adType : adTypes) {
                                            // This loop will search for the Internet advertisement type that the user selected
                                            if (adType instanceof InternetType) {
                                                if(number == adChoice) {

                                                    // When the Internet advertisement type is found, the new advertisement will be added in the list

                                                    ads.add(new InternetAdvertisement(adType, product, description, days, option, extra));
                                                    System.out.println("New Internet Advertisement  added!!\n\n");
                                                    TimeUnit.SECONDS.sleep(1);
                                                    // The user will be informed that the new advertisement has been added
                                                    System.out.println("Values are the following:\n" + ads.get(ads.size()-1).toString());
                                                    break;
                                                }
                                                number++;
                                            }
                                        }
                                    }
                            }
                        }
                    }
                    TimeUnit.SECONDS.sleep(3);
                }
                case 4 -> { // Print all the advertisements that are in the list
                    System.out.println("Here are all the advertisements");
                    TimeUnit.SECONDS.sleep(1);
                    // This loop will print all the advertisements that are in the list
                    for (int i = 0; i < ads.size(); i++) {
                        System.out.println((i+1) + ".\n" + ads.get(i).toString() + "\n");
                        TimeUnit.SECONDS.sleep(1);
                    }
                    TimeUnit.SECONDS.sleep(2);
                }
                case 5 -> { // Print all the advertisements of a specific advertising agency
                    System.out.println("Select one of the following Advertising Agencies: ");
                    TimeUnit.SECONDS.sleep(1);
                    for (int i = 0; i < adAgencies.size(); i++) {

                        // This loop will print all the advertising agencies that are in the list

                        System.out.println((i + 1) + ".\n" + adAgencies.get(i).toString() + "\n");
                        TimeUnit.SECONDS.sleep(2);
                    }
                    int choice = isValid(1,adAgencies.size());
                    System.out.println("Advertisements of the following agency:\n\n" + adAgencies.get(choice - 1).toString() + "\n");
                    TimeUnit.SECONDS.sleep(1);
                    int count = 1; // This variable will be used to print by order the advertisements that belong to the advertising agency that the user selected
                    for (AdvertisementType adType : adTypes) {
                        // This loop will search for the advertisement type that belongs to the advertising agency that the user selected
                        if (adAgencies.get(choice - 1) == adType.getAgency()) {
                            // Checking which advertisement types belong to the advertising agency that the user selected
                            for (Advertisement ad : ads) {
                                // This loop will search for the advertisements that belong to the advertisement type of above 
                                if (ad.getCodeType() == adType) {
                                    // Printing the advertisements that belong to the advertisement type
                                    System.out.println(count + ".\n" + ad + "\n");
                                    TimeUnit.SECONDS.sleep(2);
                                    count++;
                                }
                            }
                        }
                    }
                    System.out.println("All of the ads of the Agency: "+adAgencies.get(choice-1).getBrandName()
                            +",have been shown successfully!!\n");
                    TimeUnit.SECONDS.sleep(3);
                }
                case 6 -> { // Calculate and print the total cost of a specific advertising agency
                    System.out.println("Select one of the following Advertising Agencies: ");
                    TimeUnit.SECONDS.sleep(1);
                    for (int i = 0; i < adAgencies.size(); i++) {

                        // This loop will print all the advertising agencies that are in the list

                        System.out.println((i+1) + ".\n" + adAgencies.get(i).toString() + "\n");
                        TimeUnit.SECONDS.sleep(2);
                    }
                    int choice = isValid(1,adAgencies.size());
                    System.out.println("Total cost of advertisements of the following agency:\n" + adAgencies.get(choice - 1).toString() + "\n\n");
                    TimeUnit.SECONDS.sleep(1);
                    int count = 1; // This variable will be used to print by order the advertisements that belong to the advertising agency that the user selected
                    for (AdvertisementType adType : adTypes) {
                        // This loop will search for the advertisement type that belongs to the advertising agency that the user selected
                        if (adAgencies.get(choice - 1) == adType.getAgency()) {
                            // Checking which advertisement types belong to the advertising agency that the user selected
                            for (Advertisement ad : ads) {
                                // This loop will search for the advertisements that belong to the advertisement type of above
                                if (ad.getCodeType() == adType) {
                                    // Printing the advertisements that belong to the advertisement type
                                    System.out.println(count + ".\n" + ad.toStringCost()+"\n");
                                    TimeUnit.SECONDS.sleep(2);
                                    count++;
                                }
                            }
                        }
                    }
                    System.out.println("The cost of each advertisement of the agency: " + adAgencies.get(choice-1).getBrandName()
                    + ",has been shown successfully!!");
                    TimeUnit.SECONDS.sleep(3);
                }
                case 7 -> { // Print all the products that have been advertised and sort them by the number of advertisements 
                    for(Product product : products){

                        // This loop will count the number of advertisements that each product has
                        
                        int count = 0;
                        for (Advertisement ad : ads){
                            if(ad.getProduct()==product){
                                count++;
                            }
                        }
                        product.setNumberAd(count); // Setting the number of advertisements that each product has
                    }
                    products.sort(Comparator.comparingInt(Product::getNumberAd)); // Sorting the products by the number of advertisements
                    int place = 1; // This variable will be used to print by order the products that have been advertised
                    for (int i = products.size()-1; i>=0; i--){

                        // This loop will print all the products that have been advertised sorted from the most advertised to the least advertised

                        System.out.println(place+ ".\n" + products.get(i).toString() + "\nTotal ad count: " + products.get(i).getNumberAd());
                        TimeUnit.SECONDS.sleep(2);
                        place++;
                    }
                    System.out.println("All of the products have been show based on their ads number!!");
                    TimeUnit.SECONDS.sleep(3);
                }
                case 8 -> { // Print the total cost of all the advertisements of a specific product
                    System.out.println("Please select one of the following options:\n");
                    TimeUnit.SECONDS.sleep(1);
                    for(int i = 0; i < products.size(); i++){

                        // This loop will print all the products that are in the list

                        System.out.println((i+1)+".\n" + products.get(i).toString());
                        TimeUnit.SECONDS.sleep(2);
                    }
                    int choice = isValid(1, products.size());
                    int sum = 0;
                    int count = 1;
                    for(Advertisement ad : ads){

                        // This loop will search for the advertisements that belong to the product that the user selected

                        if(products.get(choice-1) == ad.getProduct()){

                            // Printing the advertisements that belong to the product

                            System.out.println(count+".\n"+ad.toStringCost()+"\n");
                            TimeUnit.SECONDS.sleep(2);
                            sum += ad.cost();
                            count++;
                        }
                    }
                    System.out.println("Overall:\n" + products.get(choice-1).toString() + "\nTotal Cost: " + sum+ "$");
                    TimeUnit.SECONDS.sleep(3);
                }
                case 9 -> { // Print all the products that have been advertised and sort them by the total cost of their advertisements
                    for(Product product : products){
                        // This loop will count the total cost of the advertisements that each product has
                        int count = 0; // This variable will be used to count the total cost of the advertisements that each product has
                        for (Advertisement ad : ads){
                            // This loop will search for the advertisements that belong to the product of above
                            if(ad.getProduct()==product){
                                // Calculating the total cost of the advertisements that belong to the product
                                count+= ad.cost();
                            }
                        }
                        product.setTotalAdCost(count); // Setting the total cost of the advertisements that belong to the product
                    }
                    products.sort(Comparator.comparingInt(Product::getTotalAdCost)); // Sorting the products by the total cost of their advertisements
                    int place = 1;
                    for (int i = products.size()-1; i>=0; i--){
                        // This loop will print all the products that have been advertised sorted from the most expensive to the least expensive
                        System.out.println(place+ ".\n" + products.get(i).toString() + "Total Cost Amount: "
                                + products.get(i).getTotalAdCost()+"$\n");
                        TimeUnit.SECONDS.sleep(2);
                        place++;
                    }
                    System.out.println("Products have been shown sorted based on their total ad cost amount!!");
                    TimeUnit.SECONDS.sleep(3);
                }
                default -> { // Exit the menu
                    System.out.println("Exiting the menu...");
                    TimeUnit.SECONDS.sleep(2);
                    isRunning = false;
                }

            }
        }
    }
    public static int isValid(int firstInt,int secondInt) throws Exception{ //Checks if the input is valid or not
        int value = 0;
        boolean isValid = false;
        while (!isValid){
            System.out.print("Enter the number choice you wish here: ");
             value = scanner.nextInt();
            System.out.println("Please wait...");
            TimeUnit.SECONDS.sleep(2);
            if(value >= firstInt && value <= secondInt){
                System.out.println("Great!!\n");
                TimeUnit.SECONDS.sleep(1);
                isValid = true;
            }else{
                System.out.println("There is no menu choice with that number, please try again!!\n");
                TimeUnit.SECONDS.sleep(1);
            }

        }
        return value;
    }

}