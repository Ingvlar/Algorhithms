package mergeSort;

import java.util.*;

public class MergeSort {
	
	public static int mergeHalves(int[] arr, int min, int max, int[] temp){
		int mid = (min + max) /2;
		int leftStart = min;
		int leftEnd = mid;
		int rightStart = mid + 1;
		int rightEnd = max;
		
		int left = leftStart;
		int right = rightStart;
		int temp_index = leftStart;
		
		int size = rightEnd - leftStart + 1;
		
		int count = 0;
		while(left <= leftEnd && right <= rightEnd){
			if(arr[left] <= arr[right]){
				temp[temp_index] = arr[left];
				left++;
			}else{
				temp[temp_index] = arr[right];
				right++;
				count = count + (leftEnd - left) + 1;
			}
			temp_index++;
		}
		
		if(left <= leftEnd){
			System.arraycopy(arr, left, temp, temp_index, leftEnd - left + 1);
		}
		
		if(right <= rightEnd){
			System.arraycopy(arr, right, temp, temp_index, rightEnd - right + 1);			
		}
		
		System.arraycopy(temp, leftStart, arr, leftStart, size);
		return count;
	}
	
	public static int mergeSort(int[] arr, int min, int max, int[] temp){
		int count = 0;
		if(min < max){
			int mid = (min + max) / 2;
			count += mergeSort(arr, min, mid, temp);
			count += mergeSort(arr, mid + 1, max, temp);
			count += mergeHalves(arr, min, max, temp);
		}
		return count;
	}
	
	public static int mergeSort(int[] arr){
		return mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num_array = scn.nextInt();
		int[] arr = new int[num_array];
		for(int i = 0; i < num_array; i++){
			arr[i] = scn.nextInt();
		}
		scn.close();
		
		int inversions = mergeSort(arr);
		
		for(int x : arr){
			System.out.print(x + "\n");
		}
		
		System.out.print("Inversions: " + inversions);
		

	}

}
