package algorithm.codingInterviewChinese2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用两个队列实现栈
 * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class Q009_2_StackWithTwoQueues {
    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    /**
     始终用空的队列A去加入新值，再把另一队列B的元素转移过来，使该队列B为空，
     下次加入元素，又使用那个空队列B，使新加入的元素在最前面，就可以后进先出
     */
    public void push(int x) {
        if (q1.isEmpty() && !q2.isEmpty()) {  // 队列1为空，队列2不为空
            q1.add(x);
            // 清空队列2，转移到队列1
            while (!q2.isEmpty()){
                int data = q2.remove();
                q1.add(data);
            }

        } else if (!q1.isEmpty() && q2.isEmpty()) {  // 队列1不为空，队列2为空
            q2.add(x);
            // 清空队列1，转移到队列2
            while (!q1.isEmpty()){
                int data = q1.remove();
                q2.add(data);
            }

        } else if (q1.isEmpty() && q2.isEmpty()) {  // 队列1为空，队列2为空
            q1.add(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     * 非空队列的元素排列顺序是倒序，加入顺序是1，2，3，队列中就是3，2，1
     */
    public int pop() {
        if (q1.isEmpty() && !q2.isEmpty())
            return q2.remove();
        return q1.remove();

    }

    /**
     * Get the top element.
     */
    public int top() {
        if (q1.isEmpty() && !q2.isEmpty())
            return q2.peek();
        return q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        if (q1.isEmpty() && q2.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Q009_2_StackWithTwoQueues stackWithTwoQueues = new Q009_2_StackWithTwoQueues();
        stackWithTwoQueues.push(1);
        stackWithTwoQueues.push(2);
        stackWithTwoQueues.push(3);

        int a = stackWithTwoQueues.top();
        System.out.println(a);
        int b = stackWithTwoQueues.pop();
        System.out.println(b);
    }
}
