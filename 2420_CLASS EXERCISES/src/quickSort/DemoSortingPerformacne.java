package quickSort;

import java.util.Arrays;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DemoSortingPerformacne {
	
public static void main(String[] args) {
		
		Integer[] array =  getRandomNumberArray(10, 3);
		Integer[] array2 = getRandomNumberArray(10, 4);
		
		Selection.sort(array);
		StdOut.println(Arrays.toString(array));
		Insertion.sort(array2);
		StdOut.println(Arrays.toString(array2));
		
	}

	private static Integer[] getRandomNumberArray(int arraySize, int numberOfDigits) {

		int randNumber = 1;
		Integer[] array = new Integer[arraySize];

		for (int i = 0; i < numberOfDigits; i++) {
			randNumber *= 10;
		}
		int bot = randNumber /10;

		for (int i = 0; i < arraySize; i++) {
			array[i] = bot+(int)StdRandom.uniform(randNumber-bot);
		}
		return array;

	}

}
