package algorithm.codingInterviewChinese2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Q059_02_QueueWithMax {
    private Queue<Integer> queue;
    private Deque<Integer> deque;

    public Q059_02_QueueWithMax() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public Integer max_value() {
        if (deque.isEmpty()) return -1;
        return deque.peek();
    }

    public void push_back(int num) {
        // 主队列正常加入
        queue.add(num);
        // 辅助队列，从尾部清除比待加入元素小的元素
        while (!deque.isEmpty() && deque.getLast() < num) {
            deque.pollLast();
        }
        deque.add(num);
    }

    public Integer pop_front() {
        if (queue.isEmpty()) return -1;
        Integer first = queue.poll();
        if (first == deque.peekFirst()) {
            deque.pop();
        }
        return first;
    }
}
