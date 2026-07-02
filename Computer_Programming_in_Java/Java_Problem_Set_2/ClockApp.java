
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class ClockApp {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		Clock clock = new Clock();
		
		System.out.print("Hour? ");
		int h = in.nextInt();
		in.nextLine();
		System.out.print("Minutes? ");
		int m = in.nextInt();
		in.nextLine();
		System.out.print("Seconds? ");
		int s = in.nextInt();
		in.nextLine();
		
		clock.setHour(h);
		clock.setMin(m);
		clock.setSec(s);
		
		System.out.println(clock);
		for (int i = 0; i < 180; i++) {
			clock.tick();
			TimeUnit.SECONDS.sleep(1);
			System.out.println(clock);
		}
		
		in.close();
		
	}

}
