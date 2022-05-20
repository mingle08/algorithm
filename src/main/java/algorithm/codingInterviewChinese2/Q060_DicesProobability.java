package algorithm.codingInterviewChinese2;

/**
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的计数之和为s。输入n，打印出s的所有可能的值出现的概率
 */
public class Q060_DicesProobability {
    int max = 6;

    public double[] printProbability(int n) {
        int[][] dp = new int[n][max * n];
        /**
         * 一般情况，一个骰子最大的点是6点，计为max
         * 1个骰子，能掷出的所有可能点数：1～6
         * 2个骰子，能掷出的所有可能点数：2～12，总共11种：12 - (2 - 1) = n * max - (n - 1)
         * 3个骰子，能掷出的所有可能点数：3～18，总共16种：18 - (3 - 1) = n * max - (n - 1)
         * 4个骰子，能掷出的所有可能点数：4～24，总共21种：24 - (4 - 1) = n * max - (n - 1)
         */
        double[] res = new double[max * n - n + 1];
        // base case
        for (int i = 1; i < max; i++) {
            dp[0][i] = 1;
        }

        for (int i = 2; i < n; i++) {
            // 当n为2时，最小的点数是2，最大的点数是12
            for (int j = i; j < n * max; j++) {
                // 循环的k，相当于最后一个骰子掷出的点数
                for (int k = 1; k < max; k++) {
                    if (i - 1 >= 0 && j - k >= 0) {
                        /**
                         * dp[i][j]表示i个骰子，和为j的掷法
                         * 它等于i-1个骰子，和分别为j-1，j-2，j-3，j-4，j-5，j-6
                         * 与最后一个骰子，分别掷出1，2，3，4，5，6点数相对应，这就是k的值
                         * 当k=1，2，3，4，5，6时，前i-1个骰子要保证和为j，点数就必须为
                         * j-1, j-2, j-3, j-4, j-5, j-6
                         * 所以dp[i][j]等于这6种情况的总和
                         */
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }

        double total = Math.pow(max, n);
        // 能掷出的所有可能的点数
        for (int i = 0; i < n * max - n + 1; i++) {
            res[i] = dp[n - 1][i + n - 1] / total;
        }
        return res;
    }

    public static void main(String[] args) {
        Q060_DicesProobability solution = new Q060_DicesProobability();
        double[] probability = solution.printProbability(2);
        for(double d : probability) {
            System.out.print(d + " ");
        }
    }
}
