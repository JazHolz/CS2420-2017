package heapSort;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdOut;

public class DemoHeap {
	
	public static void main(String[] args) {
		
		MinPQ<Mail> minPQ = new MinPQ<Mail>();
		int n = 25;
		
		for (int i = 0; i < n; i++){
			minPQ.insert(new Mail());
		}
		
	StdOut.print("Elements in the priority queue: ");
	for (Mail mail: minPQ){
		StdOut.println(mail.toString());
	}
	
	StdOut.println("Elements still in PQ: " + minPQ.size());
	
	StdOut.println();
	
	StdOut.print("Remove elements one by one from the priority queue: ");
	for (int i = 0; i < n; i++){
		StdOut.println(minPQ.delMin());
	}
	StdOut.println("Elements still in PQ: " + minPQ.size());
	
	
	}
}
