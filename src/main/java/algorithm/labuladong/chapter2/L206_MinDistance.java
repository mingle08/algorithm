package algorithm.labuladong.chapter2;

/**
 * 可以对一个字符串进行三种操作：插入一个字符、删除一个字符、替换一个字符
 * 现在给你2个字符串s和t，请计算将s转换成t最少需要多少次操作
 * 比如，输入s = "intention", t = "execution"，那么算法应该返回5，因为最少需要5步可以将s变成t
 * 第一步：删除't', intention -> inention
 * 第二步：将'i'替换为'e', inention -> enention
 * 第三步：将'n'替换为'x', enention -> exention
 * 第四步：将'n'替换为'c', exention -> exection
 * 第五步：插入'u', exection -> execution
 *
 *
 *    空 a p p l e
 * 空 0  1 2 3 4 5
 * o  1
 * p  2
 * p  3
 * o  4
 *
 * 在excel中演示比较清晰
 * 1，看空 0 1 2 3 4 5这行，其中0，1，2，3，4，5是算出来的，下面看怎么算的：
 * oppo这列的空，要变成apple需要几步
 * 空要变成apple前面的空，不用操作，所以是0
 * 空要变成a，插入a，是1步
 * 空要变成ap，插入a，插入p，是2步
 * 空要变成app，插入a，插入p，插入p，是3步
 * 空要变成appl，是4步
 * 空要变成apple，是5步
 * 2，同理，换个方向看，看空 0 1 2 3 4这列，0，1，2，3，4是算出来的，下面看是怎么算的：
 * apple前的空，竖向看，要变成oppo需要几步：
 * 空要变成o，插入o，是1步
 * 空要变成op，插入o，插入p，是2步
 * 空要变成opp，插入o,p,p，是3步
 * 空要变成oppo，是4步
 *
 * 以上就是base case的值的初始化
 * 3，再分析
 */
public class L206_MinDistance {
    static int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = i;
        }
        // base case
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                /*
                注意循环起始条件是1，最大值限定是 < m + 1, < n + 1
                需要用到i为0，j为0的值，所以是i-1，j-1
                i - 1，j - 1也保证了S，T下标不会越界
                 */
                if (S[i - 1] == T[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1] + 1,  // 插入
                                dp[i - 1][j] + 1),              // 删除
                                dp[i - 1][j - 1] + 1            // 替换
                );
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "intention", t = "execution";
        int res = minDistance(s, t);
        System.out.println(res);
    }
}
