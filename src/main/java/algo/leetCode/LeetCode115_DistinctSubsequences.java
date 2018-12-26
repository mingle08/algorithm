package algo.leetCode;

/**
 * 一、动态规划图
 *
 *          Ø r a b b b i t    字符串S
 *        Ø 1 1 1 1 1 1 1 1
 *   字   r 0 1 1 1 1 1 1 1
 *   符   a 0 0 1 1 1 1 1 1
 *   串   b 0 0 0 1 2 3 3 3
 *   T    b 0 0 0 0 1 3 3 3
 *        i 0 0 0 0 0 0 3 3
 *        t 0 0 0 0 0 0 0 3
 *
 *
 * 1. 如果原字符串和子序列都为空时，返回1，因为空串也是空串的一个子序列。
 * 2. 如果原字符串不为空，而子序列为空，也返回1，因为空串也是任意字符串的一个子序列。
 * 3. 当原字符串为空，子序列不为空时，返回0，因为非空字符串不能当空字符串的子序列。
 *
 * 二、思路：正计算的这一格，对应在T和S的字符是否相等，
 * 1. 如果不相等，此格的值就等于前面的值
 * 2. 如果相等，此格的值就等于前面一格的值加上左上角对角线那格的值
 */
public class LeetCode115_DistinctSubsequences {

    public int distinctSubSeq(String S, String T){
        int lenS = S.length();
        int lenT = T.length();
        int[][] dp = new int[lenT + 1][lenS + 1];

        for (int t = 1; t <= lenT; t++)
            dp[t][0] = 0;

        for (int s = 0; s <= lenS; s++)
            dp[0][s] = 1;

        for (int t = 1; t <= lenT; t++) {
            for (int s = 1; s <= lenS; s++) {
                dp[t][s] = dp[t][s - 1];  // 同一行，前面的值

                /**
                 * 注意：
                 * T.charAt(t-1) 等于 dp的t行
                 * S.charAt(s-1) 等于dp的s列
                 * 因为dp行比S多一格，列比T多一格
                 * 也就是看dp[t][s]对应在T和S上的字符是否相等
                 */
                if (T.charAt(t-1) == S.charAt(s-1))
                    dp[t][s] += dp[t - 1][s - 1];

            }
        }

        return dp[lenT][lenS];
    }

    public static void main(String[] args){
        LeetCode115_DistinctSubsequences solution = new LeetCode115_DistinctSubsequences();

        String S = "rabbbit";
        String T = "rabbit";
        int count = solution.distinctSubSeq(S, T);

        System.out.println(count);
    }
}
