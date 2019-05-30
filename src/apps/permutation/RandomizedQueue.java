package apps.permutation;
import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author Jun Ma
 *
 * Coursera: Algorithms 1
 * Assignment 2: Randomized Queues and Deques
 *
 * RandomizedQueue.java
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] resizingArray;	// index of next available slot
	private int numberOfItems;		// number of elements on queue
	private int first;				// index of first element of queue
	private int last;				// index of next available slot
	
	// construct an empty randomized queue
	// @SuppressWarnings("unchecked")
	public RandomizedQueue() {
		this.numberOfItems = 0;
		this.resizingArray = (Item[]) new Object[2];
		this.first = 0;
		this.last = 0;
	}
	
	private class RandomizedQueueIterator implements Iterator<Item> {
		private Item[] itemCopy;
		private int current;
		
		// @SuppressWarnings("unchecked")
		public RandomizedQueueIterator() {
			this.current = 0;
			itemCopy = (Item[]) new Object[numberOfItems];
			for (int i = 0; i < numberOfItems; i++) {
				itemCopy[i] = resizingArray[i];
            }
			StdRandom.shuffle(itemCopy);
		}
		
		public boolean hasNext() {
			return current < numberOfItems;
		}
		
		public Item next() {
			if (!this.hasNext()) {
				throw new NoSuchElementException();
			}
			return itemCopy[current++];
		}
	}

	// @SuppressWarnings("unchecked")
	private void resize(int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < numberOfItems; i++)
			copy[i] = resizingArray[(this.first + i) % resizingArray.length];
		resizingArray = copy;
		this.first = 0;
		this.last = this.numberOfItems;
	}

	
	// is the randomized queue empty?
	public boolean isEmpty() {
		return this.numberOfItems == 0;
	}

	// return the number of items on the randomized queue
	public int size() {
		return this.numberOfItems;
	}

	// add the item
	public void enqueue(Item item) {
		if (this.numberOfItems == this.resizingArray.length) {
			this.resize(2 * this.resizingArray.length);
		}
		this.resizingArray[last++] = item;
		if (this.last == this.resizingArray.length) {
			this.last = 0;
		}
		this.numberOfItems++;
	}

	// remove and return a random item
	public Item dequeue() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		StdRandom.shuffle(this.resizingArray, first, last);

		Item item = this.resizingArray[this.first];
		this.resizingArray[this.first] = null; // to avoid loitering
		this.numberOfItems--;
		this.first++;
		
		if (this.first == this.resizingArray.length)
			this.first = 0; // wrap-around
		
		// shrink size of array if necessary
		if (this.numberOfItems > 0 && this.numberOfItems == this.resizingArray.length / 4)
			resize(this.resizingArray.length / 2);
		
		return item;
	}

	// return a random item (but do not remove it)
	public Item sample() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		return this.resizingArray[StdRandom.uniform(first, last)];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		return new RandomizedQueueIterator();
	}

	// unit testing (optional)
	public static void main(String[] args) {
		RandomizedQueue<String> rdq = new RandomizedQueue<String>();
		
		rdq.enqueue("AA");
		rdq.enqueue("BB");
		rdq.enqueue("CC");
		rdq.enqueue("BB");
		rdq.enqueue("BB");
		rdq.enqueue("CC");
		
		System.out.println("Sample is: " + rdq.sample());
		System.out.println("-------------------------");
		
		Iterator<String> it = rdq.iterator();

		while (it.hasNext()) {
			System.out.println("The next item of rdq is: " + it.next());
		}
		
		System.out.println("-------------------------");
		System.out.println("One item deque from rdq: " + rdq.dequeue());
		System.out.println("One item deque from rdq: " + rdq.dequeue());
		System.out.println("One item deque from rdq: " + rdq.dequeue());
		System.out.println("One item deque from rdq: " + rdq.dequeue());
		System.out.println("One item deque from rdq: " + rdq.dequeue());
		System.out.println("One item deque from rdq: " + rdq.dequeue());
	}
}
