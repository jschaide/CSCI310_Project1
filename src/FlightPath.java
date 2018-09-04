import java.util.Vector;

public class FlightPath {
	private Vector<CityNode> flightPath;
	
	private int totalPathCost = 0;
	
	public FlightPath() {
		this.flightPath = new Vector<CityNode>();
	}
	
	public void addCity(CityNode cn) {
		this.flightPath.add(cn);
		this.totalPathCost += cn.getCostToTravel();
	}
	
	public int getTotalPathCost() {
		return this.totalPathCost;
	}
}
