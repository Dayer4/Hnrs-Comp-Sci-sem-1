import pkg.*;
import java.io.*; 
import java.util.*;
import java.time.*;
import java.lang.*;


class main {
	static final long createdNano = System.nanoTime();

	public static void main(String args[]) throws FileNotFoundException {
		long start = System.nanoTime();
		long finish = System.nanoTime();
		System.out.println("Created: " + createdNano);
		
		int [] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};
		int [] nums = new int[100];
		
		System.out.println("-------------------Test-------------------");
		System.out.println("");
		for(int i : times){
			System.out.println("Interval: " + i);
			
			nums = new int[i];
			start = System.nanoTime();

			//  Put your method between these two comments
			
			File bum = new File("births.csv");
            Scanner read = new Scanner(bum);
            
            ArrayList<dayBirth> M = new ArrayList<>();
			ArrayList<dayBirth> F = new ArrayList<>();
			
			dayBirth db = new dayBirth("","","","",""); // dummy instance
			db.sort(M, F, bum);

			// Sort the ArrayLists
			db.mergeSort(M, 0, M.size() - 1);
			db.mergeSort(F, 0, F.size() - 1);
			
			finish = System.nanoTime();
            System.out.println("Started: " + start);
			System.out.println("Finished: " + finish);
			System.out.println("Duration: " + (finish-start));
			System.out.println("");
		}
        }
	}
