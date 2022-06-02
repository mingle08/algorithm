package algorithm.codingInterviewChinese2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列的最大值
 * 请定义一个队列并实现函数max得到队列里的最大值，要求函数max, push_back和pop_front的时间复杂度都是O(1)
 */
public class Q059_02_QueueWithMax {
    private Queue<Integer> q;
    private Deque<Integer> deque;

    public Q059_02_QueueWithMax() {
        q = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public Integer max_value() {
        if (deque.isEmpty()) return -1;
        // max只是peek，并不删除
        return deque.peek();
    }

    public void push_back(int num) {
        // 主队列正常加入
        q.add(num);
        // 辅助队列，从尾部清除比待加入元素小的元素
        while (!deque.isEmpty() && deque.getLast() < num) {
            deque.pollLast();
        }
        deque.add(num);
    }

    public Integer pop_front() {
        if (q.isEmpty()) return -1;
        Integer first = q.poll();
        if (first == deque.peekFirst()) {
            deque.pop();
        }
        return first;
    }
}
