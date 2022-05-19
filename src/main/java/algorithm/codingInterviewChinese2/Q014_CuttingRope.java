package algorithm.codingInterviewChinese2;

/**
 * 动态规划求解的问题的4个特点：
 * 1，求最优解
 * 2，整体问题的最优解是依赖各个子问题的最优解
 * 3，把大问题分解成若干个小问题，这些小问题之间还有相互重叠的更小的子问题
 * 4，从上往下分析问题，从下往上求解问题
 *
 *  题目：给你一根长度为 n 的绳子，请把绳子剪成 m 段（m、n都是整数，n>1 并且 m>1），
 *  每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0] * k[1] * ... * k[m]可能的最大乘积是多少？
 *  例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 */
public class Q014_CuttingRope {

    // 1. 动态规划  时间复杂度：O(n^2)  空间复杂度：O(n)
    public static int maxProductAfterCutting_1(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        /**
         * 子问题的最优解存储在products数组中，
         * 数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
         */

        int[] products = new int[length + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= length; i++){
            max = 0;
            /**
             * 为了求解f(i)，需求求出所有可能的f(j) * f(i - j)并比较得出最大值
             */
            for (int j = 0; j <= i/2 ; j++) {
                int product = products[j] * products[i-j];
                if (max < product)
                    max = product;

                // 变量i
                products[i] = max;
            }
        }

        max = products[length];
        return max;
    }

    // 2. 贪婪算法   时间： O(1)   空间：  O(1)
    /**
     * 当 n >= 5时，尽可能多地剪长度为3的绳子
     * 当 剩下的绳子长度为4时，把绳子剪成2段长度为2的绳子，其实剪与不剪，都是4
     */
    public static int maxProductAfterCutting_2(int length){
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;

        // 尽可能多地剪去长度为3的绳子段，可以剪的总段数
        int timesOf3 = length / 3;

        /**
         * 当绳子最后剩下的长度为4的时候，不能再剪去长度为3的绳子段
         * 此时更好的方法是把绳子剪成长度为2的两段，因为2 * 2 > 3 * 1
          */
        if (length - timesOf3 * 3 == 1)
            timesOf3 = timesOf3 - 1;   // 退出一个3出来，与1组成长度为4的绳子段

        int timeOf2 = (length - timesOf3 * 3) / 2;

        return (int)(Math.pow(3, timesOf3)) * (int)(Math.pow(2, timeOf2));

    }

    public static void main(String[] args) {
        int len = 8;
        int res1 = maxProductAfterCutting_1(len);
        int res2 = maxProductAfterCutting_2(len);
        System.out.println(res1 + ", " + res2);
    }
}
