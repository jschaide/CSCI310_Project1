import java.util.Hashtable;

public class FlightMap {
	private Hashtable<String, CityNode> cityDirectory;
	
	private CityNode startingCity;
	
	public FlightMap(CityNode sc) {
		this.cityDirectory = new Hashtable<String, CityNode>();
		this.cityDirectory.put(sc.getCityName(), sc);
		this.startingCity = sc;
	}
	
	public void addCity(CityNode cn) {
		if (!cityDirectory.contains(cn.getCityName())) {
			this.cityDirectory.put(cn.getCityName(), cn);
		}
	}
	
	public CityNode getStartingCity() {
		return this.startingCity;
	}
	
	public boolean hasCity(String c) {
		return cityDirectory.containsKey(c);
	}
	
	public CityNode getCity(String c) {
		return cityDirectory.get(c);
	}
}
