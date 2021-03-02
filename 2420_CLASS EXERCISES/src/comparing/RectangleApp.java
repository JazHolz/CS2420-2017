package comparing;

import java.util.Arrays;

public class RectangleApp {
/**
 * This is the Main STring setting up my rectangles
 * @param args
 */
	public static void main(String[] args) {
		
		Rectangle r1 = new Rectangle(2,3);
		System.out.println("r1: " + r1);
		
			/**
			 * Here you will find my Array of Rectangles 
			 */
		Rectangle[] rectangles = {
				r1, new Rectangle(2,4), new Rectangle(4,4),
				new Rectangle(3,5), new Rectangle(1.5,2), new Rectangle(3,2.5)
		};
		/**
		 * This is a print arry that i have made so that it has my code clean and simple.
		 */
		printArray(rectangles);
		
		Arrays.sort(rectangles);
		printArray(rectangles);

	}

	private static void printArray(Rectangle[] rectangles) {
		System.out.print("rectangles: ");
		for(Rectangle r : rectangles) {
			System.out.print(r + " ");
		}
		System.out.println();
	}
	
}
