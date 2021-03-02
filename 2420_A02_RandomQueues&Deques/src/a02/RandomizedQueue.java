package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * A randomized queue is similar to a stack or queue, except that the item
 * removed is chosen uniformly at random from items in the data structure.
 * Utilizes Dynamic Array data structure.
 * 
 * edu.princeton.cs.algs4 ResizingArrayQueue.class sourced extensively.
 * 
 * @author Patrick Leishman, Laurel Miller, Jazmine Lavasani
 *
 * @param <Item>
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] a;  // queue elements
    private int n;     // number of elements on queue 
   
	
    @SuppressWarnings("unchecked")
	public RandomizedQueue() {
    	a = (Item[]) new Object[2]; // 2 Objects so that initial deque has half of it's designated space populated.
        n = 0;
	}

	/**
	 * Returns true if the queue is empty.
	 * @return empty
	 */
	public boolean isEmpty() {
		return n == 0;
	}

	/**
	 * Returns the number of items on the queue.
	 * @return size
	 */
	public int size() {
		return n;
	}
	
	private void resizeArray (int dCapacity) {
		@SuppressWarnings("unchecked")
		Item[] temp = (Item[]) new Object[dCapacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp.clone();
		temp = null;
	}

	/**
	 * Adds item to queue
	 * @param item
	 */
	public void enqueue(Item item) {
		if(item == null) {
			throw new java.lang.NullPointerException();
		}
		if (n == a.length) {
			resizeArray(2 * a.length);
		}
		a[n] = item;
		n++;
	}

	/**
	 * Deletes and returns a random item.
	 * @return Item
	 */
	public Item dequeue() {
		if (isEmpty()) {
		      throw new java.util.NoSuchElementException();
	    }
		
		int i = StdRandom.uniform(n);
		Item rand = a[i];
		
		for(int j = i; j < a.length-1; j++) {
			a[j] = a[j+1];
		}
		n--;
		
		if(n > 0 && n == (a.length/4)){
			resizeArray(a.length/2);
		}
		
		return rand;
	}


	/**
	 * Returns (but doesn't delete) a random item.
	 * @return Item
	 */
	public Item sample() {
		if (isEmpty()) {
		      throw new java.util.NoSuchElementException();
	    }
		
		int i = StdRandom.uniform(a.length);
		Item rand = a[i];
		while(rand == null) {
			i = StdRandom.uniform(a.length);
			rand  = a[i];
		}

		return rand;
	}

	/**
	 * Returns an independent iterator over items in random order
	 */
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}

	private class RandomizedQueueIterator implements Iterator<Item> {
		private int i = 0;
		private Item[] r;
		
		@SuppressWarnings("unchecked")
		public RandomizedQueueIterator() {
			r = (Item[]) new Object[n];
			for(int i = 0; i < n; i++) {
				r[i] = a[i];
			}
			StdRandom.shuffle(r);
		}
		
		@Override
		public boolean hasNext() {
			return i < n;
		}
		
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return r[i++];
		}
	}

	// ********************************************************//
	public static void main(String[] args) {
		RandomizedQueue<String> r = new RandomizedQueue<>();
		r.enqueue("A");
		r.enqueue("B");
		r.enqueue("C");
		r.enqueue("D");
		r.enqueue("E");
		
		r.dequeue();
		r.dequeue();
		
		for(String el : r) {
			StdOut.print(el + "\n");
		}
		
	}
}