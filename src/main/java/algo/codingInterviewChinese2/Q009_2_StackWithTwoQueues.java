package algo.codingInterviewChinese2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用两个队列实现栈
 * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class Q009_2_StackWithTwoQueues {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int x) {
        if (queue1.isEmpty() && !queue2.isEmpty()) {  // 队列1为空，队列2不为空
            queue1.add(x);
            while (!queue2.isEmpty()){
                int data = queue2.remove();
                queue1.add(data);
            }

        } else if (!queue1.isEmpty() && queue2.isEmpty()) {  // 队列1不为空，队列2为空
            queue2.add(x);
            while (!queue1.isEmpty()){
                int data = queue1.remove();
                queue2.add(data);
            }

        } else if (queue1.isEmpty() && queue2.isEmpty()) {  // 队列1为空，队列2为空
            queue1.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue1.isEmpty() && !queue2.isEmpty())
            return queue2.remove();
        return queue1.remove();

    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue1.isEmpty() && !queue2.isEmpty())
            return queue2.peek();
        return queue1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        if (queue1.isEmpty() && queue2.isEmpty())
            return true;
        return false;
    }
}
