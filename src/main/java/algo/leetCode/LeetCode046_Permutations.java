package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode046_Permutations {

    public static void main(String[] args) {
        LeetCode046_Permutations solution = new LeetCode046_Permutations();
        int[] arr = {2, 3, 5};
        List<List<Integer>> result = solution.permute(arr);
        System.out.println(result.size());

        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> array = new ArrayList<>();

        int n = nums.length;
        backtracking(list, array, 0, n, nums);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> array, int t, int n, int[] nums) {
        if (t > n) return;
        else if (t == n) {
            list.add(new ArrayList<>(array));
        } else {
            for (int i = 0; i < n; i++) {
                if ((!array.contains(nums[i]))) {
                    array.add(nums[i]);
                    backtracking(list, array, t + 1, n, nums);
                    // 去掉最后面的元素
                    array.remove(array.size() - 1);
                }
            }
        }
    }

}
