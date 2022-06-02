package algorithm.labuladong.chapter4;

import java.util.ArrayList;
import java.util.List;

public class L406_4_NSum {

    /**
     * 每次递归，各参数的变化：
     * n -> n - 1
     * start -> i + 1
     * target -> target - nums[i]
     * 
     * @param nums
     * @param n
     * @param start
     * @param target
     * @return
     */
    static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (n < 2 || sz < n) return res;
        // 2Sum是base case
        if (n == 2) {
            // 双指针
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int l = nums[left], r = nums[right];
                int sum = l + r;
                if (sum > target) {
                    // 跳过重复元素（第一次进入就是true，因为r的初始值就是nums[right]）
                    while (left < right && nums[right] == r) right--;
                } else if (sum < target) {
                    // 跳过重复元素（第一次进入就是true，因为l的初始值就是nums[left]）
                    while (left < right && nums[left] == l) left++;
                } else {
                    temp.add(l);
                    temp.add(r);
                    res.add(new ArrayList<>(temp));
                    // 要清空temp
                    temp.clear();
                    // 跳过所有重复元素
                    while (left < right && nums[left] == l) left++;
                    while (left < right && nums[right] == r) right--;
                }
            }
        } else {
            // n > 2时，递归计算(n-1)Sum的结果
            for (int i = start; i < sz; i++) {
                List<List<Integer>> sub = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> arr : sub) {
                    // (n-1)Sum 加上 nums[i] 就是 nSum
                    arr.add(nums[i]);
                    res.add(new ArrayList<>(arr));
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }
}
