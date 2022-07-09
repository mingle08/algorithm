package algorithm.codingInterviewChinese2;

/**
 * 斐波那契数列：
 * 还有一种时间复杂度为o(logn)但不够实用的方法：矩阵的平方
 */
public class Q010_Fibonacci {

    /**
     * 效率太低，速度慢，因为重复的计算太多。
     * @param n
     * @return
     */
    public long fibonacci1(int n){
        if(n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    /**
     * 从下往上计算。
     * 时间复杂度为O(n)
     * @param n
     * @return
     */
    public long fibonacci2(int n){
        int[] res = {0,1};
        if(n < 2){
            return res[n];
        }
        long f0 = 0;
        long f1 = 1;
        long f2 = 0;

        for (int i = 2; i <= n; i++) {
            f2 = f0 + f1;
            /**
             * f0,f1都向后移一位
             * 与65题相似
             */
            f0 = f1;
            f1 = f2;
        }

        return f2;
    }

    // 带备忘录的递归
    public int fib(int n) {
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    /**
     * 注意入参n，对应的memo就是memo[n]
     * @param memo
     * @param n
     * @return
     */
    private int helper(int[] memo, int n) {
        // base case
        if (n < 2) return n;
        // 如果已经计算过了（在memo中有值），直接取出并返回
        if (memo[n] != 0) return memo[n];
        // 如果没计算过，则把计算结果保存到memo
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    public static void main(String[] args){
        Q010_Fibonacci solution = new Q010_Fibonacci();

        long res1 = solution.fibonacci1(20);
        long res2 = solution.fibonacci2(20);
        long res3 = solution.fib(20);
        System.out.println(res1 + ", " + res2 + ", " + res3);
    }
}
