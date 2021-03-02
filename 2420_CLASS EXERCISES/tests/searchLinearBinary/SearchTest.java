package searchLinearBinary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	private int[] mixedNumbers = { 3, 7, 1, 9, 2, 5, 4, 0, 8, 6 };
	private int[] sortedNumbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testLinearFirstElement() {
		assertEquals(0, Search.linear(mixedNumbers, 3));
	}

	@Test
	public void testLinearLastElement() {
		assertEquals(3, Search.linear(mixedNumbers, 9));
	}

	@Test
	public void testLinearCenterElement() {
		assertEquals(9, Search.linear(mixedNumbers, 6));
	}

	@Test
	public void testLinearNonExistingElement() {
		assertEquals(-1, Search.linear(mixedNumbers, 16));
	}

	@Test
	public void testBinaryFirstElement() {
		assertEquals(0, Search.binary(sortedNumbers, 0));
	}

	@Test
	public void testBinaryLastElement() {
		assertEquals(7, Search.binary(sortedNumbers, 6));
	}

	@Test
	public void testBinaryCenterElement() {
		assertEquals(10, Search.binary(sortedNumbers, 9));
	}

	@Test
	public void testBinaryNonExistingElement() {
		assertEquals(-1, Search.binary(sortedNumbers, 16));
	}

}
