package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Vector;

public class TestCityNode {

	@Test
	public void testGetCityEdges() {
		CityNode cityNode = createTestCityNode();
		assertEquals(cityNode.getCityEdges().get(0).getStartCity().getCityName(), "Start");
		assertEquals(cityNode.getCityEdges().get(1).getEndCity().getCityName(), "End");
	}
	
	@Test
	public void testAddCityEdge() {
		CityNode cityNode = createTestCityNode();
		cityNode.addCityEdge(new CityEdge(new CityNode("NY"), new CityNode("CHI"), 200));
		assertEquals(cityNode.getCityEdges().get(2).getStartCity().getCityName(), "NY");
	}
	
	@Test
	public void testGetCityName() {
		CityNode cityNode = createTestCityNode();
		assertEquals(cityNode.getCityEdges().get(0).getStartCity().getCityName(), "Start");
	}
	
	@Test
	public void testVisit() {
		CityNode cityNode = createTestCityNode();
		cityNode.visit();
		assertEquals(cityNode.hasVisited(), true);
	}
	
	@Test
	public void testHasVisted() {
		CityNode cityNode = createTestCityNode();
		assertEquals(cityNode.hasVisited(), false);
	}

	public static CityNode createTestCityNode() {
		Vector<CityEdge> cityEdges = new Vector<CityEdge>();
		cityEdges.add(new CityEdge(new CityNode("Start"), new CityNode("End"), 1000));
		cityEdges.add(new CityEdge(new CityNode("Start"), new CityNode("End"), 200));
		return new CityNode("City", cityEdges, false);
	}
}
