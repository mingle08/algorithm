package algorithm.girlTeacher.stackTriangle;

public class StackX {

	private int maxSize;
	private Param[] stackArr;
	private int top;
	public StackX(int s) {
		this.maxSize = s;
		stackArr = new Param[maxSize];
		top = -1;
	}

	public void push(Param p) {
		stackArr[++top] = p;
	}

	public Param pop() {
		return stackArr[top--];
	}

	public Param peek() {
		return stackArr[top];
	}
}
