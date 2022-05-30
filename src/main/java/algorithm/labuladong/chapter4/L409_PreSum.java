package algorithm.labuladong.chapter4;

import java.util.HashMap;

/**
 * 前缀和
 * 
 * 输入一个整数数组nums和一个整数k，算出nums中一共有几个和为k的子数组
 * 函数签名如下：
 * int subArraySum(int[] nums, int k);
 */
public class L409_PreSum {
    
    int subArraySum(int[] nums, int k) {
        int n = nums.length;
        // map: 前缀和 -> 该前缀和出现的次数
        HashMap<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);

        int ans = 0, sum0_i = 0;
        for (int i = 0; i < n; i++) {
            sum0_i += nums[i];
            // 这是我们想找的前缀和 nums[0...c]
            int sum0_c = sum0_i - k;
            // 如果前面有这个前缀和，则直接给出答案
            if (preSum.containsKey(sum0_c))
                ans += preSum.get(sum0_c);
            // 把前缀和 nums[0...i] 加入并记录出现次数
            preSum.put(sum0_i, preSum.getOrDefault(sum0_i, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        L409_PreSum solution = new L409_PreSum();
        int[] arr = {1, 1, 1, 2};
        int target = 2;
        int res = solution.subArraySum(arr, target);
        System.out.println(res);
    }
}
