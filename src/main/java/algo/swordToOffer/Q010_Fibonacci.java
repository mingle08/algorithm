package algo.swordToOffer;

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
        long fib1 = 1;
        long fib2 = 0;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;
            fib2 = fib1;
            fib1 = fibN;
        }

        return fibN;
    }
}
