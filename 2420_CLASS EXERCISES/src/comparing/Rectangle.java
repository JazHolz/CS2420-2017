package comparing;

public class Rectangle implements Comparable<Rectangle> {
	// Width and Height is needed
	private double width;
	private double height;
	/**
	 * Initializes the rectangle with the specified width and height.
	 * @param width
	 * @param height
	 */
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}
	
	/**
	 * This returns the Width of the Rectangle
	 * @return
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * This returns the Height of the Rectangle
	 * @return
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * This returns a string of the following format: 
	 * "[" + width + " x " + height + "]"
	 */
	
	@Override
	public String toString() {
		return "[" + width + " x " + height + "]";
	}

	/**
	 * Compares the rectangles first Width and if the Width id the same by height
	 */
	@Override
	public int compareTo(Rectangle other) {
		//Comparable method for rectangles
		int widthCompare = Double.compare(this.width, other.width);
		if (widthCompare != 0)
			return widthCompare;
		else
		return Double.compare(this.height, other.height);
		
	}
	
}
