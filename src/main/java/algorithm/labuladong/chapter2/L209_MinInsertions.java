package algorithm.labuladong.chapter2;

/**
 * 以最小插入次数构造回文串
 */
public class L209_MinInsertions {

    static int minInsertions(String s) {
        int n = s.length();
        char[] S = s.toCharArray();
        int[][] dp = new int[n][n];
        // base case: i == j时dp[i][j] == 0，单个字符本身就是回文串
        // dp数组已经全部初始化为0，base case已初始化

        // 从下向上遍历
        for (int i = n - 2; i >= 0; i--) {
            // 从左向右遍历
            for (int j = i + 1; j < n; j++) {
                // 根据s[i]和s[j]进行状态转移
                if (S[i] == S[j]) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }

        }
        // 根据dp数组的定义，题目要求的答案是dp[0][n - 1]
        return dp[0][n - 1];
    }
}
