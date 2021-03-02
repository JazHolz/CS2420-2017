package graphUndirected;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.GraphGenerator;
import edu.princeton.cs.algs4.StdOut;

public class GenerateGraphFile {

	public static void main(String[] args){
		Graph g = GraphGenerator.simple(12, 0.4);
		
		StdOut.println("Vertices: " + g.V());
		StdOut.println("Edges: " + g.E());
		
		for(int v = 0; v < g.V(); v++){
			for(int w: g.adj(v)){
				if(w > v){
				StdOut.println(v + " " + w);
				}
			}
		}	
	}
}
