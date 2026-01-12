package pkg;
import java.util.*;
import java.io.*;
import java.util.Scanner;
public class BBoard {		// This is your main file that connects all classes.
	// Think about what your global variables need to be.
		String title;
		User cU; //current user
		boolean loggedIn;
		Scanner sc = new Scanner(System.in);
		int numMessages;
		ArrayList<User> users = new ArrayList<User>();
    	ArrayList<Message> msgs = new ArrayList<Message>();
    	
	// Default constructor that creates a board with a defaulttitle, empty user and message lists,
	// and no current user
	public BBoard() {
		System.out.print("during bboard creation");
		title = "";
		loggedIn = false;
	}

	// Same as the default constructor except it sets the title of the board
	public BBoard(String ttl) {	
		System.out.print("during bboard creation");
		title = ttl;
		loggedIn = false;
	}

	// Gets a filename of a file that stores the user info in a given format (users.txt)
	// Opens and reads the file of all authorized users and passwords
	// Constructs a User object from each name/password pair, and populates the userList ArrayList.
	public void loadUsers(String inputFile) throws FileNotFoundException {
			System.out.println("in load users");
			File file = new File(inputFile);
			Scanner fileE = new Scanner(file);
            // Read and print the first line
            int i = 0;
            while(fileE.hasNext()) {
            	String line = fileE.nextLine();
            	int sL = line.indexOf(" "); //gives index of space
            	String usern = line.substring(0,sL);
            	String psw = line.substring(sL+1,line.length());
            	User user = new User(usern,psw);
				users.add(user);
                System.out.println("user" + user.getUsername() + ": " + user.getPass());
                i++;
            }
            
	}

	// Asks for and validates a user/password. 
	// This function asks for a username and a password, then checks the userList ArrayList for a matching User.
	// If a match is found, it sets currentUser to the identified User from the list
	// If not, it will keep asking until a match is found or the user types 'q' or 'Q' as username to quit
	// When the users chooses to quit, sayu "Bye!" and return from the login function
	public void login(){
		System.out.println("during login");
		System.out.println("User plz (Q/q to quit):");
		String inputedUser = sc.nextLine();
		if(inputedUser.equals("q")||inputedUser.equals("Q")){
			System.out.print("Bye!");
			return;
		}
		System.out.println("Password plz (Q/q to quit):");
		String inputedPass = sc.nextLine();
		if(inputedPass.equals("q")||inputedPass.equals("Q")){
			System.out.print("Bye!");
			return;
		}
		
		for(User u : users){
			if(u.check(inputedUser,inputedPass)){
				System.out.println("Success");
				loggedIn = true;
				return;
			}
		}
		System.out.println("Invalid user or password");
	}
	
	// Contains main loop of Bulletin Board
	// IF and ONLY IF there is a valid currentUser, enter main loop, displaying menu items
	// --- Display Messages ('D' or 'd')
	// --- Add New Topic ('N' or 'n')
	// --- Add Reply ('R' or 'r')
	// --- Change Password ('P' or 'p')
	// --- Quit ('Q' or 'q')
	// With any wrong input, user is asked to try again
	// Q/q should reset the currentUser to 0 and then end return
	// Note: if login() did not set a valid currentUser, function must immediately return without showing menu
	public void run(){
		System.out.println("during run");
		while(loggedIn){
			Scanner sc = new Scanner(System.in);
			System.out.println("Display Messages ('D' or 'd'): ");
			System.out.println(" Add New Topic ('N' or 'n')");
			System.out.println("Add Reply ('R' or 'r')");
			System.out.println("Change Password ('P' or 'p') ");
			System.out.println("Quit ('Q' or 'q')");
			String input = sc.nextLine();
			if(input.equals("q") || input.equals("Q")){
				System.out.print("Bye!");
				return;
			}else if(input.equals("d") || input.equals("D")){
				display();
			}else if(input.equals("r") || input.equals("R")){
				addReply();
			}else if(input.equals("n") || input.equals("N")){
				addTopic();
			}else if(input.equals("P") || input.equals("p")){
				setPassword();
			}else{
				System.out.print("Invalid Input Try Again");
			}
		}
	}

	// Traverse the BBoard's message list, and invote the print function on Topic objects ONLY
	// It will then be the responsibility of the Topic object to invoke the print function recursively on its own replies
	// The BBoard display function will ignore all reply objects in its message list
	private void display(){
		for(int i = 0; i < msgs.size(); i++){
			Message m = msgs.get(i);
			if (!m.isReply()) {   // only topics
    			m.print(0);       // start printing at indent 0
			}

			if(msgs.get(i).isReply()){
				System.out.print(i + ": ");
				msgs.get(i).print(3);
			}
		}
		
	}


	// This function asks the user to create a new Topic (i.e. the first message of a new discussion "thread")
	// Every Topic includes a subject (single line), and body (single line)

	/* 
	Subject: "Thanks"
	Body: "I love this bulletin board that you made!"
	*/

	// Each Topic also stores the username of currentUser; and message ID, which is (index of its Message + 1)

	// For example, the first message on the board will be a Topic who's index will be stored at 0 in the messageList ArrayList,
	// so its message ID will be (0+1) = 1
	// Once the Topic has been constructed, add it to the messageList
	// This should invoke your inheritance of Topic to Message
	private void addTopic(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("New subject plz");
		String sub = sc.nextLine();
		System.out.println("New body plz");
		String bod = sc.nextLine();
		int identification = numMessages + 1; //)(*!&@#)(TE THIS LATER) CHANGE THIS LATER
		Message messageE = new Message(cU.getUsername(),sub,bod,identification);
		msgs.add(messageE);
		numMessages++;
		return;
	}

	// This function asks the user to enter a reply to a given Message (which may be either a Topic or a Reply, so we can handle nested replies).
	//		The addReply function first asks the user for the ID of the Message to which they are replying;
	//		if the number provided is greater than the size of messageList, it should output and error message and loop back,
	// 		continuing to ask for a valid Message ID number until the user enters it or -1.
	// 		(-1 returns to menu, any other negative number asks again for a valid ID number)
	
	// If the ID is valid, then the function asks for the body of the new message, 
	// and constructs the Reply, pushing back the Reply on to the messageList.
	// The subject of the Reply is a copy of the parent Topic's subject with the "Re: " prefix.
	// e.g., suppose the subject of message #9 was "Thanks", the user is replying to that message:


	/*
			Enter Message ID (-1 for Menu): 9
			Body: It was a pleasure implementing this!
	*/

	// Note: As before, the body ends when the user enters an empty line.
	// The above dialog will generate a reply that has "Re: Thanks" as its subject
	// and "It was a pleasure implementing this!" as its body.

	// How will we know what Topic this is a reply to?
	// In addition to keeping a pointer to all the Message objects in BBoard's messageList ArrayList
	// Every Message (wheather Topic or Reply) will also store an ArrayList of pointers to all of its Replies.
	// So whenever we build a Reply, we must immediately store this Message in the parent Message's list. 
	// The Reply's constructor should set the Reply's subject to "Re: " + its parent's subject.
	// Call the addChild function on the parent Message to push back the new Message (to the new Reply) to the parent's childList ArrayList.
	// Finally, push back the Message created to the BBoard's messageList. 
	// Note: When the user chooses to return to the menu, do not call run() again - just return fro mthis addReply function. 
	public void addReply() {

    while (true) {
        System.out.print("Enter Message ID (-1 for Menu): ");
        int replyId = sc.nextInt();
        sc.nextLine(); // clear newline

        if (replyId == -1) {
            return; // back to menu
        }

        if (replyId <= 0 || replyId > numMessages) {
            System.out.println("Invalid ID");
            continue; // ask again
        }

        // Find the parent message iteratively (BFS)
        Message parent = null;
        Queue<Message> queue = new LinkedList<>();
        for (Message m : msgs) {
            queue.add(m);
        }

        while (!queue.isEmpty()) {
            Message current = queue.poll();
            if (current.getId() == replyId) {
                parent = current;
                break;
            }
            queue.addAll(current.msgs); // add its children to check too
        }

        if (parent == null) {
            System.out.println("Message not found.");
            continue;
        }

        // Ask for reply body
        System.out.println("Body: ");
        String body = sc.nextLine();

        // Create reply with subject = "Re: " + parent subject
        int identification = numMessages + 1;
        Reply reply = new Reply(cU.getUsername(), "Re: " + parent.getSubject(), body, identification);

        // Add reply to parent + global list
        parent.addChild(reply);
        msgs.add(reply);
        numMessages++;

        System.out.println("Reply added successfully!");
	}
	}
	// This function allows the user to change their current password.
	// The user is asked to provide the old password of the currentUser.
	// 		If the received password matches the currentUser password, then the user will be prompted to enter a new password.
	// 		If the received password doesn't match the currentUser password, then the user will be prompted to re-enter the password. 
	// 		The user is welcome to enter 'c' or 'C' to cancel the setting of a password and return to the menu.
	// Any password is allowed except 'c' or 'C' for allowing the user to quit out to the menu. 
	// Once entered, the user will be told "Password Accepted." and returned to the menu.
	public void setPassword(){
		System.out.println("gimme old pass(c/C for cancel)");
		String pass = sc.nextLine();
		if(pass.equals("c")||pass.equals("C")){
			return;
		}
		boolean firstCheck = cU.check(cU.getUsername(),pass);
		if(firstCheck){
			System.out.println("gimme new pass");
			String newPass = sc.nextLine();	
			System.out.print("Password Changed");
		}
		System.out.print("invalid password");
		return;
	}

}
