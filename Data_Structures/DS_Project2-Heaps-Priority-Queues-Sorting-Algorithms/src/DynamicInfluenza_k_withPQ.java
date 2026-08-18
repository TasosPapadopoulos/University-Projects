import java.io.*;
import java.util.*;
import java.io.FileNotFoundException;

public class DynamicInfluenza_k_withPQ {

	public static void main(String[] args) {
		
		int k = Integer.parseInt(args[0]);
		
		int numberOfLinesInTxtFile = 0;
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(args[1]));
			String line = reader.readLine();
		
			while (line != null) {
				line = reader.readLine();
				numberOfLinesInTxtFile++;
			}
		}
		
		catch (FileNotFoundException e) {
			System.err.println("The file that you entered cannot be found!");
			e.printStackTrace();
		}
		
		catch(IOException e) {
			System.err.println("Error Reading File.");
			e.printStackTrace();
		}
		
		if (k > numberOfLinesInTxtFile) {
			System.out.println("The number that you entered is bigger than the total number of cities in the file."
							 + "\nAs a result this program cannot be applied for the given number.");
			System.exit(0);
		} else if (k == numberOfLinesInTxtFile) {
			System.out.println("The number that you entered is the same as the total number of cities in the file."
							 + "\nAs a result the program will give you sorted, all the cities that are contained in the file.");
		}
		
		City city = null;
		
		PQ priorityQueue = new PQ(new Comparator<City>() {
            @Override
            public int compare(City c1, City c2) {
                return (-1) * c1.compareTo(c2); 
            }
        });
		
		reader = null;
		city = null;
		
		try {
			
			reader = new BufferedReader(new FileReader(args[1]));
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
				
				if (priorityQueue.size() < k) {
					priorityQueue.insert(city);
				} else {
					if (priorityQueue.min().compareTo(city) > 0) {
						priorityQueue.getmin();
						priorityQueue.insert(city);
					}
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
		
		City[] cities = new City[k];
		for(int i = k - 1; i >= 0; i--){
            cities[i] = priorityQueue.getmin();
        }
		
		System.out.println("The top k cities are:");
		for(int i=0; i < k; i++){
            System.out.println(cities[i].getName());
		}
		
	}

}
