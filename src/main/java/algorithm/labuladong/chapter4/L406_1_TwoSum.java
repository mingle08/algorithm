package algorithm.labuladong.chapter4;

import java.util.ArrayList;
import java.util.List;

/**
 * 2Sum问题
 */
public class L406_1_TwoSum {

    /**
     * 假设输入一个数组nums和一个目标和target，请返回nums中能够凑出target的2个元素的值，
     * 比如输入nums = [1, 3, 5, 6], target = 9，那么算法返回2个元素[3, 6]
     */
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{nums[left], nums[right]};
            }
        }
        return new int[]{};
    }

    /**
     * nums中可能有多对元素之和等于target，请返回所有和为target的元素对，其中不能出现重复
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> twoSum2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while (left < right) {
            int l = nums[left], r = nums[right];
            int sum = l + r;
            if (sum > target) {
                right--;
                // 跳过重复元素
                while (left < right && nums[right] == r) right--;
            } else if (sum < target) {
                left++;
                // 跳过重复元素
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
        return res;
    }

    public static void main(String[] args) {
        L406_1_TwoSum solution = new L406_1_TwoSum();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4, 4, 5};
        List<List<Integer>> res = solution.twoSum2(nums, 4);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
