/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.util.Scanner;

class Calc {
	
	private int num1, num2;
	
	public Calc(int a, int b) {
		num1 = a;
		num2 = b;
	}
	
	Calc() {
		
	}
	
	public void setNumbers(int a, int b) {
		num1 = a;
		num2 = b;
	}
	
	public void setFirstNumber(int num) {
		num1 = num;
	}
	
	public void setSecondNumber(int num) {
		num2 = num;
	}
	
	public int productOfNumbers() {
		return num1 * num2;
	}
	
	public int sumOfNumbers() {
		return num1 + num2;
	}
	
	public String toString() {
		return "1st = " + num1 + "\n2nd = " + num2; 
	}
	
}

class App5 {		
  	
	public static void main(String args[]){
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("This program simulates a very simple pocket calculator that can add and multiply two integers.\n");
		System.out.println("Please enter two integer numbers.\n");
		System.out.println("Input:");
		System.out.print("1st = ");
		int Number1 = scanner.nextInt();
		System.out.print("2nd = ");
		int Number2 = scanner.nextInt();
		
		Calc c = new Calc(Number1, Number2);
		
		System.out.println("\nOutput:");
		System.out.println(c);
		
		System.out.println("sum = " + c.sumOfNumbers());
		System.out.println("product is = " + c.productOfNumbers());
		
		System.out.println("\nPlease enter two new integer numbers.\n");
		System.out.println("Input:");
		System.out.print("1st = ");
		Number1 = scanner.nextInt();
		System.out.print("2nd = ");
		Number2 = scanner.nextInt();
		
		c.setFirstNumber(Number1);		// Or alternatively use the method c.setNumbers(Number1, Number2);
		c.setSecondNumber(Number2);		// instead of these two methods.
		
		System.out.println("\nOutput:");
		System.out.println(c);
		
		System.out.println("sum = " + c.sumOfNumbers());
		System.out.println("product is = " + c.productOfNumbers());
		
		scanner.close();
     	
   	}

}

