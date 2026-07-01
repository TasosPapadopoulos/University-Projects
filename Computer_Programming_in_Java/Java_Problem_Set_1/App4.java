
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/


class App4 {
	
	public static int sumOfDigits(int number) {
		
		return number == 0 ? 0 : number % 10 + sumOfDigits(number/10);
		
	}
	
	public static void main (String args[]){
		
		System.out.println(sumOfDigits(1234));
		
	}
}