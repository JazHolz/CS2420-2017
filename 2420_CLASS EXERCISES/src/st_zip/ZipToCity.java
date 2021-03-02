package st_zip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class ZipToCity {

	private static InputStream file = ZipToCity.class.getResourceAsStream("/st_zip/Resources/us_postal_codes.csv");

	public static ST<Integer, City> cityToZip() {
		
		ST<Integer, City> st = new ST<>();
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(file))) {
			if (reader.ready()) {
				reader.readLine(); // remove header line
			}
			while (reader.ready()) {
				String[] zipData = reader.readLine().split(",");
				int zip = Integer.parseInt(zipData[0]);
				City city = new City(zipData[1], zipData[3]);
				st.put(zip, city);
			}
		} catch (IOException e) {
			StdOut.println("A problem occurred reading in the data from us_postal_codes.csv");
			e.printStackTrace();
		}
		return st;
	}
}
