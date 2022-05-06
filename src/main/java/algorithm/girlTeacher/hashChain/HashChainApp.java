package algorithm.girlTeacher.hashChain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HashChainApp {

	public static void main(String[] args) throws IOException {
		int aKey;
		Node aDataItem;
		int size, n, keysPerCell = 100;
		System.out.println("Enter size of hash table: ");
		size = getInt();
		HashTable hashTable = new HashTable(size);
		System.out.print("Enter initial number of items: ");
		n = getInt();
		for (int i = 0; i < n; i++) {
			aKey = (int) (Math.random() * keysPerCell * size);
			aDataItem = new Node(aKey);
			hashTable.insert(aDataItem);
		}
		while(true) {
			System.out.print("Enter first letter of show, insert, delete or find:");
			char choice = getChar();
			switch(choice) {
			case 's':
				hashTable.displayTable();;
				break;
			case 'i':
				System.out.print("Enter a value to insert: ");
				aKey = getInt();
				aDataItem = new Node(aKey);
				hashTable.insert(aDataItem);
				break;
			case 'd':
				System.out.print("Enter key value to delete: ");
				aKey = getInt();
				hashTable.delete(aKey);
				break;
			case 'f':
				System.out.print("Enter a value to find: ");
				aKey = getInt();
				aDataItem = hashTable.find(aKey);
				if(aDataItem != null) {
					System.out.print("Found: " + aKey);
				}else {
					System.out.println("not found " + aKey);
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
