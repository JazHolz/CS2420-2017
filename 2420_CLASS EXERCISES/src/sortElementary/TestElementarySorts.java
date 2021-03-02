package sortElementary;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Selection;

public class TestElementarySorts {
	
	private static final Random rand = new Random();

	public static void main(String[] args) {

		Integer[] numbers = randomArray(100, 1000, 20);
		Integer[] numbers2 = randomArray(100, 1000, 20);
		
		System.out.println("Unsorted: ");
		System.out.println(Arrays.toString(numbers) + "\n");

		Insertion.sort(numbers);
		System.out.println("Insertion Sort: ");
		System.out.println(Arrays.toString(numbers) + "\n");

		Selection.sort(numbers2);
		System.out.println("Selection sort: ");
		System.out.println(Arrays.toString(numbers2) + "\n");
	}

	/**
	 * Generates an integer array with the specified number of elements. All
	 * elements are from the range [from, to)
	 * 
	 * @param from
	 *            lower bound inclusive
	 * @param to
	 *            upper bound exclusive
	 * @param numberOfElements
	 * @return
	 */

	private static Integer[] randomArray(int from, int to, int numberOfElements) {
		Integer[] numbers = new Integer[numberOfElements];

		for (int i = 0; i < numberOfElements; i++) {
			numbers[i] = rand.nextInt(to - from) + from;

		}
		return numbers;
	}

}