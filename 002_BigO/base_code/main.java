import pkg.*;
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
	public static void main(String args[]) {
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];
		Stopwatch s = new Stopwatch();
		Sorts sorter = new Sorts();
		
		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			//setups an instance
			nums = new int[i];
			sorter.Randomize(nums);
			//starts timer thing
			s.start();	
			//method its measuring
			sorter.bubble(nums);
			//stops timer thing
			s.stop();
			System.out.println("Duration: " + Stopwatch.readable(s.read()));
			System.out.println("");
		}
	}
	
}

