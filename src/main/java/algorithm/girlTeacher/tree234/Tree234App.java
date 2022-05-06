package algorithm.girlTeacher.tree234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tree234App {

	public static void main(String[] args) throws IOException {
		long value;
		Tree234 tree = new Tree234();
		tree.insert(50);
		tree.insert(40);
		tree.insert(60);
		tree.insert(30);
		tree.insert(70);
		while(true) {
			System.out.print("Enter first letter of show, insert, find, delete, or traverse: ");
			char choice = getChar();
			switch(choice) {
			case 's':
				tree.displayTree();
				break;
			case 'i':
				System.out.print("Enter a value to insert: ");
				value = getInt();
				tree.insert(value);
				break;
			case 'f':
				System.out.print("Enter a value to find: ");
				value = getInt();
				int found = tree.find(value);
				if(found != -1) {
					System.out.print("Found: " + value);
				}else {
					System.out.println("not found " + value);
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
