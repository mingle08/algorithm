package algorithm.labuladong.chapter2;

/**
 * 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 现在要求你戳破所有的气球。
 * 戳破第 i个气球，你可 以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 */
public class L214_MaxCoins {

    int maxCoins(int[] nums) {
        int n = nums.length;
        // 添加两侧的虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i-1];
        }
        // base case已经都被初始化为0
        int[][] dp = new int[n + 2][n + 2];
        // 开始状态转移
        // i 应该从下到上
        for (int i = n; i >= 0; i--) {
            // j 应该从左到右
            for (int j = i + 1; j < n + 2; j++) {
                // 最后戳破的气球是哪个？
                for (int k = i + 1; k < j; k++) {
                    // 择优做选择
                    dp[i][j] = Math.max(dp[i][j],
                            dp[i][k] + points[i] * points[k] * points[j] + dp[k][j]);
                }
            }

        }
        return dp[0][n + 1];
    }
}
