package algorithm.leetCode;

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
        backtracking(list, array, 0, nums);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> temp, int t, int[] nums) {
        if (t > nums.length) return;
        else if (t == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if ((!temp.contains(nums[i]))) {
                    temp.add(nums[i]);
                    backtracking(list, temp, t + 1, nums);
                    // 去掉最后面的元素
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

}
