package algorithm.labuladong.chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 单调队列
 * 
 * 剑指offer 59题
 */
public class L308_MonotonicQueue {

    // 内部类
    class MonotonicQueue {

        LinkedList<Integer> q = new LinkedList<>();
        // 添加
        public void push(int n) {
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        // 取最大值
        public int max() {
            return q.getFirst();
        }

        // 弹出
        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }
    }

    int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 初始化窗口，先处理前面k个数
                window.push(nums[i]);
            } else {
                // 
                window.push(nums[i]);
                //
                res.add(window.max());
                // 
                window.pop(nums[i - k + 1]);
            }
        }
        // 
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        L308_MonotonicQueue solution = new L308_MonotonicQueue();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] arr = solution.maxSlidingWindow(nums, k);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
