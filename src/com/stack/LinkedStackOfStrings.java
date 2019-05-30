package com.stack;

public class LinkedStackOfStrings {
	private Node first = null;

	private class Node {
		String item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public void push(String item) {
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}

	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	
	public static void main(String[] args) {
		LinkedStackOfStrings stack = new LinkedStackOfStrings();
		String s = "a b c d e f g";
		String[] array = s.split(" ");
		for(int i = 0; i < array.length; i++) {
			stack.push(array[i]);
		}
		for(int i = array.length - 1; i >= 0; i-=2) {
			System.out.print(array[i]);
		}
	}
}
