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
 * <p>
 * <p>
 * 空 a p p l e
 * 空 0  1 2 3 4 5
 * o  1
 * p  2
 * p  3
 * o  4
 * <p>
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
 * <p>
 * 以上就是base case的值的初始化
 * 3，再分析
 * <p>
 * dp[i][j]代表什么？
 * 字符串A(i)转换成字符串B(j)的所有操作数
 * 对字符串A进行增、删、替换操作
 *
 * 状态表示：dp[i][j],表示字符串A(i)转换成字符串B(j)的所有操作数

 * 核心：最后一次操作为增、删、或改后A数组和B数组相同
 *
 * 状态划分：dp[i][j]由之前的状态增加，删除或修改得到
 *
 * 1.由增加得到dp[i][j]，即字符串A的前i个已与字符串B的前j-1个一一对应：dp[i][j] = dp[i][j-1] + 1

 * 2.由删除得到dp[i][j]，即字符串A的前i-1个已与字符串B一一对应：dp[i][j] = dp[i-1][j] + 1
 *
 * 3.由修改得到dp[i][j],即字符串A的前i-1个已与字符串的前j-1个一一对应：
 *
 * (1)若字符串A的第i个等于字符串的第j个:dp[i][j] = dp[i-1][j-1]
 *
 * (2)若字符串A的第i个不等于字符串的第j个:dp[i][j] = dp[i-1][j-1] + 1
 *
 * 原文链接：https://blog.csdn.net/gudada010/article/details/117464196
 */
public class L206_MinDistance {
    static int minDistance(String s, String t) {
        int m = s.length(), n = t.length();
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        // 注意，m要加1，n要加1
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

    /**
     * 方法2
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance2(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // n m 中有为0的情况
        if (n * m == 0) {
            return n + m;
        }

        // 初始化状态数组
        int[][] dp = new int[n + 1][m + 1];

        // 边界初始化，每移动一个位置相当于一次操作
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }

        // 从1开始代表第一个字符，故字符的位置为i-1
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // ex : {"*b","*c"} 当前字符为b c
                // ex : {"*b","*c"} 对word1进行删除b
                // ex : {"*,*c"} 删除b后，需要判断i-1和j
                int delete = dp[i - 1][j] + 1;
                // ex : {"*b","*c"} 当前字符为b c
                // ex : {"*bc","*c"} 对word1进行插入c
                // ex : {"*b,*"} 插入后c可以相当于消除，那么只需要判断i和j-1即可
                int insert = dp[i][j - 1] + 1;
                // ex : {"*b","*c"} 当前字符为b c
                // ex : {"*c","*c"} 对word1进行替换c
                // ex : {"*,*"} 替换c后，需要判断i-1和j-1
                int replace = dp[i - 1][j - 1];
                // 如果当前字符相等，则跳过，不相等则操作+1
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    replace += 1;
                }
                dp[i][j] = Math.min(insert, Math.min(delete, replace));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "intention", t = "execution";
        int res = minDistance(s, t);
        System.out.println(res);
    }
}
