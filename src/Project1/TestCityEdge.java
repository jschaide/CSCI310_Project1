package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCityEdge {
	public TestCityEdge() {}
	
	@Test
	public void testGetStartCity() {
		CityEdge cityEdge = createTestCityEdge();
		assertEquals(cityEdge.getStartCity().getCityName(), "Start");
	}
	
	@Test
	public void testGetEndCity() {
		CityEdge cityEdge = createTestCityEdge();
		assertEquals(cityEdge.getEndCity().getCityName(), "End");

	}
	
	@Test
	public void testGetCost() {
		CityEdge cityEdge = createTestCityEdge();
		assertEquals(cityEdge.getCost(), 1000);
	}
	
	public static CityEdge createTestCityEdge() {
		CityNode startCity = new CityNode("Start");
		CityNode endCity = new CityNode("End");
		return new CityEdge(startCity, endCity, 1000);
	}

}
