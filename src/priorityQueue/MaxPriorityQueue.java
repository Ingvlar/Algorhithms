package priorityQueue;

class QueueElement implements Comparable<QueueElement>{
	int digit;
	int key;
	QueueElement(int digit, int key){
		this.digit = digit;
		this.key = key;
	}
	public int compareTo(QueueElement o) {
		// TODO Auto-generated method stub
		return Integer.compare(o.digit, this.digit);
	}
}

class PriorityQueueMax {
	private int queueIndex = -1;
	private final int size = 10;
	private QueueElement[] arr = new QueueElement[size + 1];
	
	PriorityQueueMax(){
		
	};
	
	public void insert(QueueElement element){
		queueIndex++;
		ensureSize();
		arr[queueIndex] = element;
		heapifyUp(queueIndex);
	}
	
	public void insert(int digit, int key){
		queueIndex++;
		ensureSize();
		QueueElement a = new QueueElement(digit, Integer.MIN_VALUE);
		arr[queueIndex] = a;
		increaseKey(queueIndex, key);
	}
	
	public void insert(int digit){
		for(int i = 0; i <= queueIndex; i++){
			increaseKey(i, arr[i].key++);
		}
		insert(digit, 0);
	}
	
	public QueueElement max(){
		if(queueIndex < 0){
			return null;
		}
		return arr[0];
	}
	
	public QueueElement extractMax(){
		if(queueIndex < 0){
			return null;
		}
		QueueElement toReturn = arr[0];
		arr[0] = arr[queueIndex];
		queueIndex--;
		heapifyDown();
		return toReturn;
	}
	
	public void increaseKey(int index, int key){
		QueueElement a = arr[index];
		if(a.key < key){
			a.key = key;
			heapifyUp(index);
		}
	}
	
	public void printQueue(){
		for(int i = 0; i <= queueIndex; i++){
			System.out.print("key: " + arr[i].key + " digit: " + arr[i].digit + "\n");
		}
	}
	
	private void heapifyUp(int index){
		int parent = parentIndex(index);

		if(parent >= 0 && arr[index].key > arr[parent].key){
			swap(index, parent);
			heapifyUp(parent);
		}
	}
	
	private void heapifyDown(){
		for(int i = queueIndex / 2; i >= 0; i--){
			maxHeapify(i);
		}
	}
	
	private void maxHeapify(int index){
		int left = leftIndex(index);
		int right = rightIndex(index);
		int largest = index;
		if(left <= queueIndex && arr[left].key > arr[largest].key){
			largest = left;
		}
		
		if(right <= queueIndex && arr[right].key > arr[largest].key){
			largest = right;
		}
		
		if(largest != index){
			swap(largest, index);
			maxHeapify(largest);
		}
	}
	
	private void swap(int a, int b){
		QueueElement temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private int leftIndex(int index){
		return (2*index) + 1;
	}
	
	private int rightIndex(int index){
		return (2*index) + 2;
	}
	
	private int parentIndex(int index){
		return (index - 1)/2;
	}
	
	private void ensureSize(){
		if(arr.length == queueIndex){
			QueueElement[] temp = new QueueElement[arr.length + size];
			System.arraycopy(arr, 0, temp, 0, queueIndex);
			arr = temp;
		}
	}	
}

public class MaxPriorityQueue {
	public static void main(String[] args) {
		PriorityQueueMax priorityQueue = new PriorityQueueMax();
/*		priorityQueue.insert(new QueueElement(15, 0));
		priorityQueue.insert(new QueueElement(5, 1));
		priorityQueue.insert(new QueueElement(6, 9));
		priorityQueue.insert(new QueueElement(1, 27));
		priorityQueue.insert(new QueueElement(5, 8));
		priorityQueue.insert(new QueueElement(3, 6));
		priorityQueue.insert(new QueueElement(9, 4));
		priorityQueue.insert(new QueueElement(15, 10));
		priorityQueue.insert(new QueueElement(5, 11));
		priorityQueue.insert(new QueueElement(6, 91));
		priorityQueue.insert(new QueueElement(1, 17));
		priorityQueue.insert(new QueueElement(5, 18));
		priorityQueue.insert(new QueueElement(3, 16));
		priorityQueue.insert(new QueueElement(9, 14));
		
		priorityQueue.printQueue();
		System.out.print("\n\n\n");
		System.out.print("key: " + priorityQueue.max().key + " digit: " + priorityQueue.max().digit + "\n");
		priorityQueue.increaseKey(0, 999);
		QueueElement a = priorityQueue.extractMax();
		System.out.print("key: " + a.key + " digit: " + a.digit + "\n");
		System.out.print("key: " + priorityQueue.max().key + " digit: " + priorityQueue.max().digit + "\n");
		priorityQueue.extractMax();
		priorityQueue.extractMax();
		priorityQueue.extractMax();
		priorityQueue.extractMax();
		
		System.out.print("\n\n\n");
		priorityQueue.printQueue();*/
		
		priorityQueue.insert(15);
		priorityQueue.insert(10);
		priorityQueue.insert(18);
		priorityQueue.insert(12);
		priorityQueue.insert(9);
		priorityQueue.insert(6);
		priorityQueue.insert(14);
		
		priorityQueue.printQueue();
		priorityQueue.extractMax();		
		System.out.print("\n\n");
		priorityQueue.printQueue();
		priorityQueue.extractMax();		
		System.out.print("\n\n");
		priorityQueue.printQueue();
		priorityQueue.extractMax();		
		System.out.print("\n\n");
		priorityQueue.printQueue();
		priorityQueue.extractMax();		
		System.out.print("\n\n");
		priorityQueue.printQueue();
		priorityQueue.extractMax();		
		System.out.print("\n\n");
		priorityQueue.printQueue();
		priorityQueue.extractMax();		
		System.out.print("\n\n");
		priorityQueue.printQueue();
	}
}
