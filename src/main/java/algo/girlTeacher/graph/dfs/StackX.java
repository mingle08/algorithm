package algo.girlTeacher.graph.dfs;

public class StackX {

    private int[] stackArray;
    private int maxSize = 20;
    private int top;

    public StackX() {
        stackArray = new int[maxSize];
        top = -1;
    }

    /**
     * 添加数据
     *
     * @param j
     */
    public void push(int j) {
        stackArray[++top] = j;
    }

    /**
     * 查看并删除
     */
    public int pop() {

        return stackArray[top--];
    }

    /**
     * 查看
     */
    public int peek() {
        return stackArray[top];
    }

    /**
     * 是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 是否满了
     */
    public boolean isFull() {
        return top == maxSize;
    }
}
