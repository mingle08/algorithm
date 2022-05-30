package algorithm.codingInterviewChinese2;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？
 * 首先要排序
 * 1. 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 2. 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Q041_StreamMedian {
    // 全局计数器
    public Integer count = 0;

    // 大顶堆要自定义比较器，重写compare方法
    public PriorityQueue<Integer> heap1 = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    // PriorityQueue默认是自然排序，结果是小顶堆
    public PriorityQueue<Integer> heap2 = new PriorityQueue<>();
    

    // heap1存放的是左边的数，比heap2存放的数要小
    public void insert(Integer num) {
        // 总个数为偶数时插入大顶堆heap1
        if ((count & 1) == 0) { // 第偶数个数
            heap1.offer(num);
            // heap1 弹出堆顶元素，加到heap2
            Integer temp = heap1.poll();
            heap2.offer(temp);
        } else {// 总个数为奇数时插入小顶堆heap2
            heap2.offer(num);
            // heap2 弹出堆顶元素，加到heap1
            Integer temp = heap2.poll();
            heap1.offer(temp);
        }
        // 计数
        count++;
    }
    public double getMedian() {
        if ((count & 1) == 0) { // 总数量为偶数
            return (heap1.poll() + heap2.poll()) / 2.0;
        } else { // 总数量为奇数
            return heap2.poll();
        }
    }

    public static void main(String[] args){
        Q041_StreamMedian solution = new Q041_StreamMedian();
        Integer[] arr = {7, 3, 21, 2, 6, 13, 8, 9, 17};
        for (Integer integer : arr) {
            solution.insert(integer);
        }
        double median = solution.getMedian();
        System.out.println(median);
    }

}
