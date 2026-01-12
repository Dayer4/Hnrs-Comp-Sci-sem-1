import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		MySinglyLinkedList list = new MySinglyLinkedList();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            list.insert(0, rand.nextInt(10));
        }
        for (int i = 0; i < 20; i++) {
            int idx = rand.nextInt(20);
            list.insert(idx, -1);
        }
        System.out.println("Original list:");
        list.printList();
        Node prev = null;
        Node curr = list.head;
        while (curr != null) {
            Node nxt = curr.next;
            curr.next = prev;
            curr.back = nxt;
            prev = curr;
            curr = nxt;
        }
        System.out.println("\nForward:");
        list.head = prev;
        System.out.println("\nReversed:");
        list.printList();
	}
}
