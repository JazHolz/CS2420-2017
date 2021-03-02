package finalCode;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This is my ExerciseFinal for the Final Code of CSIS 2420 Algorithms and Data
 * Structures.
 * 
 * @author Jazmine Mehri Lavasani
 *
 */

public class ExerciseFinal {

	public static void main(String[] args) {
		String graphFile = "src/finalCode/Resources/Route.txt";
		In in = new In(graphFile);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		KruskalMST mst = new KruskalMST(G);

		StdOut.println("Part 1: " + "\n" + "=======");
		StdOut.println("Source (" + (G.V() - G.V()) + " - " + (G.V() - 1) + "):");
		String source = StdIn.readLine();

		StdOut.println("Destination  (" + (G.V() - G.V()) + " - " + (G.V() - 1) + "):");
		String destination = StdIn.readLine();

//		if (graphFile.contains(source)) {
//			int s = graphFile.indexOf(source);
//			BreadthFirstPaths paths = new BreadthFirstPaths(Graph, s);
//			for( paths.distTo(s)){
//				
//			}
//			StdOut.println("Suggested Route:");
//
//		}
		StdOut.println();

		StdOut.println("Part 2: " + "\n" + "=======");
		StdOut.printf("Minimum Distance: $%.0f\n", mst.weight());

		StdOut.println();
		StdOut.print("Legs of the Hyperloop:");

	}
}
