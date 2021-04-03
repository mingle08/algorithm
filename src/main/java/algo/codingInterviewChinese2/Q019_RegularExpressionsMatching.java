package algo.codingInterviewChinese2;

/**
 * 题目：请实现一个函数用来匹配包括'.'和''的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而''表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"abaca"匹配，但是与"aa.a"和"ab*a"均不匹配 *
 */
public class Q019_RegularExpressionsMatching {

    //  动态规划
    public boolean match(char[] str, char[] pattern) {
        int m = str.length, n = pattern.length;
        boolean[][] dp = new boolean[m + 1][n + 1];

        dp[0][0] = true;
        for (int i = 1; i <= n; i++)
            if (pattern[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str[i - 1] == pattern[j - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern[j - 1] == '*') {
                    if (pattern[j - 2] == str[i - 1] || pattern[j - 2] == '.') {
                        dp[i][j] |= dp[i][j - 1]; // a* counts as single a
                        dp[i][j] |= dp[i - 1][j]; // a* counts as multiple a
                        dp[i][j] |= dp[i][j - 2]; // a* counts as empty
                    } else
                        dp[i][j] = dp[i][j - 2];   // a* only counts as empty
                }
            }
        }
        return dp[m][n];
    }

    // 递归
    public boolean match2(char[] str, char[] pattern){
        if (str == null || pattern == null) {
            return false;
        }
        return match2(str, pattern, 0, 0);
    }

    private boolean match2(char[] str, char[] pattern, int strPos, int patternPos) {
        if (strPos == str.length && patternPos == pattern.length) {
            return true;
        } else if (patternPos == pattern.length) {
            return false;
        }
        if (patternPos + 1 < pattern.length && pattern[patternPos + 1] == '*') {
            if (strPos < str.length && (pattern[patternPos] == '.' || pattern[patternPos] == str[strPos])) {
                return match2(str, pattern, strPos, patternPos + 2) // 匹配0个字符
                    || match2(str, pattern, strPos + 1, patternPos + 2) // 匹配1个字符
                    || match2(str, pattern, strPos + 1, patternPos); // 匹配多个字符
            } else {
                return match2(str, pattern, strPos, patternPos + 2); // 匹配0个字符
            }
        }
        if (strPos < str.length && (pattern[patternPos] == '.' || pattern[patternPos] == str[strPos])) {
            return match2(str, pattern, strPos + 1, patternPos + 1);
        }
        return false;
    }
}
