
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.util.*;

public class CustomerApp {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		CustomerList myList = new CustomerList();
		boolean done = false;
		String answer, name, code;
		int day, month, year;
		
		
		
		while (!done) {
			
			System.out.println("\n1. Add Customer");
			System.out.println("2. Look up");
			System.out.println("3. List Customers");
			System.out.println("0. exit");
			System.out.print("> ");
			answer = in.nextLine();
			
			if (answer.equals("1")) {
				
				System.out.print("Name? ");
				name = in.nextLine();
				System.out.print("Code? ");
				code = in.nextLine();
				System.out.println("Resistration Date");
				System.out.print("Day? ");
				day = in.nextInt();
				in.nextLine();
				System.out.print("Month? ");
				month = in.nextInt();
				in.nextLine();
				System.out.print("Year? ");
				year = in.nextInt();
				in.nextLine();
				myList.InsertCustomer(name, code, day, month, year);
				
			} else if (answer.equals("2")) {
				
				System.out.print("Customer code to Look up? ");
   	 			code = in.nextLine();
   	 			myList.LookupCustomer(code);
				
			} else if (answer.equals("3")) {
				
				myList.DisplayList();
				
			} else if (answer.equals("0")) {
				
				done = true;
				
			}
			
		}
		
		in.close();

	}

}
