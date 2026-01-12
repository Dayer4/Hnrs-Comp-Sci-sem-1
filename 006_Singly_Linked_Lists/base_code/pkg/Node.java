package pkg;
import java.util.Scanner;
import java.util.Random;


public class Node {
	public Node next;
	public int data;
	public Node back;

	public Node(int data) {
		next = null;
		this.data = data;
		back = null;
	}
	public void setNext(Node next){
		this.next = next;
	}
	public void setBack(Node back){
		this.back = back;
	}
	public int getData(){
		return data;
	}	
	public Node getNext(){
		return next;
	}
	public Node getBack(){
		return back;
	}
}
