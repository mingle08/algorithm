package algo.girlTeacher.graph.bfs;

public class Queue {

	private final int SIZE = 20;
	private int[] queueArray;
	private int front;
	private int rear;
	
	public Queue() {
		queueArray = new int[SIZE];
		this.front = 0;
		this.rear = -1;
	}
	
	public void insert(int i) {
		if(rear == SIZE-1) {
			rear = -1;  // 从头开始
		}
		queueArray[++rear] = i;
	}
	
	public int remove() {
		int temp = queueArray[front++];  // 从队列头部删除
		if(front == SIZE) {
			front = 0;
		}
		return temp;
	}
	
	public boolean isEmpty() {
		return (rear+1 == front) || (front+SIZE-1 == rear);
	}
}
