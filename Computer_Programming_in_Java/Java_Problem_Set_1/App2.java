/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.util.Scanner;

class App2 {
	
		
	public static boolean isPrime(int n) {
    	
    	if (n <= 1) {
    		return false;
    	}
    	for (int i = 2; i<= n/2; i++) {
    		if (n % i == 0) {
    			return false;
    		}
    	}
    	return true;
    	
    }
		
  	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter a number to check if it is a prime number or not.");
		int number = scanner.nextInt();
		scanner.nextLine();
		
		boolean isPrimeAnswer = isPrime(number);
		
		if (isPrimeAnswer == true) {
			System.out.println("The number " + number + " is a prime number.");
		} else {
			System.out.println("The number " + number + " is not a prime number.");
		}
		
		scanner.close();
     	
   	}

}





