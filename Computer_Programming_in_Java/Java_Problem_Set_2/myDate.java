
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

public class myDate {
	
	private int day;
	private int month;
	private int year;
	
	public myDate(int d, int m, int y) {
		day = d;
		month = m;
		year = y;
	}
	
	void setDay(int day) {
		this.day = day;
	}
	
	void setMonth(int month) {
		this.month = month;
	}
	
	void setYear(int year) {
		this.year = year;
	}
	
	int getDay() {
		return day;
	}
	
	int getMonth() {
		return month;
	}
	
	int getYear() {
		return year;
	}
	
	public String toString() {
		return "Date: " + getDay() + "/" + getMonth() + "/" + getYear();
	}
	
}
