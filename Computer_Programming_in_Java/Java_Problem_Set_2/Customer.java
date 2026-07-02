
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

public class Customer {
	
	private String name;
	private String code;
	private myDate date;
	
	public Customer(String name, String code, int day, int month, int year) {
		this.name = name;
		this.code = code;
		this.date = new myDate(day, month, year);
	}
	
	String getName() {
		return name;
	}
	
	String getCode() {
		return code;
	}
	
	myDate getDate() {
		return date;
	}
	
	public String toString() {
		return "Name: " + name
			 + "\nCode: " + code
			 + "\nRegistration " + date;
	}
	
}
