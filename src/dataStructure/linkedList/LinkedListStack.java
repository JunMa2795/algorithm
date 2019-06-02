package dataStructure.linkedList;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 17:31
 */
public class LinkedListStack<E> {

    private Node head;

    public LinkedListStack() {
        head = null;
    }

    private class Node {
        E item;
        Node next;

        Node(E e) {
            item = e;
        }
    }

    public E pop() {
        if (head == null) {
            return null;
        }
        E item = head.item;
        head = head.next;
        return item;
    }

    public void push(E e) {
        Node oldHead = head;
        head = new Node(e);
        head.next = oldHead;
    }
}
