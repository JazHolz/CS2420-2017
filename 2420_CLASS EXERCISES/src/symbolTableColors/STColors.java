package symbolTableColors;

import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class STColors {
	
	public static void main(String[]args){
		
		ST<String, String> color = new ST<>();
		
		color.put("blue", "000099");
		color.put("lime", "66CC00");
		color.put("orange", "FF6600");
		color.put("red", "990000");
		color.put("white", "000000");
		color.put("yellow", "FFFF00");
		
		for(String key: color){
			StdOut.printf("%s \t %s%n", key, color.get(key));
			
		}
		StdOut.print("  \n");
		color.delete("white");
		color.put("white", "FFFFFF");
		color.delete("yellow");
		
		StdOut.print("White has been updated\n");
		StdOut.print("Yellow has been removed\n");
		StdOut.print("  \n");
		
		
		for(String key: color){
			StdOut.printf("%s \t %s%n", key, color.get(key));
		}
		StdOut.print("  \n");
		StdOut.print("Min: " + color.min());
		StdOut.print("  \n");
		StdOut.print("Max: "+ color.max());
		StdOut.print("  \n");
		StdOut.print("Floor(\"magenta\"):" + color.floor("magenta"));
		StdOut.print("  \n");
		StdOut.print("Ceiling:" + color.ceiling("magenta"));
		StdOut.print("  \n");
		
	}
	
	
}
