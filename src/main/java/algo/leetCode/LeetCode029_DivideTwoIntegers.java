package algo.leetCode;

public class LeetCode029_DivideTwoIntegers {
    public static int divide(int dividend, int divisor){
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if (dividend == 0)
            return 0;

        // 异或，确定商的符号
        int sign = ((dividend < 0) ^ (divisor < 0) ) ? -1 : 1;
        long x = (dividend < 0) ? -dividend : dividend;
        long y = (divisor < 0) ? -divisor : divisor;
        int result = 0;
        while (x >= y){
            long temp = y;
            int quotient = 1;  // 商
            while (x >= (temp << 1)){
                quotient <<= 1;
                temp <<= 1;
            }
            result += quotient;
            x -= temp;
        }

        return (sign > 0) ? result : -result;
    }

    public static void main(String[] args){
        int res = divide(19,3);
        System.out.println(res);
    }
}
