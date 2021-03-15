package algo.girlTeacher.anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * anagram  n.相同字母异序词，易位构词，变位词
 * @author huxm
 *
 */
public class AnagramApp {

	static int size;
	static int count;
	static char[] arrChar = new char[100];
	
	
	/**
	 * 变位颠倒
	 * @param newSize
	 */
	public static void doAnagram(int newSize) {
		if(newSize == 1) {
			return;
		}
		for (int i = 0; i < newSize; i++) {
			doAnagram(newSize - 1);
			if(newSize == 2) {
				displayWord();
			}
			rotate(newSize);
		}
	}

	/**
	 * 旋转
	 * @param newSize
	 */
	public static void rotate(int newSize) {
		int j;
		int position = size - newSize;
		char temp = arrChar[position];
		for(j = position + 1; j < size; j++) {
			arrChar[j - 1] = arrChar[j];
		}
		arrChar[j - 1] = temp;
		
	}
	
	public static void displayWord() {
		if(count < 99) {
			System.out.print(" "); // not println
		}
		if(count < 9) {
			System.out.print(" ");  // not println
		}
		System.out.print((++count) + " ");  // not println
		for (int i = 0; i < size; i++) {
			System.out.print(arrChar[i]);   // not println
		}
		System.out.print("  ");  // not println
		System.out.flush();
		if(count % 6 == 0) {
			System.out.println();  // 换行
		}
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static void main(String[] args) throws IOException {

		System.out.println("Enter a word: ");
		String input = getString();
		size = input.length();
		count = 0;
		for (int i = 0; i < size; i++) {
			arrChar[i] = input.charAt(i);
		}
		doAnagram(size);
	}

}
