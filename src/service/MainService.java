package service;

import dataSt.MyHeap;

public class MainService {
	public static void main(String[] args) {
		MyHeap<Integer> heapForIntegers = new MyHeap<Integer>(2);
		
		heapForIntegers.enqueue(2);
		heapForIntegers.enqueue(54);
		heapForIntegers.enqueue(2456);
		heapForIntegers.enqueue(24);
		heapForIntegers.enqueue(23);
		heapForIntegers.enqueue(265);
		
		try {
			
			heapForIntegers.print();
			
			System.out.println(heapForIntegers.dequeue());
			System.out.println(heapForIntegers.dequeue());
			
			heapForIntegers.print();
			
		
			heapForIntegers.makeEmpty();
			heapForIntegers.enqueue(100);
			heapForIntegers.enqueue(1000);
			heapForIntegers.print();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
