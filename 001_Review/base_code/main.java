import pkg.*;
import java.util.*;
import java.io.*;       
import java.util.Scanner;
class main {        
	public static void main(String args[]) throws FileNotFoundException {
	    System.out.println("before bboard creation");
        BBoard myBoard = new BBoard("Poole's Amazing BBoard");  
        System.out.println("after bboard creation");
        // Feel free to change the name.
        System.out.println("before load users");
        myBoard.loadUsers(args[0]);
        System.out.println("out of load users");
        System.out.println("before  login ");
        myBoard.login();
        System.out.println("after  login ");
        System.out.println("before  run ");
        myBoard.run();
        System.out.println("after  run ");
            // Read and print the first line
            
            //!!!!!!!!!TO RUN THIS FILE RIGHT CLICK ON IT THEN OPEN TERMINAL THEN PUT java main users.txt
        // Feel free to add code for testing purposes. 

        // Examine data.txt for example Messages displayed from the BBoard

        // Examine users.txt for the format of users and their passwords. 
	}
}
