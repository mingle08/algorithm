package algorithm.labuladong.chapter4;

import java.util.*;

/**
 * 使用LinkedList，因为递归出来，加入前面的数时，要从头插入，需使用LinkedList的push方法
 */
public class L406_4_NSum {

    List<List<Integer>> nSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = nSumTarget(nums, 4, 0, 0);
        return res;
    }

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
    List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int sz = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        if (n < 2 || sz < n) return res;
        // 2Sum是base case
        if (n == 2) {
            // 双指针
            int left = start, right = nums.length - 1;
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
                    res.add(new LinkedList<>(temp));
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
                    // 要从前面插入，所以先强转成LinkedList，再使用push方法
                    ((LinkedList)arr).push(nums[i]);
                    res.add(new LinkedList<>(arr));
                }
                while (i < sz - 1 && nums[i] == nums[i + 1]) i++;
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        int n = nums.length;

        // 穷举第一个数
        for (int i = 0; i < n; i++) {
            List<List<Integer>> ans = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> list : ans) {
                // nums[i]是最前面，即最小的，所以要从头部压入
                ((LinkedList)list).push(nums[i]);
                res.add(list);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) i++;
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int left = start, right = nums.length - 1;
        List<Integer> temp = new LinkedList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int l = nums[left], r = nums[right];
            if (sum < target) {
                while (left < right && nums[left] == l) left++;
            } else if (sum > target) {
                while (left < right && nums[right] == r) right--;
            } else {
                temp.add(nums[left]);
                temp.add(nums[right]);
                res.add(new LinkedList<>(temp));
                temp.clear();
                while (left < right && nums[left] == l) left++;
                while (left < right && nums[right] == r) right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L406_4_NSum solution = new L406_4_NSum();
        int[] arr = {1,0,-1,0,-2,2};
        List<List<Integer>> res = solution.nSum(arr, 0);
        for (List<Integer> list : res) {
//            Collections.sort(list);
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
