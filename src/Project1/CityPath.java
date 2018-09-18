package Project1;
import java.util.LinkedList;

public class CityPath {
	private int totalCost = 0;
	
	private LinkedList<CityNode> path;
	
	/**
	 * City path constructor.
	 */
	public CityPath() {
		path = new LinkedList<CityNode>();
	}
	
	/**
	 * Adds a city node to the path list.
	 * @param city = City node
	 * @param cost = Cost of travel
	 */
	public void addCity(CityNode city, int cost) {
		path.add(city);
		totalCost += cost;
	}
	
	/**
	 * Deletes the last city added to the list.
	 * @param cost = Cost of the city removed.
	 */
	public void popCity(int cost) {
		path.removeLast();
		this.totalCost -= cost;
	}
	
	/**
	 * Gets the last city added to the list.
	 * @return CityNode
	 */
	public CityNode getPathEnd() {
		return path.getLast();
	}
	
	/**
	 * Gets the total cost of the city path so far.
	 * @return Integer
	 */
	public int getTotalCost() {
		return this.totalCost;
	}
	
	/**
	 * Gets the current path object.
	 * @return LinkedList<CityNode>
	 */
	public LinkedList<CityNode> getPath() {
		return this.path;
	}
}
