package algorithm.labuladong.chapter4.d401;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个不包含重复数字的数组nums，返回这些数字的全部排列
 */
public class L4013_Permute {
    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 到达叶子节点才更新 res
        if (nums.length == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        // i 从 start开始递增
        for (int i = 0; i <= nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(Integer.valueOf(i));
            // 进入下一层决策树
            backtrack(nums, track);
            // 撤消选择
            track.removeLast();
        }
    }
}
