package algorithm.labuladong.chapter2;

/**
 * 最长公共子序列
 * 输入s = "abcde", t = "aceb"
 * 输出3，因为s和t的最长公共子序列是"ace"，它的长度是3
 *
 * dp[i][j]表示s[0...i]和t[0...j]中最长公共子序列的长度
 */
public class L205_LongestCommSubsequence {
    static int find(String s, String t) {
        int m = s.length(), n = t.length();
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 状态转移逻辑
                if (S[i - 1] == T[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
