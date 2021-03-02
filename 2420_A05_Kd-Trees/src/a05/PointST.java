package a05;

import edu.princeton.cs.algs4.*;

/**
 * This is a symbol table with Point2D, that implements the following API by
 * using a red-black BST (using either RedBlackBST from algs4.jar or
 * java.util.TreeMap).
 * 
 * @author Garret Rueckert + Laurel Miller + Jazmine Mehri Lavasani
 */

public class PointST<Value> {

	private RedBlackBST<Point2D, Value> rbTree;

	/**
	 * Construct an empty symbol table of points
	 */

	public PointST() {
		rbTree = new RedBlackBST<>();
	}

	/**
	 * Checks if symbol table is empty
	 * 
	 * @return
	 */

	public boolean isEmpty() {
		return rbTree.isEmpty();
	}

	/**
	 * Number of points
	 * 
	 * @return
	 */

	public int size() {
		return rbTree.size();
	}

	/**
	 * Associate the value val with point p
	 * 
	 * @param p
	 * @param val
	 */

	public void put(Point2D p, Value val) {
		if (p == null || val == null) {
			throw new java.lang.NullPointerException();
		}
		rbTree.put(p, val);
	}

	/**
	 * Value associated with point p
	 * 
	 * @param p
	 * @return
	 */

	public Value get(Point2D p) {
		if (p == null) {
			throw new NullPointerException();
		}
		return rbTree.get(p);
	}

	/**
	 * Checks if the symbol table contain point p
	 * 
	 * @param p
	 * @return
	 */

	public boolean contains(Point2D p) {
		if (p == null) {
			throw new java.lang.NullPointerException();
		}
		return rbTree.contains(p);
	}

	/**
	 * Returns all points in the symbol table
	 * 
	 * @return
	 */

	public Iterable<Point2D> points() {
		return rbTree.keys();
	}

	/**
	 * All points that are inside the rectangle
	 * 
	 * @param rect
	 * @return
	 */

	public Iterable<Point2D> range(RectHV rect) {
		if (rect == null) {
			throw new java.lang.NullPointerException();
		}

		Queue<Point2D> que = new Queue<>();
		for (Point2D p : rbTree.keys()) {
			if (rect.contains(p))
				que.enqueue(p);
		}
		return que;
	}

	/**
	 * The nearest neighbor to point p; null if the symbol table is empty
	 * 
	 * @param p
	 * @return
	 */

	public Point2D nearest(Point2D p) {
		if (p == null) {
			throw new java.lang.NullPointerException();
		}

		Point2D nearest = rbTree.max();
		for (Point2D point : rbTree.keys()) {
			if (p.distanceSquaredTo(point) < p.distanceSquaredTo(nearest)) {
				nearest = point;
			}
		}
		return nearest;
	}

	public static void main(String[] args) {

		String filename = "src/a05/input1M.txt";
		In in = new In(filename);
		PointST<Integer> brute = new PointST<>();
		for (int i = 0; !in.isEmpty(); i++) {
			double x = in.readDouble();
			double y = in.readDouble();
			Point2D p = new Point2D(x, y);
			brute.put(p, i);
		}
		StdOut.println("Starting");
		long starttime = System.currentTimeMillis();
		int numberOfTimesToCalculate = 500;
		for (int i = 0; i < numberOfTimesToCalculate; i++) {
			brute.nearest(new Point2D(StdRandom.uniform(), StdRandom.uniform()));
		}
		long endtime = System.currentTimeMillis();
		double timeTakenInSeconds = (endtime - starttime) / 1000.0;
		StdOut.println("Total time: " + timeTakenInSeconds);
		StdOut.println("Average per second: " + numberOfTimesToCalculate / timeTakenInSeconds);

	}
}