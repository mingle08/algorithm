package algorithm.girlTeacher.stackTriangle;

public class StackY {

	private int maxSize;
	private int[] stackArr;
	private int top;

	public StackY(int s) {
		this.maxSize = s;
		stackArr = new int[maxSize];
		top = -1;
	}

	public void push(int p) {
		stackArr[++top] = p;
	}

	public int pop() {
		return stackArr[top--];
	}

	public int peek() {
		return stackArr[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}
}
