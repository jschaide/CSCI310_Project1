
public class CityNode {
	private String cityName;
	
	private CityNode nextCity;
	
	private int costToTravel;
	
	public CityNode(String cn, CityNode nc, int ctt) {
		this.cityName = cn;
		this.nextCity = nc;
		this.costToTravel = ctt;
	}
	
	public CityNode(String cn) {
		this.cityName = cn;
	}
	
	public CityNode getNextCity() {
		return this.nextCity;
	}
	
	public void setNextCity(CityNode nc, int ctt) {
		this.nextCity = nc;
		this.costToTravel = ctt;
	}
	
	public String getCityName() {
		return this.cityName;
	}
	
	public int getCostToTravel() {
		return this.costToTravel;
	}
}
