package algorithm.codingInterviewChinese2;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 题目：给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Q059_01_MaxInSlidingWindow {
    //把可能会成为最大值的下标存储下来  注意是下标，不是最大值
    public static int[] maxInWindows(int[] num, final int size) {
        if (num == null || num.length == 0 || num.length < size)
            return new int[0];
        int[] res = new int[num.length - size + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        // 遍历0~size-1范围内
        for (int i = 0; i < size; i++) {
            // 若队尾下标对应的数字小于待存入的数据，那么它不可能是最大值，将其删除
            while (!deque.isEmpty() && num[i] >= num[deque.getLast()])
                deque.removeLast();
            // 存入较大值的下标
            deque.addLast(i);
        }
        // 遍历size-1至length范围
        for (int i = size; i < num.length; i++) {
            res[i - size] = num[deque.getFirst()];
            // 若队尾下标对应的数字小于待存入的数据，那么它不可能是最大值，将其删除
            while (!deque.isEmpty() && num[deque.getLast()] <= num[i]) {
                deque.removeLast();
            }
            // 如果滑动窗口已经不包含队首下标对应的值，删除队首元素
            if (!deque.isEmpty() && (i - deque.getFirst()) >= size) {
                deque.removeFirst();
            }

            deque.addLast(i);
        }
        // 保存最后一个最大值
        res[num.length - size] = num[deque.getFirst()];
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        int[] res = maxInWindows(num, 3);
        for (int re : res) {
            System.out.print(re);
            System.out.print("\t");
        }
    }
}
