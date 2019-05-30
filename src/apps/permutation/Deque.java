package apps.permutation;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Jun Ma
 * 
 * Coursera: Algorithm 1 
 * Assignment 2: Randomized Queues and Deques
 * 
 * Deque.java
 * 
 */
public class Deque<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int numberOfItems;

	private class Node {
		private Item item;
		private Node prev;
		private Node next;

		Node(Item item) {
			this.item = item;
			this.prev = null;
			this.next = null;
		}
	}

	// create an iterator inner class
	private class DequeIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			} else {
				Item item = current.item;
				current = current.next;
				return item;
			}
		}
	}

	// construct an empty deque
	public Deque() {
		this.first = null;
		this.last = null;
		this.numberOfItems = 0;
	}

	// is the deque empty?
	public boolean isEmpty() {
		return this.size() == 0;
	}

	// return the number of items on the deque
	public int size() {
		return this.numberOfItems;
	}

	// add the item to the front
	public void addFirst(Item item) {
		if (item == null) {
			throw new NoSuchElementException();
		}

		if (this.isEmpty()) {
			this.first = new Node(item);
			this.last = this.first;
		} else {
			Node node = new Node(item);
			node.next = this.first;
			this.first.prev = node;
			this.first = node;
		}

		this.numberOfItems++;
	}

	// add the item to the end
	public void addLast(Item item) {
		if (item == null) {
			throw new NoSuchElementException();
		}

		if (this.isEmpty()) {
			this.last = new Node(item);
			this.first = this.last;
		} else {
			Node node = new Node(item);
			node.prev = this.last;
			this.last.next = node;
			this.last = node;
		}
		this.numberOfItems++;
	}

	// remove and return the item from the front
	public Item removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}

		Node node = this.first;
		
		if (this.size() == 1) {
			this.first = null;
			this.last = null;
		} else {
			this.first.next.prev = null;
			this.first = this.first.next;
		}
		
		this.numberOfItems--;
		node.next = null;
		return node.item;
	}

	// remove and return the item from the end
	public Item removeLast() {
		if (this.isEmpty()) {
			throw new NullPointerException();
		}
		
		Node node = this.last;
		
		if (this.size() == 1) {
			this.first = null;
			this.last = null;
		} else {
			this.last.prev.next = null;
			this.last = this.last.prev;
		}
		
		this.numberOfItems--;
		node.prev = null;
		return node.item;
	}

	// return an iterator over items in order from front to end
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}

	// unit testing (optional)
	public static void main(String[] args) {
		Deque<Integer> dq = new Deque<Integer>();
				
		System.out.println("Is dq empty? " + dq.isEmpty());
		System.out.println("-------------------------");
		dq.addFirst(1);
		dq.addLast(5);
		
		System.out.println("Current size for dq is: " + dq.size());
		
		dq.addFirst(3);
		dq.addFirst(4);
		dq.addLast(2);
		
		System.out.println("Current size for dq is: " + dq.size());
		System.out.println("-------------------------");
		
		Iterator<Integer> it = dq.iterator();

		while (it.hasNext()) {
			System.out.println("The next item of dq is: " + it.next());
		}
		
		dq.removeFirst();
		dq.removeLast();
		dq.removeFirst();
		dq.removeLast();
		dq.removeFirst();
		
		System.out.println("-------------------------");
		System.out.println("Current size for dq is: " + dq.size());
	}
}