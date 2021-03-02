package midterm1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Midterm1App {


	public static void main(String[] args) {
		Country[] countries = {
				new Country("Norway", 1, 4, 3),	
				new Country("Canada", 1, 4, 1),
				new Country("Netherlands", 2, 2, 1),	
				new Country("Germany", 3, 0, 1),	
				new Country("United States", 2, 1, 1),	
				new Country("Czech Republic", 0, 1, 1),	
				new Country("Finland", 0, 0, 2),	
				new Country("Austria", 1, 0, 0),	
				new Country("South Korea", 1, 0, 0),	
				new Country("Italy", 0, 0, 1)	
		};
		
		// = = = = = Part 1	= = = = = 
		
		StdOut.println("Countries by medal: ");
		StdOut.println("=================== ");
		printCountries(countries);
		
        // TODO part 1a   ... 12 points
		// Run the code. It should print the countries
		// Then Comment out the code below and run the program again.
		// At this point you should encounter an exception.
		// Make the necessary changes in class Country to fix the issue.
		
	
		Arrays.sort(countries);
		
		StdOut.println("Countries by name: ");
		StdOut.println("================== ");
		
		printCountries(countries);
	
		
		// TODO part 1b  .. 6 points
		// Use a comparator to sort the countries in descending order ( Z to A )
		StdOut.println("Countries by name(REVERSED): ");
		StdOut.println("================== ");
		Collections.reverse(Arrays.asList(countries));
		// Print the results 
		printCountries(countries);
		
	
		
		// = = = = = Part 2 = = = = = 
		
		// TODO part 2a  .. 5 points
		// Create a Queue (Sedgewick's code) Copy the elements from array countries into the queue
		
		//Queue<String> queue = new Queue<String>();
		
		Queue queue = new Queue();
		queue.enqueue(countries);
		
		
		// TODO part 2b .. 15 points
		// From now on ONLY Sedgewick's code must be used (the array can no longer be used)
		// Create a second data structure. It needs to be either a second queue or a stack.
		
		
		Queue queue2 = new Queue();
		
		// Use the two data structures that you just created to do the following:		
		
		while (  < 1) {
			
		// Print the countries line by line, however, print only countries that have at least one gold medal.
			
			if(  <= 1){
                StdOut.print(queue.dequeue() + " ");
			}
		// If a country has a gold, a silver, and a bronze medal print " .. bravo" at the end of the line  
			if( <= 1 || <= 1 || <= 1 ){
				StdOut.print(queue.dequeue() + " .. Bravo");
			}
			else{
				//do nothing
			}
			// Make sure the countries are listed in ascending order (A - Z)
			
			//print queue here 
		}
			
			StdOut.print(queue);
	
	}

		

	private static void printCountries(Country[] countries) {
		for(Country c : countries) {
			StdOut.println(c);
		}	
		System.out.println();
	}

}
