package algo.girlTeacher;

public class StackX {

	private long[] stackArray;
	private int maxSize;
	private int top;
	public StackX(int s) {
		maxSize = s;
		stackArray = new long[maxSize];
		top = -1;
	}
	/**
	 * 添加数据
	 * @param j
	 */
	public void push(long j) {
		stackArray[++top] = j;
	}
	
	// 查看并删除
	public long pop() {
		
		return stackArray[top--];
	}
	
	// 查看
	public long peek() {
		return stackArray[top];
	}
	
	// 是否为空
	public boolean isEmpty() {
		return top == -1;
	}
	
	// 是否满了
	public boolean isFull() {
		return top == maxSize;
	}
}
