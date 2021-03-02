package a02;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


/**
 * A test class that fills a Randomized Queue with Strings entered
 * into the console. K elements from the queue are then displayed
 * randomly (k being the integer argument from the main method).
 * 
 * Attempts to use StdIn.readString were clunky and not as elegent 
 * so StdIn.readLine was used instead. The line was then parsed 
 * using String.split and a regex to store each string separated 
 * by white space as a separate item to be queued into a randomized queue.
 * 
 * 
 * @author Patrick Leishman, Laurel Miller, Jazmine Lavasani
 *
 */
public class Subset {

	public static void main(String[] args) {
		if(args.length < 1){
			throw new java.lang.IllegalArgumentException();
		}
		
		int k = Integer.parseInt(args[0]);
		
		RandomizedQueue<String> queue = new RandomizedQueue<String>();
		
		StdOut.println("Enter a series of strings separated by a space:");
		
		/*
		 * Original implementation of the assignment. Limited to a random
		 * arrangement of the first k elements entered. 
		 */
//		for(int i = 0; i < k; i++) {
//			queue.enqueue(StdIn.readString());
//		}
//		
//		for(String s: queue) {
//			StdOut.println(s);
//		}
		
        String str = StdIn.readLine(); // Read in the line of input from the console.
        String[] sa = str.split("\\s+"); // Split the input line into separate strings according to white space regex.
        for(String s : sa) {
        	queue.enqueue(s);
        }
        
        for (int i = 0; i < k; i++) {
            StdOut.println(queue.dequeue());
        }

	}

}