package Project1;
import java.util.Vector;

public class CityNode {
	private String cityName;
	
	private Vector<CityEdge> cityEdges = new Vector<CityEdge>();
	
	private boolean hasVisited = false;
	
	/**
	 * Constructor for the the city node object.
	 * @param cn = City name
	 */
	public CityNode(String cn) {
		this.cityName = cn;
	}
	
	public CityNode(String cn, Vector<CityEdge> ce, boolean hv) {
		this.cityName = cn;
		this.cityEdges = ce;
		this.hasVisited = hv;
	}
	
	/**
	 * Returns a list of all the city edges.
	 * @return Vector<CityEdge>
	 */
	public Vector<CityEdge> getCityEdges() {
		return this.cityEdges;
	}
	
	/**
	 * Adds a city edge to the list of city edges.
	 * @param cd = City edge
	 */
	public void addCityEdge(CityEdge ce) {
		this.cityEdges.add(ce);
	}
	
	/**
	 * Returns the city's name.
	 * @return String
	 */
	public String getCityName() {
		return this.cityName;
	}
	
	/**
	 * Sets the city as visited.
	 */
	public void visit() {
		this.hasVisited = true;
	}
	
	/**
	 * Returns whether the city has been visited.
	 * @return Boolean
	 */
	public boolean hasVisited() {
		return this.hasVisited;
	}
}
