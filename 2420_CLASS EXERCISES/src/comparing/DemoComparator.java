package comparing;

/**
 * Represents a REctange witha given Width and Height 
 * @author Jazmine Lavasani
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoComparator {

	public static void main(String[] args) {

		// Ant ape Bee Dog eel Fly

		List<String> animals = new ArrayList<>();
		Collections.addAll(animals, "Ant", "ape", "Bee", "Dog", "eel", "Fly");
		System.out.println("animals: " + animals);

		Collections.sort(animals);
		System.out.println("animals: " + animals);

		Collections.sort(animals, String.CASE_INSENSITIVE_ORDER);
		System.out.println("animals: " + animals);

		// Sort Back to front

		Collections.sort(animals, Collections.reverseOrder());
		System.out.println("animals: " + animals);

		Collections.sort(animals, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		System.out.println("animals: " + animals);
	}

}
