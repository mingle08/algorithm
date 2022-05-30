package algorithm.labuladong.chapter4;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组nums和一个整数target，可以保证数组中存在两个数的和为target，请返回这2个数的索引
 *
 * 1 数组是无序的，使用HashMap
 * 2 数组是有序的：二分查找
 */
public class L405_1_TwoSum {

    // HashMap
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                index[0] = map.get(target - nums[i]);
                index[1] = i;
                break;
            }

            map.put(nums[i], i);

        }

        return index;
    }

    // 二分查找
    static int[] twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[]{-1, -1};
    }
}
