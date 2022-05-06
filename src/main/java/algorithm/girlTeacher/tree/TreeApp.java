package algorithm.girlTeacher.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeApp {

	public static void main(String[] args) throws IOException {
		int value;
		Tree tree = new Tree();
		tree.insert(50, 1.5);
		tree.insert(25, 1.2);
		tree.insert(75, 1.7);
		tree.insert(12, 1.5);
		tree.insert(37, 1.2);
		tree.insert(43, 1.7);
		tree.insert(30, 1.5);
		tree.insert(33, 1.2);
		tree.insert(87, 1.7);
		tree.insert(93, 1.5);
		tree.insert(97, 1.5);

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
				tree.insert(value, value + 0.9);
				break;
			case 'f':
				System.out.print("Enter a value to find: ");
				value = getInt();
				Node node = tree.find(value);
				if(node != null) {
					System.out.print("Found: ");
					node.displayNode();
					System.out.println();
				}else {
					System.out.println("not found " + value);
				}
				break;
			case 'd':  // 删除
				System.out.println("Enter a value to delete: ");
				value = getInt();
				boolean isDel = tree.delete(value);
				if(isDel) {
					System.out.println("Delete " + value);
				}else {
					System.out.println("Could not delete " + value);
				}
				break;
			case 't':   // 遍历
				System.out.println("Enter type 1, 2, or 3 to traverse.");
				value = getInt();
				tree.traverse(value);
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
