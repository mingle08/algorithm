package algorithm.leetCode;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 

提示：

1 <= n <= 45

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/climbing-stairs
 * 注意保留已经计算过的f(n)，要不然效率会很低
 */
public class LeetCode070_ClimbingStairs {

    /**
     * int[] dp = new int[n + 1];
     * dp[i] = dp[i - 1] + dp[i - 2];
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        /* int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n]; */

        int res = 0, n1 = 1, n2 = 2;
        for (int i = 3; i <= n; i++) {
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode070_ClimbingStairs solution = new LeetCode070_ClimbingStairs();
        int steps = solution.climbStairs(5);
        System.out.println(steps);

    }
}
