package algorithm.labuladong.chapter2;

/**
 *  给定物品的重量 wt = [2, 1, 3]
 *  对应的价值 val =[4, 2, 3]
 *  背包能装的最大重量为 W = 4
 * 
 * dp[i][w]从下标为[0-i]的物品里任意取，放进容量为w的背包，价值总和最大是多少
 * 由dp[i - 1][w]推出，即背包容量为j，里面不放物品i的最大价值，此时dp[i][w]就是dp[i - 1][w]
 * 由dp[i - 1][w - wt[i]]推出，dp[i - 1][w - wt[i - 1]] 为背包容量为j - wt[i - 1]的时候不放物品i的最大价值，
 * 那么dp[i - 1][w - weight[i - 1]] + val[i - 1] （物品i的价值），就是背包放物品i得到的最大价值
 */
public class L215_Knapsack {

    public static int dp(int W, int[] wt, int[] val) {
        int N = val.length;
        int[][] dp = new int[N + 1][W + 1];
        // 先遍历物品，再遍历背包
        for (int i = 1; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                /* 
                wt[i - 1]代表前i - 1个物品的重量, w是背包的容量
                w < wt[i - 1] 表示背包装不下第i个物品
                */
                if (w < wt[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // dp[i - 1][w - wt[i - 1]] 表示背包容量为w - wt[i - 1]的时候不放物品i的最大价值
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

    public static void main(String[] args) {
        int W = 4;
        final int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        int max = dp(W, wt, val);
        System.out.println(max);
    }

}