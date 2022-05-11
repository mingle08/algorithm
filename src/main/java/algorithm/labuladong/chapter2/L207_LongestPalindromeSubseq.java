package algorithm.labuladong.chapter2;

public class L207_LongestPalindromeSubseq {

    static int findPalindrome(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        // dp数组全部初始化为0
        int[][] dp = new int[n][n];
        // base case
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 反向遍历保证正确的状态转移
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 状态转移方程
                if (chs[i] == chs[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        // 整个s的最长回文子序列长度
        return dp[0][n - 1];
    }

    /**
     * 降维：二维数组改为一维数组
     * @param s
     * @return
     */
    static int longestPalindrome(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        // base case：一维dp数组全部初始化为1
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            int pre = 0;
            for (int j = i + 1; j < n; j++) {
                int temp = dp[j];
                // 状态转移方程
                if (chs[i] == chs[j])
                    dp[j] = pre + 2;
                else
                    dp[j] = Math.max(dp[j], dp[j - 1]);
                pre = temp;

            }
        }
        return dp[n - 1];
    }
}
