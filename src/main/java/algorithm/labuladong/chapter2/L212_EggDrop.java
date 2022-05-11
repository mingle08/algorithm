package algorithm.labuladong.chapter2;

public class L212_EggDrop {
    private int[][] memo;

    public int eggDrop(int k, int n) {
        memo = new int[k + 1][n + 1];
        for (int i = 0; i < memo.length; ++i) {
            for (int j = 0; j < memo[0].length; ++j) {
                /**
                 * base case
                 * 当鸡蛋数i为1时，只能线性扫描所有楼层
                 * 当楼层数j为0时，不需要扔鸡蛋
                 */
                if (i == 1) {
                    memo[i][j] = j;
                }
                if (j == 0) {
                    memo[i][j] = 0;
                }
                if (i != 1 && j != 0) {
                    memo[i][j] = -1;
                }
            }
        }
        return dp(k, n);
    }

    /**
     * dp(k, n)表示当楼层数为n时，至少要扔k次鸡蛋
     * @param k
     * @param n
     * @return
     */
    private int dp(int k, int n) {
        int res = Integer.MAX_VALUE;
        if (memo[k][n] != -1) {
            return memo[k][n];
        }
        for (int i = 1; i <= n; ++i) {
            res = Math.min(res, Math.max(dp(k - 1, i - 1),    // 碎
                    dp(k, n - i))           // 没碎
                    + 1                       // 在第i楼扔了一次
            );
        }
        memo[k][n] = res;
        return res;
    }
}

