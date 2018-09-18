package Project1;
import java.util.Hashtable;

public class FlightMap {
	private Hashtable<String, CityNode> cityDirectory;
	
	private CityNode startingCity;
	
	/**
	 * The flight map object constructor.
	 * @param sc = City node
	 */
	public FlightMap(CityNode sc) {
		this.cityDirectory = new Hashtable<String, CityNode>();
		this.cityDirectory.put(sc.getCityName(), sc);
		this.startingCity = sc;
	}
	
	/**
	 * Adds the city to the city directory.
	 * @param cn = City node
	 */
	public void addCity(CityNode cn) {
		if (!cityDirectory.contains(cn.getCityName())) {
			this.cityDirectory.put(cn.getCityName(), cn);
		}
	}
	
	/**
	 * Returns the starting city.
	 * @return CityNode
	 */
	public CityNode getStartingCity() {
		return this.startingCity;
	}
	
	/**
	 * Checks whether the city directory contains the city.
	 * @param c = String
	 * @return Boolean
	 */
	public boolean hasCity(String c) {
		return cityDirectory.containsKey(c);
	}
	
	/**
	 * Gets the city given a the city's name.
	 * @param c = String
	 * @return CityNode
	 */
	public CityNode getCity(String c) {
		return cityDirectory.get(c);
	}
}
