package algorithm.leetCode;

/**
 * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数dividend除以除数divisor得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode029_DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        if (dividend == 0)
            return 0;

        /**
         * 异或，确定商的符号
         * 2个小于0做异或运算，如果是true，就是二者符号不相同，即商是小于0，否则大于0
         */

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        // 被除数用正数表示
        long x;
        // Integer最小值取相反数会溢出，所以要先转成long类型
        if (dividend == Integer.MIN_VALUE) {
            // 先转成long类型
            x = dividend;
            // 再转成正数，就不受Integer最大值限制
            x = -x;
        } else {
            x = (dividend < 0) ? -dividend : dividend;
        }
        // 除数用正数表示
        long y;
        // Integer最小值取相反数会溢出，所以要先转成long类型
        if (divisor == Integer.MIN_VALUE) {
            y = divisor;
            y = -y;
        } else {
            y = (divisor < 0) ? -divisor : divisor;
        }
        int result = 0;
        // 如果 x < y，商为0，不用处理
        while (x >= y) {
            long temp = y;
            // 商
            int quotient = 1;
            // 除数乘以2
            while (x >= (temp << 1)) {
                // 商乘以2
                quotient <<= 1;
                // temp = temp << 1
                temp <<= 1;
            }
            result += quotient;
            x -= temp;
        }

        return (sign > 0) ? result : -result;
    }

    public static void main(String[] args) {
        int res = 0;
        res = divide(-1010369383,-2147483648);
        System.out.println(res);

//        res = divide(-2147483648,2);
//        System.out.println(res);
     }
}
