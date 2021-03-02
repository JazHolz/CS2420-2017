package a02;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdOut;


/**
 * A double-ended queue or deque (pronounced "deck") is a generalization 
 * of a stack and a queue that supports inserting and removing items from 
 * either the front or the back of the data structure. Utilizes Doubly 
 * Linked List data structure.
 * 
 * edu.princeton.cs.algs4 LinkedQueue.class sourced extensively outside of 
 * addFirst, addLast, removeFirst, and removeLast methods.
 * 
 * @author Patrick Leishman, Laurel Miller, Jazmine Lavasani
 *
 * @param <Item>
 */
public class Deque<Item> implements Iterable<Item> {
    private int size;       // number of elements on deque
    private Node top;		// start of deque
    private Node bottom;		// end of deque
    
    
    private class Node {
    	private Item item;
    	private Node up, down;
    	
    	public Node (Item item){
    		this.item = item;
    	}
    	
    	public void connectUp(Node above) {
    		this.up = above;
    		above.down = this;
    	}
    }
	
    /**
     * Initializes empty deque.
     */
	public Deque() {
		top = null;
		bottom = null;
		size = 0;
	}
   
	/**
	 * Determines whether the deque is empty.
	 * @return
	 */
	public boolean isEmpty() {
		return top == null;
	}
   
	/**
	 * Returns the number of items on the deque.
	 * @return
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Inserts the item at the front.
	 * @param item
	 * @throws NullPointerException if null item.
	 */
	public void addFirst(Item item) {
		if(item.equals(null)) {
			throw new java.lang.NullPointerException();
		}
		Node newFirst = new Node(item);
		Node oldFirst = top;
		if(oldFirst != null) {
			oldFirst.connectUp(newFirst);
		}else {
			bottom = newFirst;
		}
		top = newFirst;
		size++;
		checkInvariants();
	}


	/**
	 * Inserts the item at the end.
	 * @param item
	 * @throws NullPointerException if null item.
	 */
	public void addLast(Item item) {
		if(item.equals(null)) {
			throw new java.lang.NullPointerException();
		}
		Node newLast = new Node(item);
		Node oldLast = bottom;
		if(oldLast != null) {
			newLast.connectUp(oldLast);
		} else {
			top = newLast;
		}
		bottom = newLast;
		size++;
		checkInvariants();
	}
   
	/**
	 * Deletes and return the item at the front.
	 * @return item from top of deque.
	 * @throws NoSuchElementException if deque is empty.
	 */
	public Item removeFirst() {
		if (isEmpty()) {
		      throw new java.util.NoSuchElementException();
	    }
		Node oldFirst = top;
		Node newFirst = top.down;
		top = newFirst;
		if(top != null) {
			top.up = null;
		}
		size--;
		checkInvariants();
		return oldFirst.item;
	}
   
	/**
	 * Deletes and return the item at the end.
	 * @return item from bottom of deque.
	 * @throws NoSuchElementException if deque is empty.
	 */
	public Item removeLast() {
		if (isEmpty()) {
		      throw new java.util.NoSuchElementException();
	    }
		Node oldLast = bottom;
		Node newLast = bottom.up;
		bottom = newLast;
		if(bottom != null) {
			bottom.down = null;
		}
		size--;
		checkInvariants();
		return oldLast.item;
	}
   
	/**
	 * Returns an iterator over items in order from front to end.
	 */
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	
	private class DequeIterator implements Iterator<Item>{
		private Node current = top;
		
		@Override
		public boolean hasNext() {
			return current != null;
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
            Item item = current.item;
            current = current.down; 
            return item;
		}
		
	}
	
	private void checkInvariants() {
		assert size >= 0;
	    assert size > 0 || (top == null && bottom == null);
	    assert (top == null && bottom == null) || (top != null && bottom != null);
	}
   
	//***********************************************************//
	public static void main(String[] args) {
		Deque<String> d = new Deque<>();
		d.addFirst("A");
		d.addFirst("B");
		d.addFirst("C");
		d.addFirst("D");
		
		
		for(String el : d) {
			StdOut.println(el);
		}
		
	}
}