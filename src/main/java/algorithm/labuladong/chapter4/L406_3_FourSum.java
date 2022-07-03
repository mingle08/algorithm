package algorithm.labuladong.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L406_3_FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        // 第一个数
        for (int a = 0; a < len; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            if (nums[a] + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) break;
            if (nums[a] + nums[len - 3] + nums[len - 2] + nums[len - 1] < target) continue;
            // 第二个数
            for (int b = a + 1; b < len - 2; b++) {
                if (b > 0 && nums[b] == nums[b - 1]) continue;
                if (nums[a] + nums[b] + nums[b + 1] + nums[b + 2] > target) break;
                if (nums[a] + nums[b] + nums[len - 2] + nums[len - 1] < target) continue;
                // 第三个，第四个
                int left = b + 1, right = len - 1;
                while (left < right) {
                    int sum = nums[a] + nums[b] + nums[left] + nums[right];
                    int l = nums[left], r = nums[right];
                    if (sum == target) {
                        temp.add(nums[a]);
                        temp.add(nums[b]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        res.add(new ArrayList<>(temp));
                        temp.clear();
                        while (left < right && nums[left] == l) left++;
                        while (left < right && nums[right] == r) right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L406_3_FourSum solution = new L406_3_FourSum();
        int[] arr = {1,0,-1,0,-2,2};

        List<List<Integer>> res = solution.fourSum(arr, 0);
        for (List<Integer> ans : res) {
            for (Integer i : ans) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
