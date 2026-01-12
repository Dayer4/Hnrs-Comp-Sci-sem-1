import pkg.*;
import java.io.*; 
import java.util.*;

class main {
    static final long createdNano = System.nanoTime();

    public static void main(String args[]) {
        long start = System.nanoTime();
        long finish = System.nanoTime();
        System.out.println("Created: " + createdNano);
        
        int[] times = {10, 100, 1000, 10000, 100000, 1000000, 10000000};

        System.out.println("-------------------Test-------------------\n");
        for(int i : times){
            System.out.println("Interval: " + i);
            start = System.nanoTime();

            File bum = new File("births.csv");
            ArrayList<DayBirth> M = new ArrayList<>();
            ArrayList<DayBirth> F = new ArrayList<>();

            DayBirth db = new DayBirth("","","","",""); // dummy instance
            db.sort(M, F, bum); // separates males and females

            // Sort by births
            db.qsort(M, 0, M.size() - 1);
            db.qsort(F, 0, F.size() - 1);
            
            DayBirth.saveToCSV(M, "males_sorted.csv");
            DayBirth.saveToCSV(F, "females_sorted.csv");
            
            finish = System.nanoTime();
            System.out.println("Started: " + start);
            System.out.println("Finished: " + finish);
            System.out.println("Duration: " + (finish-start) + "\n");
            DayBirth.saveToCSV(M, "males_sorted.csv");
            DayBirth.saveToCSV(F, "females_sorted.csv");
        }
        
    }
}
