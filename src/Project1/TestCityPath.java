package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCityPath {

	@Test
	public void testAddCity() {
		CityPath cityPath = createTestCityPath();
		cityPath.addCity(new CityNode("City4"), 200);
		assertEquals(cityPath.getPathEnd().getCityName(), "City4");
	}
	
	@Test
	public void testPopCity() {
		CityPath cityPath = createTestCityPath();
		cityPath.popCity(400);
		assertEquals(cityPath.getPathEnd().getCityName(), "City2");
	}
	
	@Test
	public void testGetPathEnd() {
		CityPath cityPath = createTestCityPath();
		assertEquals(cityPath.getPathEnd().getCityName(), "City3");
	}
	
	@Test
	public void testGetTotalCost() {
		CityPath cityPath = createTestCityPath();
		assertEquals(cityPath.getTotalCost(), 900);
	}
	
	@Test
	public void testGetPath() {
		CityPath cityPath = createTestCityPath();
		assertEquals(cityPath.getPath().get(0).getCityName(), "City1");
		assertEquals(cityPath.getPath().get(1).getCityName(), "City2");
		assertEquals(cityPath.getPath().get(2).getCityName(), "City3");
	}
	
	public static CityPath createTestCityPath() {
		CityNode cityNode1 = new CityNode("City1");
		CityNode cityNode2 = new CityNode("City2");
		CityNode cityNode3 = new CityNode("City3");
		CityPath cityPath = new CityPath();
		cityPath.addCity(cityNode1, 200);
		cityPath.addCity(cityNode2, 300);
		cityPath.addCity(cityNode3, 400);
		return cityPath;
	}

}
