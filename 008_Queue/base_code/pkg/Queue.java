package pkg;
import java.util.Scanner;
import java.util.Random;


public class Queue {	
	/*  FIRST IN FIRST OUT  */
	Node head;
	Node tail;

	/* 
		Postcondition: The top will be null.
	*/
	public Queue() {
		head = new Node(0);
	}

	/*
		Adds a node to the end of the queue
	*/
	public void enqueue(int data){
		tail = new Node(data);
	}

	/*
		Removes a node from the front of the queue
	*/
	public int dequeue(){
		head = head.getNext();
	}

	/*
		Checks if the stack is empty. 
	*/
	public boolean isEmpty(){
		if(head.getData != 0){
			return false;
		}
		Node current = head.getNext();
		while(head.getData() == 0){
			if{current != 0){
				return false;
			}
			current = current.getNext();
		}
		return true;
	}

	/* 
		Returns the value of the frontmost element
	*/
	public int front(){
		return head.getData();
	}

	/*
		Returns the value at the end of the queue
	*/
	public int back(){
		return tail.getData();
	}

}
