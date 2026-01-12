package pkg;
import java.io.*; 
import java.util.*;
import java.time.*;
import java.lang.*;

public class DayBirth {
    
    public String year;
    public String month;
    public String day;
    public String gender;
    public String births;

    public DayBirth(String y, String m, String d, String g, String b){
        year = y;
        month = m;
        day = d;
        gender = g;
        births = b;
    }

    // QuickSort by births
    public void qsort(ArrayList<DayBirth> list, int sss, int eee) {
        if (eee <= sss) return;

        DayBirth pivot = list.get(sss);
        int pivotVal = Integer.parseInt(pivot.births);
        int i = sss + 1;

        for (int j = sss + 1; j <= eee; j++) {
            int currentVal = Integer.parseInt(list.get(j).births);
            if (currentVal < pivotVal) {
                DayBirth tmp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, tmp);
                i++;
            }
        }

        list.set(sss, list.get(i - 1));
        list.set(i - 1, pivot);

        qsort(list, sss, i - 2);
        qsort(list, i, eee);
    }

    // Read CSV and separate male/female
    public void sort(ArrayList<DayBirth> M, ArrayList<DayBirth> F, File bumer) {
        try (Scanner read = new Scanner(bumer)) {
            if(read.hasNextLine()) read.nextLine(); // skip header

            while (read.hasNextLine()) {
                String currentLine = read.nextLine();
                String[] parts = currentLine.split(",", -1);

                DayBirth e = new DayBirth(parts[0], parts[1], parts[2], parts[3], parts[4]);
                if(e.gender.equals("M")) 
                    M.add(e);
                else 
                    F.add(e);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + bumer.getName());
            e.printStackTrace();
        }
    }

public static void saveToCSV(ArrayList<DayBirth> list, String filename) {
    try (PrintWriter pw = new PrintWriter(new File(filename))) {
        pw.println("Year,Month,Day,Gender,Births"); // header
        for (DayBirth db : list) {
            pw.println(db.year + "," + db.month + "," + db.day + "," + db.gender + "," + db.births);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
