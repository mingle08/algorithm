package algorithm.leetCode;

public class LeetCode050_PowerXAndN {

    private double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        // 防止出现溢出：当n为整数最小值-2147483648时，-n会溢出
        int h = n / 2;

        if (n < 0) {
            h = -h;
            x = 1 / x;
        }
        // 指数为原来的一半
        double res = myPow(x, h);
        // 所以要res的平方
        if (n % 2 == 0)
            return res * res;
        // 如果指数为奇数，要多乘一次基数
        return res * res * x;
    }

    public static void main(String[] args) {
        LeetCode050_PowerXAndN solution = new LeetCode050_PowerXAndN();
        double x = 2;
        int n = 6;
        double res = solution.myPow(x, n);
        System.out.println(x + "的" + n + "次幂=" + res);

    }
}
