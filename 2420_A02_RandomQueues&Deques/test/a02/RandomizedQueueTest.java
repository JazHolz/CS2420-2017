package a02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomizedQueueTest {
	RandomizedQueue<Integer> r;
	Integer a, b, c;
	
	@Before
	public void setUp() throws Exception {
		r = new RandomizedQueue<>();
		a = 1;
		b = 2; 
		c = 3;
		r.enqueue(a);
		r.enqueue(b);
		r.enqueue(c);
	}

	@Test
	public void testRandomizedQueue() {
		RandomizedQueue<Integer> r2 = new RandomizedQueue<>();
		assertEquals(0, r2.size());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(r.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(3, r.size());
	}

	@Test
	public void testEnqueue() {
		Integer d = 4;
		r.enqueue(d);
		assertEquals(4, r.size());
	}

	@Test
	public void testDequeue() {
		r.dequeue();
		assertEquals(2, r.size());
	}

	@Test
	public void testSample() {
		@SuppressWarnings("unused")//testing if r.sample decrements size
		Integer rand = r.sample();
		assertEquals(3, r.size());
	}



}