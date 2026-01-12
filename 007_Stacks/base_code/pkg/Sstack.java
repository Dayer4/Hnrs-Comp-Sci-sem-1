package pkg;
import java.util.Scanner;
import java.util.Random;


public class Sstack {
	/*  LAST IN FIRST OUT  */
	Node top;

	/* 
		Postcondition: The top will be null.
	*/
	public Sstack() {
		top = new Node();
	}

	/*
		Insert a new Node on top of the stack
	*/
	public void push(int data){
		Node bum = new Node(data);
		top.setNext(bum);
		top = bum;
	}

	/*
		Removes the top node of the stack
	*/
	public int pop(){
		int x = top.getNext().getData();
		top = top.getNext();
		return x;
	}

	/*
		Returns the top value of the stack. Doesn't pop. 
	*/
	public int peek(){
		return top.getData();
	}

	/*
		Checks if the stack is empty. 
	*/
	public boolean isEmpty(){
		if(top.getData() == 0){
			return true;
		}
		Node current = top.getNext();
		while(true){
			if(current.getData() == 0){
				return true;
			}else{
				current = current.getNext();
			}
		}
	}
}
