package largestSum;

import java.lang.reflect.Array;
import java.util.Scanner;

class Tuple {
	public int start;
	public int end;
	public int val;
	
	Tuple(int min, int max, int val){
		this.start = min;
		this.end = max;
		this.val = val;
	}
};

public class LargestSum {
	public static Tuple findLargestSumN2(int[] arr){
		Tuple result = new Tuple(0, 0, arr[0]);
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum = 0;
			for(int j = i; j < arr.length; j++){
				sum += arr[j];				
				if(sum > result.val){
					result.val = sum;
					result.start = i;
					result.end = j;
				}
			}
		}
		
		return result;
	}
	
	public static Tuple findLargestSumN(int[] arr){
		Tuple result = new Tuple(0, 0, arr[0]);
		int sum = arr[0];

		for(int i = 1; i < arr.length; i++){
			sum = sum + arr[i];
			if(sum < arr[i]){
				sum = arr[i];
				result.start = i;
			}
			
			if(sum > result.val){
				result.val = sum;
				result.end = i;
			}
		}
		
		return result;
	}
	
	public static Tuple findLargestSumDivideAndConquer(int[] arr, int left, int right){
		Tuple result = new Tuple(0,0,arr[0]);

		if(left == right){
			result.val = arr[left];
			result.start = left;
			result.end = right;
		}else{
			int mid = (left + right) / 2;
			Tuple leftAns = findLargestSumDivideAndConquer(arr, left, mid);
			Tuple rightAns = findLargestSumDivideAndConquer(arr, mid + 1, right);
			
			//find largestMiddleCrossingSum
			int left_index = mid;
			int right_index = mid + 1;
			
			int leftSum = Integer.MIN_VALUE;
			int left_last_index = left_index;
			int rightSum = Integer.MIN_VALUE;
			int right_last_index = right_index;
			
			int temp = 0;

			while(left_index >= left){
				temp += arr[left_index];
				if(temp > leftSum){
					leftSum = temp;
					left_last_index = left_index;
				}
				left_index--;
			}
			
			temp = 0;
			
			while(right_index <= right){
				temp += arr[right_index];
				if(temp > rightSum){
					rightSum = temp;
					right_last_index = right_index;
				}
				right_index++;
			}
			
			int sum = leftSum + rightSum;
			
			if(rightAns.val > leftAns.val && rightAns.val > sum){
				result.val = rightAns.val;
				result.start = rightAns.start;
				result.end = rightAns.end;
			}else if(leftAns.val > rightAns.val && leftAns.val > sum){
				result.val = leftAns.val;
				result.start = leftAns.start;
				result.end = leftAns.end;
			}else{
				result.val = sum;
				result.start = left_last_index;
				result.end = right_last_index;
			}
		}
		
		return result;
	}
	
	public static Tuple findLargestSumLgN(int[] arr){
		return findLargestSumDivideAndConquer(arr, 0, arr.length - 1);
	}
	
	public static void main(String[] args) {
/*		Scanner scn = new Scanner(System.in);
		int num_array = scn.nextInt();
		System.out.print("\n-----------\n");
		int[] arr = new int[num_array];
		for(int i = 0; i < num_array; i++){
			arr[i] = scn.nextInt();
		}
		scn.close();
*/
		int[] arr = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		Tuple result = findLargestSumN(arr);
		Tuple lgnresult = findLargestSumLgN(arr);
		Tuple resultN2 = findLargestSumN2(arr);
		System.out.print("\nLargest Sum: " + result.val + " from index " + result.start + " to index " + result.end);
		System.out.print("\nLargest Sum: " + lgnresult.val + " from index " + lgnresult.start + " to index " + lgnresult.end);
		System.out.print("\nLargest Sum: " + resultN2.val + " from index " + resultN2.start + " to index " + resultN2.end);

	}

}
