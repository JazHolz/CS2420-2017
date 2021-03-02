package graphUndirected;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.DepthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class DfsVsBfs {

	public static void main(String[] args) {
		String graphFile = "src/graphUndirected/graphs/GraphExercise06.txt";
		In in = new In(graphFile); // (args[0]);
		Graph G = new Graph(in);
		int s = 1; // Integer.parseInt(args[1]); source vertex
		DepthFirstPaths dfs = new DepthFirstPaths(G, s);
		BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
		StringBuilder dfsString;
		StringBuilder bfsString;
		boolean first;

		StdOut.println("Adjacency List: " + "\n" + "---------------");
		for (int v = 0; v < G.V(); v++) {
			first = true;
			StdOut.print(v + ":");
			for (int adj : G.adj(v)) {
				if (first == true) {
					StdOut.print(" " + adj);
					first = false;
				} else {
					StdOut.print(" -> " + adj);
				}
			}
			StdOut.println();
		}
		StdOut.println();

		StdOut.println(
				"Paths DFS: " + "\t" + "Shortest Paths BFS: " + "\n" + "---------------" + "\t" + "---------------");

		for (int i = 0; i < G.V(); i++) {
			first = true;
			// DepthFirst
			dfsString = new StringBuilder();
			for (int v : dfs.pathTo(i)) {
				if (first) {
					dfsString.append(v);
					first = false;
				} else {
					dfsString.append("..");
					dfsString.append(v);
				}
			}
			first = true;
			// BreadthFirst
			bfsString = new StringBuilder();
			for (int v : bfs.pathTo(i)) {
				if (first) {
					bfsString.append(v);
					first = false;
				} else {
					bfsString.append("..");
					bfsString.append(v);
				}
			}
			StdOut.printf("%-16s%-16s%n", dfsString, bfsString);
		}
	}
}
