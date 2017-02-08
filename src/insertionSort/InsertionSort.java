package insertionSort;

import java.util.*;


public class InsertionSort {
	
	public static void arrayInsert(int[] arr, int n){
		int key = arr[n];
		int j = n - 1;
		while(j >= 0 && key < arr[j]){
			arr[j+1] = arr[j];
			j--;
		}
		arr[j+1] = key;
	}
	
	public static void arraySort(int[] arr, int n){
		if(n > 0){
			arraySort(arr, n - 1);
			arrayInsert(arr, n);
		}
	}
	public static void insertionSort(int[] arr){
		arraySort(arr, arr.length - 1);
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num_array = scn.nextInt();
		int[] arr = new int[num_array];
		for(int i = 0; i < num_array; i++){
			arr[i] = scn.nextInt();
		}
		scn.close();
		
		insertionSort(arr);
		for(int x : arr){
			System.out.print(x + "\n");
		}
		
		int searchValue = binarySearch.BinarySearch.binarySearch(arr, 0, arr.length - 1, 7);
		
		System.out.print("Searched for 7: " + searchValue);
	}

}
