package graphSymbol;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RouteFinder {

	public static void main(String[] args) {
		String filename = "src/graphSymbol/routes.txt";
		String delimiter = " ";
		SymbolGraph sg = new SymbolGraph(filename, delimiter);
		Graph graph = sg.graph();

		while (StdIn.hasNextLine()) {
			String source = StdIn.readLine();
			if (sg.contains(source)) {
				int s = sg.indexOf(source);
				BreadthFirstPaths paths = new BreadthFirstPaths(graph, s);
				for (int v = 0; v < graph.V(); v++) {
					if (!paths.hasPathTo(v)) {
						continue;
					}
					StdOut.printf("%s:", sg.nameOf(v));
					
					for (int printer : paths.pathTo(v)){
						StdOut.printf(" %s", sg.nameOf(printer));
					}
					StdOut.println();
				}
			} else {
				StdOut.println("The airport could not be found: '" + source + "'");
			}
		}
	}
}
