
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

public class AMPMClock extends Clock{
	
	protected boolean yes;
	
	AMPMClock() {
		super();
	}
	
	void setAMPM(boolean yes) {
		this.yes = yes;
	}
	
	public String toString() {
		
		if (yes == true) {
			int hourAMPM =  hour % 12;
			if (hourAMPM == 0) {
				hourAMPM = 12;
			}
			String ampm = hour < 12 ? " am" : " pm";
			return String.format("%02d:%02d:%02d%s", hourAMPM, minutes, seconds, ampm);
		} 
		
		return super.toString();
		
	}
	
}
