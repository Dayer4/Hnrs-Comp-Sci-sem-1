package pkg;
import java.io.*; 
import java.util.*;
import java.time.*;
import java.lang.*;



public class dayBirth {
	
             //   try (FileWriter writer = new FileWriter("f.csv")) {
            	// for (List<String> fs : f) {
            	//     writer.append(String.join(",", fs)); // join list items with commas
            	//     writer.append("\n"); // move to next line
            	// }
             //   }
            	// try (FileWriter writer = new FileWriter("m.csv")) {
            	// for (List<String> ms : m) {
            	//     writer.append(String.join(",", ms)); // join list items with commas
            	//     writer.append("\n"); // move to next line
            	// }
            	// }
            	
            
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
	
	public boolean search(List<String> arr){
    String key = "" + (int)(Math.random() * 200001);
    for(int i = 0; i < arr.size(); i++){
        if(arr.get(i).equals(key)){
            return true;
        }
    }
    return false;
    }

	
	public void Randomize(String arr[]){
		for(int i = 0; i < arr.length; i++){
			arr[i] = "" + (int)(Math.random() * 200001);
		}
		
	}
	public boolean check(int a, int b){
		if(a > b){
			
			return true;
			
		}else{
			
			return false;
		
		} 
	}
	
// Merge sort for ArrayList<dayBirth> by births
public void mergeSort(ArrayList<dayBirth> list, int left, int right) {
    if (left < right) {
        int mid = (left + right) / 2;
        mergeSort(list, left, mid);
        mergeSort(list, mid + 1, right);
        merge(list, left, mid, right);
    }
}

private void merge(ArrayList<dayBirth> list, int left, int mid, int right) {
    ArrayList<dayBirth> leftList = new ArrayList<>(list.subList(left, mid + 1));
    ArrayList<dayBirth> rightList = new ArrayList<>(list.subList(mid + 1, right + 1));

    int i = 0, j = 0, k = left;

    while (i < leftList.size() && j < rightList.size()) {
        int leftBirths = Integer.parseInt(leftList.get(i).births);
        int rightBirths = Integer.parseInt(rightList.get(j).births);

        if (leftBirths <= rightBirths) {
            list.set(k, leftList.get(i));
            i++;
        } else {
            list.set(k, rightList.get(j));
            j++;
        }
        k++;
    }

    while (i < leftList.size()) {
        list.set(k, leftList.get(i));
        i++;
        k++;
    }

    while (j < rightList.size()) {
        list.set(k, rightList.get(j));
        j++;
        k++;
    }
}

public void sort(ArrayList<dayBirth> M, ArrayList<dayBirth> F, File bumer) {
    try (Scanner read = new Scanner(bumer)) {
        while (read.hasNextLine()) {
            read.nextLine();
            String currentLine = read.nextLine();
            int comma = currentLine.indexOf(",");
            String y = currentLine.substring(0,comma);
            currentLine = currentLine.substring(comma+1);
            comma = currentLine.indexOf(",");
            String mOnTh = currentLine.substring(0,comma);
            currentLine = currentLine.substring(comma+1);
            comma = currentLine.indexOf(",");
            String d = currentLine.substring(0,comma);
            currentLine = currentLine.substring(comma+1);
            comma = currentLine.indexOf(",");
            String g = currentLine.substring(0,comma);
            currentLine = currentLine.substring(comma+1);
            comma = currentLine.indexOf(",");
            String b = currentLine.substring(0);
            
            dayBirth e = new dayBirth(y,mOnTh,d,g,b);

            if(e.gender.equals("M")){
                M.add(e);
            } else {
                F.add(e);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + bumer.getName());
        e.printStackTrace();
    }
}


}
