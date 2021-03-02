package sortMerge;

import java.util.Comparator;

public class Rectangle implements Comparable<Rectangle> {
	private double length;
	private double width;
	public static final Comparator<Rectangle> BY_AREA = new AreaComparator();

	public Rectangle(double length, double width) {

		this.length = length;
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public double getWidth() {
		return width;
	}

	public double perimeter() {
		return 2 * (length + width);
	}

	public double area() {
		return (length * width);
	}

	@Override
	public String toString() {
		return "[" + length + "x " + width + "]";
	}
	

	@Override
	public int compareTo(Rectangle other) {
		return Double.compare(this.length, other.length);
	}
	
	private static class AreaComparator implements Comparator<Rectangle>{

		public int compare(Rectangle r1, Rectangle r2) {
			return Double.compare(r1.area(), r2.area());
		}
		
	}

}
