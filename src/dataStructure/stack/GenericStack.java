package dataStructure.stack;

// Java does not allow generic type arrays
// Can be achieved by casting. (Good code does not have cast)
// Item represents Java generic type
public class GenericStack<Item> {
	private Node first = null;

	private class Node {
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(Item item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
}
