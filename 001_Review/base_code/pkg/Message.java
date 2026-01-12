package pkg;
import java.util.*;
import java.io.*;

public class Message {
	String msg;
	String sender;
	String subject;
	int id;
	boolean r;
	ArrayList<Message> msgs = new ArrayList<>();
	// Default Constructor
	public Message() {
		msg = "";
		sender = "";
		subject = "";
		id = 0;
		r = false;
	}
	
	// Parameterized Constructor
	public Message(String auth, String subj, String bod, int i) {
		sender = auth;
		subject = subj;
		msg = bod;
		id = i;
		r = false;
	}

	// This function is responsbile for printing the Message
	// (whether Topic or Reply), and all of the Message's "subtree" recursively:

	// After printing the Message with indentation n and appropriate format (see output details),
	// it will invoke itself recursively on all of the Replies inside its childList, 
	// incrementing the indentation value at each new level.

	// Note: Each indentation increment represents 2 spaces. e.g. if indentation ==  1, the reply should be indented 2 spaces, 
	// if it's 2, indent by 4 spaces, etc. 
	public void print(int indentation){
		String indents = "";
    	// print this message
    	//msgs.get(qweqweqwe).print()
    	for(int i = 0; i < indentation; i++){
    	    indents = "  " + indents; // indent
    	}
    	
    	System.out.println(indents + "Sender: " + sender);
    	System.out.println(indents + "ID: " + id);
    	if(!r){
    		System.out.println(indents + "Subject: " + subject);
    	}
    	
    	System.out.println(indents + "Message: " + msg);
    	System.out.println();


    	for(int i = 0; i < msgs.size(); i++){
    	    msgs.get(i).print(indentation + 1);
    	}
    	
}


	// Default function for inheritance
	public boolean isReply(){
		return r;
	}

	// Returns the subject String
	public String getSubject(){
		return subject;
	} 

	// Returns the ID
	public int getId(){
		return id;
	}
//child are the replies
	// Adds a child pointer to the parent's childList.
	public void addChild(Message child){
		msgs.add(child);
		return;
	}
}

