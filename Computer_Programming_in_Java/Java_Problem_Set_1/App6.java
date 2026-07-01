
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.util.Scanner;

class App6 {

		public static void main (String args []) {

			Scanner scanner = new Scanner(System.in);
			
			final int feeEurosPart = 5, feeCentsPart = 24;
			
			System.out.println("-- Parking Ticket Payment --\n");
			System.out.println("Fee: " + feeEurosPart + " euros and " + feeCentsPart + " cents");
			System.out.println("Payment...");
			
			System.out.print("euros = ");
			int paidEuros = scanner.nextInt();
			System.out.print("cents = ");
			int paidCents = scanner.nextInt();
			
			
			if ((paidEuros < feeEurosPart) || (paidEuros == feeEurosPart && paidCents < feeCentsPart)) {
				System.out.println("Not enough money!");
			} else {
				int changeEurosPart = paidEuros - feeEurosPart;
				int changeCentsPart;
				if (paidCents >= feeCentsPart) {
					changeCentsPart = paidCents - feeCentsPart;
				} else {
					int difference = feeCentsPart - paidCents;
					changeCentsPart = 100 - difference;
					changeEurosPart--;
				}
				
				System.out.println("\nChange:");
				
				if (changeEurosPart >= 10) {
					System.out.println("1 (10 euro)");
					changeEurosPart -= 10;
				}
				
				if (changeEurosPart >= 5) {
					System.out.println("1 (5 euro)");
					changeEurosPart -= 5;
				}
				
				if (changeEurosPart >= 2) {
					int coinOf2euro = changeEurosPart / 2;
					System.out.println(coinOf2euro + " (2 euro)");
					changeEurosPart -= coinOf2euro * 2;
				}
				
				if (changeEurosPart >= 1) {
					System.out.println("1 (1 euro)");
					changeEurosPart -= 1;
				}
				
				if (changeCentsPart >= 50) {
					System.out.println("1 (50 cents)");
					changeCentsPart -= 50;
				}
				
				if (changeCentsPart >= 20) {
					int coinsOf20cents = changeCentsPart / 20;
					System.out.println(coinsOf20cents + " (20 cents)");
					changeCentsPart -= coinsOf20cents * 20;
				}
				
				if (changeCentsPart >= 10) {
					System.out.println("1 (10 cents)");
					changeCentsPart -= 10;
				}
				
				if (changeCentsPart >= 5) {
					System.out.println("1 (5 cents)");
					changeCentsPart -= 5;
				}
				
				if (changeCentsPart >= 2) {
					int coinsOf2cents = changeCentsPart / 2;
					System.out.println(coinsOf2cents + " (2 cents)");
					changeCentsPart -= coinsOf2cents * 2;
				}
				
				if (changeCentsPart >= 1) {
					System.out.println("1 (1 cent)");
					changeCentsPart -= 1;
				}

			}
			
			scanner.close();
		
	}	
}
