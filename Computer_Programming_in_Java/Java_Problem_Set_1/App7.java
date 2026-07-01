/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.util.Scanner;

class Product {
	
	private String productCode;				// mandatory
	private String manufacturingCompany;	// mandatory
	private String model;					// mandatory
	private float priceOfTheProduct;		// optional
	private int stockInWarehouse;			// optional
	
	public Product(String code, String company, String model) {
		productCode = code;
		manufacturingCompany = company;
		this.model = model;
		priceOfTheProduct = 0;
		stockInWarehouse = 0;
	}
	
	public Product(String code, String company, String model, float price, int stockAmount) {
		productCode = code;
		manufacturingCompany = company;
		this.model = model;
		priceOfTheProduct = price;
		stockInWarehouse = stockAmount;
	}
	
	public Product() {
		
	}
	
	public void setPriceOfTheProduct(float price) {
		priceOfTheProduct = price;
	}
	
	public void setStockInWarehouse(int stockAmount) {
		stockInWarehouse = stockAmount;
	}
	
	public float getPriceOfTheProduct() {
		return priceOfTheProduct;
	}
	
	public int updateStockInWarehouse(int supplyOfAProduct) {
		stockInWarehouse += supplyOfAProduct;
		return stockInWarehouse;
	}
	
	public int sellProduct(int amount) {
		if (amount <= stockInWarehouse) {
			stockInWarehouse -= amount;
			return stockInWarehouse;
		}
		return -1;
	}
	
	public String toString() {
		
		return ("Product\n"
			  + "-------------------------\n"
			  + "code:           " + productCode + "\n"
			  + "factory:        " + manufacturingCompany + "\n"
			  + "model:          " + model + "\n"
			  + "price:          " + priceOfTheProduct + "\n"
			  + "stock:          " + stockInWarehouse + "\n"
			  + "-------------------------");
		
	}
	
}

class App7 {
	
	public static void main(String args[]){ 

		Scanner scanner = new Scanner(System.in);
		
		Product product001 = new Product("p001", "Mobile Phones", "A21");
		
		System.out.println(product001);
		
		System.out.print("price = ");
		float price = scanner.nextFloat();
		product001.setPriceOfTheProduct(price);
		
		System.out.print("stock = ");
		int stock = scanner.nextInt();
		product001.setStockInWarehouse(stock);
		
		System.out.println(product001);
		
		System.out.print("sale = ");
		int sale = scanner.nextInt();
		int isTheStockEnough = product001.sellProduct(sale);
		if (isTheStockEnough != -1) {
			System.out.println("New stock = " + isTheStockEnough);
			float totalPay = sale * product001.getPriceOfTheProduct();
			System.out.printf("Amount to pay = %11.2f\n" ,totalPay);
		} else {
			System.out.println("Not enough stock to complete sale");
		}
		
		System.out.println(product001);
		
		System.out.print("supply = ");
		int supply = scanner.nextInt();
		System.out.println("New stock = " + product001.updateStockInWarehouse(supply));;
		
		Product product002 = new Product("p002", "Mobile Phones", "B21", 191, 50);
		
		System.out.println(product002);
		
		scanner.close();
		
	}	
}