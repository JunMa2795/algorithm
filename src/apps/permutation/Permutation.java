package apps.permutation;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * @author Jun Ma
 *
 *         Coursera: Algorithms 1 Assignment 2: Randomized Queues and Deques
 *
 *         Permutation.java
 *
 */
public class Permutation {
	public static void main(String[] args) {
		RandomizedQueue<String> rdq = new RandomizedQueue<String>();
		while (!StdIn.isEmpty()) {
			rdq.enqueue(StdIn.readString());
		}

		int k = Integer.parseInt(args[0]);
		for (int i = 0; i < k; i++) {
			StdOut.println(rdq.dequeue());
		}
	}
}
