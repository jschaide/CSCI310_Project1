package Project1;
public class CityEdge {
	private CityNode startCity;
	
	private CityNode endCity;
		
	private int cost;
	
	/**
	 * The city edge object constructor.
	 * @param sc = start city
	 * @param ec = end city
	 * @param c = cost
	 */
	public CityEdge(CityNode sc, CityNode ec, int c) {
		this.startCity = sc;
		this.endCity = ec;
		this.cost = c;
	}
	
	/**
	 * Returns the start city of the edge.
	 * @return CityNode
	 */
	public CityNode getStartCity() {
		return this.startCity;
	}
	
	/**
	 * Returns the end city of the edge.
	 * @return CityNode
	 */
	public CityNode getEndCity() {
		return this.endCity;
	}
	
	/**
	 * Gets the total cost of the city edge.
	 * @return Integer
	 */
	public int getCost() {
		return this.cost;
	}
	
	
}
