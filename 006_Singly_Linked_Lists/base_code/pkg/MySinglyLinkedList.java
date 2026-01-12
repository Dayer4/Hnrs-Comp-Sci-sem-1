package pkg;
import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.time.*;
import java.lang.*;

public class MySinglyLinkedList {
	public Node head;
	/* 
		Postcondition: The head will be null 
	*/
	public MySinglyLinkedList() {
		head = null;
	}

	/* 
		Receives an integer position, searches through the SinglyLinkedList for the position and returns the data at that positon
	   	If the position doesn't exist, it returns -1
	*/ 
	public int get(int pos) {
        Node cur = head;
        int idx = 0;
        while (cur != null) {
            if (idx == pos) {
                return cur.data;
            }
            cur = cur.next;
            idx++;
        }
        return -1;
    }

	/*
		Insert a new Node at the given position with the data given
	*/
	public void insert(int pos, int data){
		Node n = new Node(data);
        if (pos <= 0 || head == null) {
            // Insert at front
            n.next = head;
            n.back = null;
            if (head != null) {
                head.back = n;
            }
            head = n;
            return;
        }

        Node cur = head;
        int idx = 0;
        // move to (pos-1)-th node, or last node if list shorter
        while (cur.next != null && idx < pos - 1) {
            cur = cur.next;
            idx++;
        }

        // insert after cur
        n.next = cur.next;
        n.back = cur;
        if (cur.next != null) {
            cur.next.back = n;
        }
        cur.next = n;
	}

	/*
		Remove the node at the given position
		If no position exists, don't change the list
	*/
    public void remove(int pos) {
        if (head == null) return;

        if (pos <= 0) {
            // remove head
            Node toRemove = head;
            head = head.next;
            if (head != null) {
                head.back = null;
            }
            // optionally help GC
            toRemove.next = null;
            toRemove.back = null;
            return;
        }

        Node cur = head;
        int idx = 0;
        while (cur.next != null && idx < pos - 1) {
            cur = cur.next;
            idx++;
        }
        // cur is (pos-1)-th node or last-1
        Node toRemove = cur.next;
        if (toRemove == null) {
            // nothing to remove
            return;
        }
        Node next = toRemove.next;
        cur.next = next;
        if (next != null) {
            next.back = cur;
        }
        // help GC
        toRemove.next = null;
        toRemove.back = null;
    }

	/*
		Print all data values in the LinkedList 
	*/
    public void printList() {
        Node cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}
