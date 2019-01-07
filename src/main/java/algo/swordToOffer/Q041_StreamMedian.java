package algo.swordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 1. 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 2. 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Q041_StreamMedian {
    public int count = 0;
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // PriorityQueue默认是自然排序，结果是最小堆，所以最大堆要自定义比较器，重写compare方法
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public void insert(int num) {
        if ((count & 1) == 0) { // 第偶数个数
            maxHeap.offer(num);
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        } else {// 第奇数个数
            minHeap.offer(num);
            int temp = minHeap.poll();
            maxHeap.offer(temp);
        }
        count++;
    }
    public double getMedian() {
        if ((count & 1) == 0) { // 总数量为偶数
            return (maxHeap.poll() + minHeap.poll()) / 2.0;
        } else { // 总数量为奇数
            return minHeap.poll();
        }
    }

    public static void main(String[] args){
        Q041_StreamMedian solution = new Q041_StreamMedian();
        int[] arr = {7, 3, 21, 2, 6, 13, 8, 9, 17};
        for (int i = 0; i < arr.length; i++) {
            solution.insert(arr[i]);

        }
        double median = solution.getMedian();
        System.out.println(median);
    }

}
