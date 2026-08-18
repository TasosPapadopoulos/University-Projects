
public class City implements CityInterface, Comparable<City> {
	
	private int cityID;
	private String cityName;
	private int cityPopulation;
	private int cityInfluenzaCases;
	private double density;
	
	public City(int cityID, String cityName, int cityPopulation, int cityInfluenzaCases) {
		this.cityID = cityID;
		this.cityName = cityName;
		this.cityPopulation = cityPopulation;
		this.cityInfluenzaCases = cityInfluenzaCases;
	}
	
	public City(int cityID, String cityName, double density) {
		this.cityID = cityID;
		this.cityName = cityName;
		this.density = density;
	}
	
	public City() {
		
	}
	
	public int getID() {
		return cityID;
	}
	
	public String getName() {
		return cityName;
	}
	
	public int getPopulation() {
		return cityPopulation;
	}
	
	public int getInfluenzaCases() {
		return cityInfluenzaCases;
	}
	
	public void setID(int id) {
		if (1 <= id && id <= 999) {
			cityID = id;
		} else {
			System.out.println("You entered an invalid ID!");
		}
	}
	
	public void setName(String name) {
		cityName = name;
	}
	
	public void setPopulation(int population) {
		cityPopulation = population;
	}
	
	public void setInfluenzaCases(int influenzaCases) {
		cityInfluenzaCases = influenzaCases;
	}
	
	public String toString() {
		return ("The ID of this City is: " + getID() +
				"\nThe name of the City is: " + getName() +
				"\nThe population of the City is: " + getPopulation() +
				"\nThe Influenza Cases in the City are: " + getInfluenzaCases());
	}
	
	public double calculateDensity() {
		double casesPer50000 = (cityInfluenzaCases * 50000.0) / cityPopulation;
		double roundedDensityIn50000 = Math.round(casesPer50000 * 100.0) / 100.0;
		return roundedDensityIn50000;
	}
	
	public int compareTo(City other) {
		double densityThis = calculateDensity();
        double densityOther = other.calculateDensity();

        if (densityThis != densityOther) {
            return Double.compare(densityThis, densityOther);
        } else if (!cityName.equals(other.getName())) {
            
        	char[] a = cityName.toLowerCase().toCharArray();
    		char[] b = other.getName().toLowerCase().toCharArray();
    		
    		int n;
    		
    		if (a.length <= b.length) {
    			n = a.length;
    		} else {
    			n = b.length;
    		}
    		
    		for (int i = 0; i < n; i++) {
    			if (a[i] < b[i]) {
    				return -1;
    			} else if (a[i] > b[i]) {
    				return 1;
    			}
    		}
    		
    		return -1;
        } else {
            return Integer.compare(cityID, other.cityID);
        }
	}
	
}
