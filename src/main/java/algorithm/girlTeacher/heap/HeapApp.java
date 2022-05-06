package algorithm.girlTeacher.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapApp {

	public static void main(String[] args) throws IOException {
		int value, value2;
		Heap heap = new Heap(31);
		boolean success;
		heap.insert(70);
		heap.insert(40);
		heap.insert(50);
		heap.insert(20);
		heap.insert(60);
		heap.insert(100);
		heap.insert(80);
		heap.insert(30);
		heap.insert(10);
		heap.insert(90);

		while(true) {
			System.out.print("Enter first letter of show, insert, find, delete, or traverse: ");
			char choice = getChar();
			switch(choice) {
			case 's':
				heap.displayHeap();
				break;
			case 'i':
				System.out.print("Enter a value to insert: ");
				value = getInt();
				success = heap.insert(value);
				if(!success) {
					System.out.println("Could not insert, heap full.");
				}
				break;
			case 'r':
				if(!heap.isEmpty()) {
					heap.remove();
				}else {
					System.out.println("Could not remove, heap empty.");
				}
				break;
			case 'c':
				System.out.println("Enter current index of item:");
				value = getInt();
				System.out.println("Enter new key:");
				value2 = getInt();
				success = heap.change(value, value2);
				if(!success) {
					System.out.println("Invalid index.");
				}
				break;
			default:
				System.out.println("Invalid enter.");
			}
		}
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException {
		return getString().charAt(0);
	}

	public static int getInt() throws IOException {
		String str = getString();
		int i = Integer.parseInt(str);
		return i;
	}
}
