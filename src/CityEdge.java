
public class CityEdge {
	private CityNode startCity;
	
	private CityNode endCity;
		
	private int cost;
	
	public CityEdge(CityNode sc, CityNode ec, int c) {
		this.startCity = sc;
		this.endCity = ec;
		this.cost = c;
	}
	
	public CityNode getStartCity() {
		return this.startCity;
	}
	
	public CityNode getEndCity() {
		return this.endCity;
	}
	
	public int getCost() {
		return this.cost;
	}
	
	
}
