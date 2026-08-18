import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Dynamic_Median {
	
	private static PQ leftHalfPQ;
	private static PQ rightHalfPQ;
	
	public static void main(String[] args) {
		
		leftHalfPQ = new PQ(new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                return c1.compareTo(c2);
            }
        });
		
		rightHalfPQ = new PQ(new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                return (-1) * c1.compareTo(c2);
            }
        });
		
		int index = 0;
		double median = 0;
		
		BufferedReader reader = null;
		City city = null;
		
		try {
			
			reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			
			while (line != null) {
				StringTokenizer st = new StringTokenizer(line, " ");
				city = new City();
				int tokenInt = Integer.parseInt(st.nextToken());
				if (1 <= tokenInt && tokenInt <= 999) {
					city.setID(tokenInt);
					String token = st.nextToken();
					if (token.length() <= 50) {
						city.setName(token);
						tokenInt = Integer.parseInt(st.nextToken());
						if (0 <= tokenInt && tokenInt <= 10000000) {
							city.setPopulation(tokenInt);
							tokenInt = Integer.parseInt(st.nextToken());
							if (tokenInt <= city.getPopulation()) {
								city.setInfluenzaCases(tokenInt);
							} else {
								System.out.println("Error! Found a city that its number of cases is bigger than the number of "
												 + "its population.");
								System.exit(0);
							}
						} else {
							System.out.println("Error! The population of a city is out of the limit of 0-10000000 which is "
											 + "allowed in this program.");
							System.exit(0);
						}
					} else {
						System.out.println("Error! The length of the name of a city is bigger than 50 characters which is "
										 + "allowed in this program.");
						System.exit(0);
					}
				} else {
					System.out.println("Error! The ID of a city is out of the limit of 1-999 that can be given in a city "
									 + "in this program.");
					System.exit(0);
				}
				
				index++;
				
				updatePQ(city);
				balanceHeaps();
				median = calculateMedian();
				if (index % 5 == 0) {
					DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
			        DecimalFormat decimalFormat = new DecimalFormat("#0.0", symbols);
			        String formattedNumber = decimalFormat.format(median);
			        System.out.println(formattedNumber);
				}
				
				line = reader.readLine();
				
			} // while
			
			reader.close();
			
		} // try
		
		catch (FileNotFoundException e) {
			System.err.println("The file that you entered cannot be found!");
			e.printStackTrace();
		}
		
		catch(IOException e) {
			System.err.println("Error Reading File.");
			e.printStackTrace();
		}
		
	}
	
	
	private static void updatePQ(City value) {
        if (leftHalfPQ.isEmpty() || value.calculateDensity() <= rightHalfPQ.min().calculateDensity()) {
        	rightHalfPQ.insert(value);
        } else {
        	leftHalfPQ.insert(value);
        }

        balanceHeaps();
        
    }
	
	
	private static void balanceHeaps() {
		
		if(rightHalfPQ.size() > leftHalfPQ.size() + 1) {
			leftHalfPQ.insert(rightHalfPQ.getmin());
		} else if (leftHalfPQ.size() > rightHalfPQ.size() + 1) {
			rightHalfPQ.insert(leftHalfPQ.getmin());
		}

    }

    private static double calculateMedian() {
        if (rightHalfPQ.isEmpty()) {
            System.out.println("No data available");
            System.exit(0);
        }

        if (rightHalfPQ.size() > leftHalfPQ.size()) {
            return rightHalfPQ.min().calculateDensity();
        } else if (rightHalfPQ.size() < leftHalfPQ.size()) {
           return leftHalfPQ.min().calculateDensity();
        } else {
        	if (rightHalfPQ.min().calculateDensity() < leftHalfPQ.min().calculateDensity()) {
        		return rightHalfPQ.min().calculateDensity();
        	} else if (rightHalfPQ.min().calculateDensity() > leftHalfPQ.min().calculateDensity()) {
        		return leftHalfPQ.min().calculateDensity();
        	} else {
        		return rightHalfPQ.min().calculateDensity();
        	}
        }
    }
    
    
    

}
