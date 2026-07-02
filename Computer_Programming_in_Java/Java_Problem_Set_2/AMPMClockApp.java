
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class AMPMClockApp {

	public static void main(String[] args) throws Exception {
		
		Scanner in = new Scanner(System.in);
		
		AMPMClock clock = new AMPMClock();
		
		System.out.print("Hour? ");
		int h = in.nextInt();
		in.nextLine();
		System.out.print("Minutes? ");
		int m = in.nextInt();
		in.nextLine();
		System.out.print("Seconds? ");
		int s = in.nextInt();
		in.nextLine();
		System.out.print("12hour format with am/pm or 24 hour format? (12/24): ");
		int isAMPM = in.nextInt();
		in.nextLine();
		if (isAMPM == 12) {
			clock.setAMPM(true);
		} else {
			clock.setAMPM(false);
		}
		
		clock.setHour(h);
		clock.setMin(m);
		clock.setSec(s);
		
		System.out.println(clock.toString());
		for (int i = 0; i < 180; i++) {
			clock.tick();
			TimeUnit.SECONDS.sleep(1);
			System.out.println(clock.toString());
		}
		
		in.close();

	}

}
