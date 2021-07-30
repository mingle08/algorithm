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
        if (rear == SIZE - 1) {
            // 从头开始
            rear = -1;
        }
        queueArray[++rear] = i;
    }

    public int remove() {
        // 从队列头部删除
        int temp = queueArray[front++];
        if (front == SIZE) {
            front = 0;
        }
        return temp;
    }

    public boolean isEmpty() {
        return (rear + 1 == front) || (front + SIZE - 1 == rear);
    }
}
