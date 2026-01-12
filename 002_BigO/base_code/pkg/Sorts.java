package pkg;
import java.util.*;
import java.util.Scanner;
import java.util.Random;


public class Sorts {
	
	public boolean search(int arr[]){
		int key = (int)(Math.random() * 200001);
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == key){
				return true;
			}
		}
		
		return false;
	}

	public void Randomize(int arr[]){
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 200001);
		}
		
	}
	
	
	public void bubble(int arr[]){
		int n = arr.length;
        int i, j;
		for( i = 0; i < n-1; i++){
			
			for(j=0; j<n-i-1; j++)
				
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
				
			}
			
		}

	
	public void insertion(int arr[]){
		int i, key, j;
		int n = arr.length;
        for ( i = 1; i< n; i++){
            key = arr[i];
            j=i-1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j=j-1;
            }
            arr[j+1] = key;
        }
	}
	
	public void selection(int arr[]){
	    int n = arr.length;
		int i, j, min_idx;
        for ( i = 0; i < n-1 ; i ++){
            min_idx = i;
            for(j = i + 1; j<n ; j++){
                if( arr[j] < arr[min_idx]){
                    min_idx = j;
                    int temp = arr[min_idx];
                    arr[min_idx] = arr[i];
                    arr[i] = temp;
                }
            }
        }

	}
	
}
