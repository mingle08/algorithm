package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个数组，数组中的元素各不相同，找到该集合的所有子集（包括空集和本身）
 * 举例说明：
 * int []nums={1,2,3}
 * 返回结果如下：
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */
public class LeetCode078_Subsets {

    static List<List<Integer>> resList = new ArrayList<>();

    public static void main(String[] args) {
        LeetCode078_Subsets solution = new LeetCode078_Subsets();
        int[] nums = {1, 2, 3};

        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        solution.backtracking(list, nums, 0);
        for (List<Integer> res : resList) {
            for (Integer in : res) {
                System.out.print(in + " ");
            }
            System.out.println();
        }

    }

    private void backtracking(List<Integer> list, int[] nums, int start) {
        resList.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

}
