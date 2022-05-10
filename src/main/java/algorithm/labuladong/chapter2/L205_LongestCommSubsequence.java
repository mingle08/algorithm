package algorithm.labuladong.chapter2;

/**
 * 最长公共子序列
 * 输入str1 = "abcde", str2 = "aceb"
 * 输出3，因为str1和str2的最长公共子序列是"ace"，它的长度是3
 *
 * dp[i][j]表示str1[0...i]和str2[0...j]中最长公共子序列的长度
 */
public class L205_LongestCommSubsequence {
    static int find(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 状态转移逻辑
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
