package heapSort;

class Heap{
	private static int parentIndex(int index){
		return index / 2;
	}
	
	private static int leftIndex(int index){
		return 2*index + 1;
	}
	
	private static int rightIndex(int index){
		return 2*index + 2;
	}
	
	private static boolean hasLeftChild(int[] arr, int index){
		if(leftIndex(index) >= arr.length){
			return false;
		}
		return true;
	}

	private static boolean hasRightChild(int[] arr, int index){
		if(rightIndex(index) >= arr.length){
			return false;
		}
		return true;
	}
	
	private static void swap(int[] arr, int a, int b){
		if(a >= 0 && a <= arr.length - 1 && b >= 0 && b <= arr.length - 1){
			int temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;			
		}
	}
	
	public static void maxHeapify(int[] arr, int index){
		int i = index;
		int leftIndex = leftIndex(index);
		int rightIndex = rightIndex(index);
		
		if(leftIndex < arr.length && arr[i] < arr[leftIndex]){
			i = leftIndex;
		}
		
		if(rightIndex < arr.length && arr[i] < arr[rightIndex]){
			i = rightIndex;
		}
		
		if(index != i){
			swap(arr, i, index);
			maxHeapify(arr, i);
		}
	}
	
	public static void maxHeapifyIterate(int[] arr, int index){
		while(index <= arr.length - 1){
			int largest = index;
			int left = leftIndex(largest);
			int right = rightIndex(largest);
			
			if(left < arr.length && arr[left] > arr[largest]){
				largest = left;
			}
			
			if(right < arr.length && arr[right] > arr[largest]){
				largest = right;
			}
			
			if(index != largest){
				swap(arr, index, largest);
				index = largest;
			}else{
				break;
			}
		}
	}

	public static void maxHeapifyIterate(int[] arr){
		for(int index = (arr.length - 1) / 2; index >= 0; index--){			
			while(index < arr.length){
				int largest = index;
				int leftIndex = leftIndex(largest);
				int rightIndex = rightIndex(largest);
				
				if(leftIndex < arr.length && arr[leftIndex] > arr[largest]){
					largest = leftIndex;
				}
				if(rightIndex < arr.length && arr[rightIndex] > arr[largest]){
					largest = rightIndex;
				}
				
				if(index != largest){
					swap(arr, largest, index);
					index = largest;
				}else{
					break;
				}
			}
		}		
	}

	
	public static void minHeapify(int[] arr, int index){
		int i = index;
		int leftIndex = leftIndex(index);
		int rightIndex = rightIndex(index);
		
		if(leftIndex < arr.length && arr[i] > arr[leftIndex]){
			i = leftIndex;
		}
		
		if(rightIndex < arr.length && arr[i] > arr[rightIndex]){
			i = rightIndex;
		}
		
		if(index != i){
			swap(arr, i, index);
			minHeapify(arr, i);
		}		
	}
	
	public static void heapify(int[] arr, boolean max){
		if(max){
			for(int i = (arr.length - 1 )/ 2; i >= 0; i--){
				maxHeapify(arr, i);
			}
		}else{
			for(int i = (arr.length - 1)/ 2; i >= 0; i--){
				minHeapify(arr, i);
			}			
		}
	}
	
	public static void heapify(int[] arr){
		for(int i = (arr.length - 1) / 2; i >= 0; i--){
			maxHeapifyIterate(arr, i);
		}
	}
};

public class HeapSort {		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {1,9,8,7,5,8,4,4,6,4,78,7,5,1,3,5,74,8,5,1,3,54,6,84,46,1,03,531,854,68,15,2,3,53,48,6};
		int[] arr = {5,6,4,3,2,1};
		Heap.heapify(arr, true);
		
		for(int i = 0; i < arr.length; i++){
			System.out.print(i + " : " + arr[i] + "\n");
		}
		System.out.print("\n\n");

		Heap.heapify(arr, false);
		for(int i = 0; i < arr.length; i++){
			System.out.print(i + " : " + arr[i] + "\n");
		}
		System.out.print("\n\n");
		
		Heap.maxHeapifyIterate(arr);
//		Heap.heapify(arr, true);
		for(int i = 0; i < arr.length; i++){
			System.out.print(i + " : " + arr[i] + "\n");
		}

	}

}
