package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target，找出 candidates 中可以使数字和为目标数target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode039_CombinationSum {
    public static void main(String[] args) {
        LeetCode039_CombinationSum solution = new LeetCode039_CombinationSum();
        int[] nums = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(nums, target);
        System.out.println(res.size());
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target,0, temp, res);
        return res;
    }

    public void findSum(int[] candidates, int target, int level, List<Integer> temp, List<List<Integer>> res) {
        if (0 == target) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (0 > target) {
            return;
        }
        for (int i = level; i < candidates.length; i++) {
            temp.add(candidates[i]);
            // 注意，哪里体现了可重复使用数字，是level为i
            findSum(candidates, target -  candidates[i], i, temp, res);
            temp.remove(temp.size() - 1);
        }

    }

}
