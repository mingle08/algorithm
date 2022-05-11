package algorithm.labuladong.chapter2;

public class L215_Knapsack {

    public static int dp(int W, int N, int[] wt, int[] val) {
        int[][] dp = new int[W + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                if (w < wt[i - 1]) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    //
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[N][W];
    }

}


