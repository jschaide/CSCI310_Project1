package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFlightMap {

	@Test
	public void testAddCity() {
		FlightMap flightMap = createTestFlightMap();
		CityNode cityNode = new CityNode("Added City");
		flightMap.addCity(cityNode);
		assertEquals(flightMap.getCity("Added City"), cityNode);
	}
	
	@Test
	public void testGetStartingCity() {
		FlightMap flightMap = createTestFlightMap();
		assertEquals(flightMap.getStartingCity().getCityName(), "StartCity");
	}

	@Test
	public void testHasCity() {
		FlightMap flightMap = createTestFlightMap();
		assertTrue(flightMap.hasCity("StartCity"));
	}
	
	@Test
	public void testGetCity() {
		FlightMap flightMap = createTestFlightMap();
		CityNode cityNode = new CityNode("Added City");
		flightMap.addCity(cityNode);
		assertEquals(flightMap.getCity("Added City"), cityNode);
	}
	
	public static FlightMap createTestFlightMap() {
		CityNode cityNode = new CityNode("StartCity");
		FlightMap flightMap = new FlightMap(cityNode);
		return flightMap;
	}
}
