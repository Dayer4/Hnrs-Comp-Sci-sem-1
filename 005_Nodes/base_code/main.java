import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		/*
			Create an ArrayList of 100 Nodes
			Store random integers in each of them
			Print out all of the values
		*/
		ArrayList<Node> bum1 = new ArrayList<>();
		for(int i = 0; i<100;i++){
			Node bum = new Node((int)(Math.random()*10));
			bum1.add(bum);
		}
		for(int i = 0; i<99;i++){
			bum1.get(i).setNext(bum1.get(i+1));
		}
		for(int i = 0; i<100;i++){
			System.out.println(bum1.get(i).getData());
		}
	}
}
