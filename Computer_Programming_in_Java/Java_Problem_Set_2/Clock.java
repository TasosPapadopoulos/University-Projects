
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

public class Clock {
	
	protected int hour;
	protected int minutes;
	protected int seconds;
	
	void setHour(int h) {
		hour = h;
	}
	
	void setMin(int m) {
		minutes = m;
	}
	
	void setSec(int s) {
		seconds = s;
	}
	
	void tick() {
		
		if (seconds < 59) {
			seconds += 1;
		} else {
			seconds = 0;
		}
		
		if (seconds == 0) {
			if (minutes < 59) {
				minutes += 1;
			} else {
				minutes = 0;
			}
		}
		
		if ((minutes == 0) && (seconds == 0)) {
			if (hour < 22) {
				hour += 1;
			} else {
				hour = 0;
			}
		}
		
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minutes, seconds);
	}
	
}
