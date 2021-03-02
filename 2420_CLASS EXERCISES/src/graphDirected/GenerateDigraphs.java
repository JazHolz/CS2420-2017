package graphDirected;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.DigraphGenerator;
import edu.princeton.cs.algs4.StdOut;

public class GenerateDigraphs {

	public static void main(String[] args) {
		// all vertices are connected with arrows
		Digraph G = DigraphGenerator.simple(9, 15);
		StdOut.println(G);
		
		// tree
		G = DigraphGenerator.binaryTree(10);
		StdOut.println(G);
		
		// all vertices are connected with arrows
		G = DigraphGenerator.rootedOutDAG(8, 13);
		StdOut.println(G);
	}
}