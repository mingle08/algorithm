package algorithm.girlTeacher;

public class StackApp {

	public static void main(String[] args) {
		StackX stackX = new StackX(10);
		stackX.push(20);
		stackX.push(40);
		stackX.push(80);
		while(!stackX.isEmpty()) {
			long val = stackX.pop();
			System.out.print(val + " ");
		}

		System.out.println();
		System.out.println("stackX is Empty ? " + stackX.isEmpty());
	}

}
