package sortMerge;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.StdOut;

public class DemoStable {

	public static void main(String[] args) {

		Rectangle[] rectangles = { new Rectangle(4, 2), new Rectangle(3, 5), new Rectangle(4, 3), new Rectangle(6, 2),
				new Rectangle(3, 4), new Rectangle(4, 4), new Rectangle(6, 4), new Rectangle(12, 2),
				new Rectangle(2, 4), new Rectangle(4, 6), new Rectangle(2, 12) 
				};
		StdOut.println("original rectangles: " + Arrays.toString(rectangles));
		StdOut.println();
		
		Insertion.sort(rectangles);
		StdOut.println("insertion rectangles: " + Arrays.toString(rectangles));
		StdOut.println();
		
		Insertion.sort(rectangles, Rectangle.BY_AREA);
		StdOut.println("insertion w/BY_AREA rectangles: " + Arrays.toString(rectangles));
		StdOut.println();
		

		
	}

}
