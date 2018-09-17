import java.util.LinkedList;

public class CityPath {
	private int totalCost = 0;
	
	private LinkedList<CityNode> path;
	
	public CityPath() {
		path = new LinkedList<CityNode>();
	}
	
	public void addCity(CityNode city, int cost) {
		path.add(city);
		totalCost += cost;
	}
	
	public void popCity(int cost) {
		path.removeLast();
		this.totalCost -= cost;
	}
	
	public CityNode getPathEnd() {
		return path.getLast();
	}
	
	public int getTotalCost() {
		return this.totalCost;
	}
	
	public LinkedList<CityNode> getPath() {
		return this.path;
	}
}
