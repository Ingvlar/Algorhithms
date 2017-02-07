package binarySearch;

public class BinarySearch {
	public static int binarySearch(int[] arr, int min, int max, int val){
		int mid = (min + max) / 2;
		if(val < arr[mid]){
			return binarySearch(arr, min, mid, val);
		}else if(val > arr[mid]){
			return binarySearch(arr, mid + 1, max, val);
		}else if(val == arr[mid]){
			return mid;
		}else{
			return -1;
		}
	}
	
	public static boolean findIfSumExists(int[] arr, int min, int max, int valueToFind){
		int mid = (min + max) / 2;
		if(min >= max || min == mid || min == max){
			return false;
		}
		int result = valueToFind - arr[mid];
		if(result > arr[max]){
			return findIfSumExists(arr, mid, max, valueToFind);
		}else if(result < arr[min]){
			return findIfSumExists(arr, min, mid, valueToFind);
		}else{
			return true;
		}
	}
}
