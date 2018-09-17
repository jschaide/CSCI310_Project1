import java.util.Vector;

public class CityNode {
	private String cityName;
	
	private Vector<CityEdge> cityEdges = new Vector<CityEdge>();
	
	private boolean hasVisited = false;
	
	private boolean destination = false;
	
	public CityNode(String cn) {
		this.cityName = cn;
	}
	
	public Vector<CityEdge> getCityEdges() {
		return this.cityEdges;
	}
	
	public void addCityEdge(CityEdge ce) {
		this.cityEdges.add(ce);
	}
	
	public String getCityName() {
		return this.cityName;
	}
	
	public void setAsDestination() {
		this.destination = true;
	}
	
	public boolean isDestination() {
		return this.destination;
	}
	
	public void visit() {
		this.hasVisited = true;
	}
	
	public boolean hasVisited() {
		return this.hasVisited;
	}
	
	public void printConnections() {
		for (CityEdge city : cityEdges) {
			System.out.println("Current City : " + city.getStartCity().getCityName() + " connected to " + city.getEndCity().getCityName());
			
		}
	}
}
