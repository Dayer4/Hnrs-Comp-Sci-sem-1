import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;

class main {
	public static void main(String args[]) {
		Sstack bum = new Sstack();
		bum.push(0);
		System.out.println(bum.pop());
		System.out.print(bum.peek());
		bum.isEmpty();
	}
}
