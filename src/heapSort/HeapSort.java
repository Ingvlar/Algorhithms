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
	public static void minHeapify(int[] arr, int index, int heapSize){
		int i = index;
		int leftIndex = leftIndex(index);
		int rightIndex = rightIndex(index);
		
		if(leftIndex <= heapSize && arr[i] > arr[leftIndex]){
			i = leftIndex;
		}
		
		if(rightIndex <= heapSize && arr[i] > arr[rightIndex]){
			i = rightIndex;
		}
		
		if(index != i){
			swap(arr, i, index);
			minHeapify(arr, i, heapSize);
		}		
	}
	
	public static void maxHeapify(int[] arr, int index, int heapSize){
		int i = index;
		int leftIndex = leftIndex(index);
		int rightIndex = rightIndex(index);
		
		if(leftIndex <= heapSize && arr[i] < arr[leftIndex]){
			i = leftIndex;
		}
		
		if(rightIndex <= heapSize && arr[i] < arr[rightIndex]){
			i = rightIndex;
		}
		
		if(index != i){
			swap(arr, i, index);
			maxHeapify(arr, i, heapSize);
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

	public static void minHeapifyIterate(int[] arr){
		int heapSize = arr.length - 1;
		for(int i = heapSize / 2; i >= 0; i--){
			int index = i;
			int smallest;
			int left;
			int right;

			while(index <= heapSize){
				smallest = index;
				left = leftIndex(index);
				right = rightIndex(index);
				if(left <= heapSize && arr[left] < arr[smallest]){
					smallest = left;
				}
				
				if(right <= heapSize && arr[right] < arr[smallest]){
					smallest = right;
				}
				
				if(smallest != index){
					swap(arr, smallest, index);
					index = smallest;
				}else{
					break;
				}
			}		
		}
	}

	public static void heapSortMax(int[] arr){
		int heapSize = arr.length - 1;
		while(heapSize >= 0){
			for(int i = heapSize / 2; i >= 0; i--){
				maxHeapify(arr, i, heapSize);
			}
			swap(arr, heapSize, 0);
			heapSize--;
		}
	}
	
	public static void heapSortMin(int[] arr){
		int heapSize = arr.length - 1;
		while(heapSize >= 0){
			for(int i = heapSize / 2; i >= 0; i--){
				minHeapify(arr, i, heapSize);
			}
			swap(arr, heapSize, 0);
			heapSize--;
		}
	}
	
	public static void buildHeap(int[] arr, boolean max){
		int heapSize = arr.length - 1;
		if(max){
			for(int i = (arr.length - 1 )/ 2; i >= 0; i--){
				maxHeapify(arr, i, heapSize);
			}
		}else{
			for(int i = (arr.length - 1)/ 2; i >= 0; i--){
				minHeapify(arr, i, heapSize);
			}			
		}
	}	
};

public class HeapSort {		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,9,8,7,5,8,4,4,6,4,78,7,5,1,3,5,74,8,5,1,3,54,6,84,46,1,03,531,854,68,15,2,3,53,48,6};
//		int[] arr = {5,6,4,3,2,1};
		System.out.print("\n\nBuild Max Heap");
		System.out.print("\n------------------\n");
		Heap.buildHeap(arr, true);
		
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " | ");
		}
		System.out.print("\n\nBuild Min Heap");
		System.out.print("\n------------------\n");
		
		Heap.buildHeap(arr, false);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " | ");
		}
		System.out.print("\n\nBuild Max Heap Iterate");
		System.out.print("\n------------------\n");
		
		Heap.maxHeapifyIterate(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " | ");
		}
		
		System.out.print("\n\nBuild Min Heap Iterate");
		System.out.print("\n------------------\n");
		Heap.minHeapifyIterate(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " | ");
		}

		System.out.print("\n\nMax HeapSort -- sort ascending order");
		System.out.print("\n------------------\n");

		Heap.heapSortMax(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " | ");
		}

		System.out.print("\n\nMin HeapSort -- sort descending order");
		System.out.print("\n------------------\n");

		Heap.heapSortMin(arr);
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " | ");
		}

	}

}
