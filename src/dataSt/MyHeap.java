package dataSt;

public class MyHeap <Ttype>{
	
	private Ttype[] heap;
	private final int DEFAULT_SIZE = 7;
	private int size = DEFAULT_SIZE;
	private int counter = 0;
	
	
	//TODO
	public MyHeap() {
		heap = (Ttype[]) new Object[size];
	}
	
	//argumenta konstruktors
	public MyHeap(int inputSize) {
		if(inputSize > 0) {
			size = inputSize;
		}
		heap = (Ttype[])new Object[size];		
	}
	
	private boolean isFull() {
		return (size == counter);
	}
	
	private boolean isEmpty()
	{
		return (counter == 0);
	}
	
	public int lenght()
	{
		return counter;
	}
	
	
	private void resize() {
		if(size < 100)
		{
			size = size * 2;
		}
		else
		{
			size = (int)(size * 1.5); //135.7 -> 135
		}
		
		Ttype[] heapNew = (Ttype[])new Object[size];
		
		for(int i = 0 ; i < counter; i++) {
			heapNew[i] = heap[i];	
		}
		
		heap = heapNew;
		
		System.gc();
			
	}
	
	public void enqueue(Ttype element) {
		if(isFull()) {
			resize();
		}
		heap[counter] = element;
		counter++;
		
		//reheap
		
		reheapUp(counter-1);
		
	}
	
	private void reheapUp(int index) {
		//kreisais b'erna index = vecaka index *2 +1
		//labaa berna index = veaka index*2 + 2
		
		
		int parentIndex = (int) (index - 1)/2; //maaksligi labajam bernam nogriez 0.5
		if(index >= 0) {
			if(((Comparable)heap[index]).compareTo(heap[parentIndex]) == 1){
				swap(index, parentIndex);
				reheapUp(parentIndex);
			}
		}
		
	}

	private void swap(int index, int parentIndex) {
		Ttype temp = heap[index];
		heap[index] = heap[parentIndex];
		heap[parentIndex] = temp;
		
	}
	
	public Ttype dequeue() throws Exception{
		if(isEmpty()) {
			throw new Exception("Cannot dequeue, heap is empty");
		}
		
		Ttype temp = heap[0];
		heap[0] = heap[counter-1];
		counter--;
		reheapDown(0);
		return temp;
	}
	
	private void reheapDown(int currentIndex) {
		int leftChildIndex = currentIndex *2 + 1;
		int rightChildIndex = currentIndex *2 + 2;
		
		if(leftChildIndex < counter && rightChildIndex < counter) {
				if(((Comparable)heap[leftChildIndex]).compareTo(heap[rightChildIndex]) == 1) {
				}
				if(((Comparable)heap[rightChildIndex]).compareTo(heap[currentIndex]) == 1) {
					swap(rightChildIndex, currentIndex);
					reheapDown(leftChildIndex);
				}
					
				else {
				if(((Comparable)heap[rightChildIndex]).compareTo(heap[currentIndex]) == 1) {
					swap(rightChildIndex, currentIndex);
					reheapDown(rightChildIndex);
				}
			
			}
		} else if(leftChildIndex < counter && rightChildIndex >= counter) {
				if(((Comparable)heap[leftChildIndex]).compareTo(heap[currentIndex]) == 1) {
					swap(leftChildIndex, currentIndex);
				}
			}
		
	}
	
	public void print() throws Exception{
		if(isEmpty()) {
			throw new Exception("Heap is empty");
		}
		printHelp(0);
	}
	private void printHelp(int currentParentIndex) {
		System.out.println("P -> "+ heap[currentParentIndex]);
		if (currentParentIndex *2 + 1 < counter) {
			System.out.println("Left child -> " + heap[currentParentIndex * 2+1]);
			printHelp(currentParentIndex * 2+1);
		}
		if(currentParentIndex *2 + 2 < counter) {
			System.out.println("Right child -> " + heap[currentParentIndex * 2+2]);
			printHelp(currentParentIndex * 2+2);
		}
	}
	
	public void makeEmpty() {
		counter = 0;
		size = DEFAULT_SIZE;
		heap = (Ttype[]) new Object[size];
		System.gc();
	}
	
	
}
