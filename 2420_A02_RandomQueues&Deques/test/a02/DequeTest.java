package a02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DequeTest {
	private Deque<Integer> d;
	private Integer first;
	private Integer last;
	
	@Before
	public void setUp() throws Exception {
		d = new Deque<Integer>();
		first = 7;
		last = 9;
		d.addFirst(first);
		d.addLast(9);
	}

	@Test
	public void testDeque() {
		Deque<Object> d2 = new Deque<>();
		assertTrue(d2.isEmpty());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(d.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(2, d.size());
	}

	@Test
	public void testAddFirst() {
		d.addFirst((Integer) 5);
		assertEquals((Integer) 5, d.removeFirst());
	}

	@Test
	public void testAddLast() {
		d.addLast((Integer) 6);
		assertEquals((Integer) 6, d.removeLast());
	}

	@Test
	public void testRemoveFirst() {
		assertEquals(first, d.removeFirst());
	}

	@Test
	public void testRemoveLast() {
		assertEquals(last, d.removeLast());
	}

}