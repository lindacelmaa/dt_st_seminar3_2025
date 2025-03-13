package service;

import dataSt.MyHeap;
import dataSt.Patient;

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
		
		System.out.println("---------- Pacienti ----------------");
		MyHeap<Patient> heapForPatients = new MyHeap<Patient>(2);
		heapForPatients.enqueue(new Patient("Janis", "Be", 5));
		heapForPatients.enqueue(new Patient("Anna", "Be", 6));
		heapForPatients.enqueue(new Patient("Janisdd", "Be", 10));
		heapForPatients.enqueue(new Patient("Janisdd", "Be", 8));
		heapForPatients.enqueue(new Patient("Janidsas", "Be", 9));
		
		try {
			heapForPatients.print();
			System.out.println(heapForPatients.dequeue());
			System.out.println(heapForPatients.dequeue());
			
			heapForPatients.makeEmpty();
			heapForPatients.enqueue(new Patient("Kaspars", "Gudrais", 4));
			heapForPatients.enqueue(new Patient("Ilze", "Gudrais", 3));
			heapForPatients.print();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		

	}
	
	
	
}
