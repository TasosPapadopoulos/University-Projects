
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

public class CustomerList {
	
	Customer myList[] = new Customer[50];
	
	void InsertCustomer(String name, String code, int day, int month, int year) {
		
		
		for (int i = 0; i < 50; i++) {
			
			if (myList[i] == null) {
				myList[i] = new Customer(name, code, day, month, year);
				break;
			}
			
		}
		
	}
	
	void LookupCustomer(String code) {
		
		for (Customer c : myList) {
			
			if (c == null) {
				System.out.println("There isn't any customer with this code.");
				break;
			} else {
				if (c.getCode().contains(code)) {
					System.out.println("Name: " + c.getName() + "\nRegistration " + c.getDate());
					break;
				}
			}
			
		}
		
	}
	
	void DisplayList() {
		for (int i = 0; i < 50; i++) {
			
			if (myList[i] == null) {
				break;
			}
			System.out.println("\n" + myList[i]);
			
		}
	}
	
}
