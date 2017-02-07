package insertionSort;

import java.util.*;


public class InsertionSort {
	
	public static void arrayInsert(int[] arr, int n){
		int temp = 0;
		while(n > 0){
			if(arr[n-1] > arr[n]){
				temp = arr[n];
				arr[n] = arr[n-1];
				arr[n-1] = temp;
			}
			n--;
		}
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
		int searchValue = binarySearch.BinarySearch.binarySearch(arr, 0, arr.length - 1, 7);
		for(int x : arr){
			System.out.print(x + "\n");
		}
		
		System.out.print("Searched for 7: " + searchValue);
	}

}
