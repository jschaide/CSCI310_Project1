import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SearchMap {
	
	/*
	 * Explores the flight graph and outputs the result paths to an output text file.
	 * @param {String} cityName
	 * @param {!FlightMap} flightMap
	 * @param {!CityPath} cityPath
	 */
	public static void explorePath(String cityName, FlightMap flightMap, CityPath cityPath) {
		try {
			CityNode city = flightMap.getCity(cityName);
			if (city.hasVisited()) {
				return;
			}
			BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
			String outputText = "";
			outputText += cityName + "           ";
			city.visit();
			for (int i = 0; i < cityPath.getPath().size(); i++) {
				outputText += cityPath.getPath().get(i).getCityName();
				if (i != cityPath.getPath().size()-1) {
					outputText += ",";
				}
			}
			for (int i = 0; i < 23-cityPath.getPath().size()*2; i++) {
				outputText += " ";
			}
			outputText += "$" + cityPath.getTotalCost();
			System.out.println(outputText);
			writer.append(outputText);
			for (CityEdge cityEdge : city.getCityEdges()) {
				cityPath.addCity(cityEdge.getEndCity(), cityEdge.getCost());
				explorePath(cityEdge.getEndCity().getCityName(), flightMap, cityPath);
				cityPath.popCity(cityEdge.getCost());
			}
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader(new File("input.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String buffer;
			boolean containsCity;
			String startCity = bufferedReader.readLine();
			FlightMap flightMap = new FlightMap(new CityNode(startCity));
			while ((buffer = bufferedReader.readLine()) != null) {
				String[] cityLine = buffer.split(" ");
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
			explorePath(startCity, flightMap, cityPath);
			bufferedReader.close();
			fileReader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}
