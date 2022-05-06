package algorithm.girlTeacher.interIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InterIterator {

	public static void main(String[] args) throws IOException {
		LinkList list = new LinkList();
		ListIterator iter = list.getIterator();
		long val;
		iter.insertAfter(20);
		iter.insertAfter(40);
		iter.insertAfter(80);
		iter.insertBefore(60);

		// s: 显示链表内容
		// r: reset方法
		// n: nextLink()
		// g: getCurrent()
		// b: insertBefore()
		// a: insertAfter()
		// d: deleteCurrent()

		while(true) {
			System.out.println("Enter first letter of show, reset, next,get, before, after, delete: ");
			System.out.flush();
			char choice = getChar();
			switch(choice) {
			case 's':
				if(!list.isEmpty()) {
					list.displayNode();
				}else {
					System.out.println("list is empty.");
				}
				break;
			case 'r':
				iter.reset();
				break;
			case 'n':
				if(!list.isEmpty() && !iter.atEnd()) {
					iter.nextLink();
				}else {
					System.out.println("Can't go to next link.");
				}
				break;
			case 'g':
				if(!list.isEmpty()) {
					val = iter.getCurrent().dData;
					System.out.println("Returned " + val);
				}else {
					System.out.println("list is empty.");
				}
				break;
			case 'b':
				System.out.println("Enter val to insert: ");
				System.out.flush();
				val = getInt();
				iter.insertBefore(val);
				break;
			case 'a':
				System.out.println("Enter val to insert: ");
				System.out.flush();
				val = getInt();
				iter.insertAfter(val);
				break;
			case 'd':
				if(!list.isEmpty()) {
					val = iter.deleteCurrent();
					System.out.println("Deleted: " + val);
				}else {
					System.out.println("Can not delete.");
				}
				break;
				default:
					System.out.println("The val you entered is invalid.");
			}
		}

	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static char getChar() throws IOException{
		String s = getString();
		return s.charAt(0);
	}

	public static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

}
