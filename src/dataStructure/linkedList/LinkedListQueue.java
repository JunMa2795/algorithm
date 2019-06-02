package dataStructure.linkedList;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 11:38
 */
public class LinkedListQueue<E> {

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    private class Node {
        E item;
        Node next;

        Node(E e) {
            item = e;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(E e) {
        Node oldTail = tail;
        tail = new Node(e);
        if (isEmpty()) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        size++;
    }

    public E dequeue() {
        E item = head.item;
        head = head.next;
        if (isEmpty()) {
            tail = null;
        }
        size--;
        return item;
    }
}
