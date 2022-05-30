package algorithm.labuladong.chapter4;

import java.util.*;

public class L405_2_TwoSum {
    /*
    Map<Integer, Integer> freq = new HashMap<>();

    public void add(int number) {
        // 记录number出现的次数
        freq.put(number, freq.getOrDefault(number, 0) + 1);
    }

    // 寻找当前数据结构中是否还在2个数的和为sum
    public boolean find(int sum) {
        for (Integer key : freq.keySet()) {
            int other = sum - key;
            // 情况1
            if (other == key && freq.get(key) > 1) {
                return true;
            }
            // 情况2
            if (other != key && freq.containsKey(other)) {
                return true;
            }
        }
        return false;
    }

     */

    /**
     * 优化之后，每次find只要花费O(1)的时间在集合中判断是否存在，但是代价也很明显，最坏情况下每次add后sum的大小都会翻一倍，
     * 所以空间复杂度是O(2^N)
     * 所以，除非数据规模非常小，否则这个优化还是不要做了，毕竟指数级别的复杂度是一定要想办法避免的
     */
    Set<Integer> sum = new HashSet<>();
    List<Integer> nums = new ArrayList<>();

    public void add(int number) {
        // 记录所有可能组成的和
        for (int n : nums) {
            sum.add(n + number);
        }
        nums.add(number);
    }

    public boolean find(int target) {
        return sum.contains(target);
    }
}
