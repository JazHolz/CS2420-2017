package MinimumSpanning1;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.KruskalMST;
import edu.princeton.cs.algs4.StdOut;

public class MinSpanTree1 {

	public static void main(String[] args) {

		String path = "src/MinimumSpanning1/GraphDorm.txt";
		In in = new In(path);
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		KruskalMST mst = new KruskalMST(G);

		StringBuilder needsRouter = new StringBuilder();
		StringBuilder toConnect = new StringBuilder();
		for (Edge e : mst.edges()) {
			int v = e.either();
			int w = e.other(v);
			if (v == 2 || w == 2) {
				needsRouter.append(w + " ");
			} else {
				toConnect.append(v + "-" + w + " ");
			}
		}

		StdOut.println("Connected rooms: " + toConnect);
		StdOut.println(("Rooms that need Routers: " + needsRouter));
		StdOut.printf("Total Cost: $%.0f\n", mst.weight());
	}
}
