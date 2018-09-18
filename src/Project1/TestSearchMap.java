package Project1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSearchMap {	
	@Test
	public void testExplorePath() {
		String input = "P W 200\n" + 
				"P R 300\n" + 
				"R X 200\n" + 
				"Q X 375\n" + 
				"W S 250\n" + 
				"S T 300\n" + 
				"T W 350\n" + 
				"W Y 500\n" + 
				"Y Z 450\n" + 
				"Y R 600";
		String [] connections = input.split("\n");
		boolean containsCity;
		String startCity = "P";
		FlightMap flightMap = new FlightMap(new CityNode(startCity));
		for (int i = 0; i < connections.length; i++) {
			String[] cityLine = connections[i].split(" ");
			containsCity = flightMap.hasCity(cityLine[0]);
			CityNode currentCity = containsCity ? flightMap.getCity(cityLine[0]) : new CityNode(cityLine[0]);
			containsCity = flightMap.hasCity(cityLine[1]);
			CityNode nextCity = containsCity ? flightMap.getCity(cityLine[1]) : new CityNode(cityLine[1]);
			int flightCost = Integer.parseInt(cityLine[2]);
			CityEdge cityEdge = new CityEdge(currentCity, nextCity, flightCost);
			currentCity.addCityEdge(cityEdge);
			flightMap.addCity(currentCity);
			flightMap.addCity(nextCity);
		}
		CityPath cityPath = new CityPath();
		cityPath.addCity(flightMap.getCity(startCity), 0);
		String output = SearchMap.explorePath(startCity, flightMap, cityPath, "");
		assertEquals(output, "P           P                     $0\n" + 
				"W           P,W                   $200\n" + 
				"S           P,W,S                 $450\n" + 
				"T           P,W,S,T               $750\n" + 
				"Y           P,W,Y                 $700\n" + 
				"Z           P,W,Y,Z               $1150\n" + 
				"R           P,W,Y,R               $1300\n" + 
				"X           P,W,Y,R,X             $1500\n");
	}

}
