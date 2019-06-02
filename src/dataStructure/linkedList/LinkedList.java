package dataStructure.linkedList;

/**
 * Created by jack.
 * Date: 2019-06-01
 * Time: 10:57
 */
public class LinkedList<Item> {

    Node head;

    private class Node {

        Item item;
        Node next;

        Node(Item t) {
            item = t;
            next = null;
        }
    }

    Node reverse() {
        Node pre = null;
        Node current = head;

        while(current != null) {
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    void printList() {
        Node node = head;
        while (node != null) {
            System.out.print(node.item + " ");
            node = node.next;
        }
    }

    void printListRev(Node head) {
        if (head != null) {
            printListRev(head.next);
            System.out.print(head.item + " ");
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.head = list.new Node(85);
        list.head.next = list.new Node(15);
        list.head.next.next = list.new Node(4);
        list.head.next.next.next = list.new Node(20);

        System.out.println("Given linked list:");
        list.printList();
        System.out.println();
        System.out.println("Reverse print linked list:");
        list.printListRev(list.head);
        System.out.println();
        list.head = list.reverse();
        System.out.println("Reversed linked list:");
        list.printList();
    }
}
