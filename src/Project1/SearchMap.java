package Project1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SearchMap {
	/**
	 * Explores the flight graph and outputs the result paths to an output text file.
	 * @param cityName = String
	 * @param flightMap = FlightMap
	 * @param cityPath = CityPath
	 * @param outputText = String
	 * @return String
	 */
	public static String explorePath(String cityName, FlightMap flightMap, CityPath cityPath, String outputText) {
		CityNode city = flightMap.getCity(cityName);
		if (city.hasVisited()) {
			return outputText;
		}
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
		outputText += "$" + cityPath.getTotalCost() + "\n";
		for (CityEdge cityEdge : city.getCityEdges()) {
			cityPath.addCity(cityEdge.getEndCity(), cityEdge.getCost());
			outputText = explorePath(cityEdge.getEndCity().getCityName(), flightMap, cityPath, outputText);
			cityPath.popCity(cityEdge.getCost());
		}
		return outputText;
	}

	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader(new File(args[0]));
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
			String output = "Destination Flight route from " + startCity + "   Total Cost " + "\n";
			output += explorePath(startCity, flightMap, cityPath, "");
			BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
			writer.write(output);
			writer.close();
			bufferedReader.close();
			fileReader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
