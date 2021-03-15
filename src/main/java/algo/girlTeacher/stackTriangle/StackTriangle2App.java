package algo.girlTeacher.stackTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackTriangle2App {
	static int num;
	static int sum;
	static StackY stackY;

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
		num = getInt();
		
		stackTriangle();
		System.out.println("Triangle=" + sum);

	}
	
	public static void stackTriangle() {
		stackY = new StackY(10000);
		sum = 0;
		while(num > 0) {
			stackY.push(num);
			num--;
		}
		while(!stackY.isEmpty()) {
			int newN = stackY.pop();
			sum = sum + newN;
		}
	}
	
	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	
	public static int getInt() throws IOException {
		String str = getString();
		int i = Integer.parseInt(str);
		return i;
	}

}
