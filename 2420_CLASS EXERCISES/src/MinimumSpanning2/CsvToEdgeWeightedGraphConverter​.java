package MinimumSpanning2;

import java.io.BufferedReader;
import java.io.FileReader;

import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class CsvToEdgeWeightedGraphConverter​ {

	public static EdgeWeightedGraph generateEdgeWeightedGraph​(String connectionsCSV, String ewgFile) {
		ST<Integer, String> cities = new ST<>();
		EdgeWeightedGraph g = new EdgeWeightedGraph(new In(ewgFile)); 

		try (BufferedReader ewg = new BufferedReader(new FileReader(ewgFile));
				BufferedReader csv = new BufferedReader(new FileReader(connectionsCSV))) {
			int V = Integer.parseUnsignedInt(ewg.readLine());
			int E = Integer.parseUnsignedInt(ewg.readLine());

			for (int i = 0; i < E; i++) {
				String[] ewgSplit = ewg.readLine().split(" ");
				String[] csvSplit = csv.readLine().split(",");
				
				int v = Integer.parseUnsignedInt(ewgSplit[0]);
				int w = Integer.parseUnsignedInt(ewgSplit[1]);
				cities.put(v, csvSplit[0]);
				cities.put(w, csvSplit[1]);
				
			}

		} catch (Exception e) {
			System.out.println("Couldn't read ewg file: " + e.getMessage());
		}
		for(int v : cities.keys()){
			System.out.printf("%d: %s%n", v, cities.get(v));
		}

		return g;

	}
	public static void main(String[] args) {
		generateEdgeWeightedGraph​("src/MinimumSpanning2/CityConnections.csv", "src/MinimumSpanning2/citiesEWG.txt");
	}
}
