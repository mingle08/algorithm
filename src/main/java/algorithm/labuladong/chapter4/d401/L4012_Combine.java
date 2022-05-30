package algorithm.labuladong.chapter4.d401;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入2个数字n，k，算法输出[1...n]中的k个数字的所有组合
 * 比如输入n = 4，k = 2，输出如下结果：
 * [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 */
public class L4012_Combine {
    List<List<Integer>> res = new LinkedList<>();

    List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) return res;
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    void backtrack(int n, int k, int start, LinkedList<Integer> track) {
        // 到达叶子节点才更新 res
        if (k == track.size()) {
            res.add(new LinkedList<>(track));
            return;
        }

        // i 从 start开始递增
        for (int i = start; i <= n; i++) {
            // 做选择
            track.add(Integer.valueOf(i));
            // 递归回溯
            backtrack(n, k, i + 1, track);
            // 撤消选择
            track.removeLast();
        }
    }
}
