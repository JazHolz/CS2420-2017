package comparing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
	private final Rectangle r = new Rectangle(3,4);
	private double delta = 0.0000001;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testRectangle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWidth() {
		double expected = 3;
		double actual = r.getWidth();
		//crossed out code means it's deprecated, old code and may not be available later on 
		assertEquals(expected, actual,delta);
	}

	@Test
	public void testGetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

}
