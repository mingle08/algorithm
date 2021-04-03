package algo.codingInterviewChinese2;

/**
 * 一个整数n可以用 n & 1 来判断奇偶性
 * 例如：21 & 1
 * 10101 & 00001  = 1 ( &操作，二个都为1，结果才等于 1 ）
 *
 * 16 & 1
 * 10000 & 00001 = 0
 */
public class Q016_Power {

    public static double power(double base, int exponent) {
        if (base == 0) return 0;
        if (exponent < 0) base = 1 / base;
        double res = 0;
        res = powerWithUnsignedExponent(base, exponent);
        return res;
    }

    private static double powerWithUnsignedExponent(double base, int exponent){
        if (exponent == 0){
            return 1;
        }

        if (exponent == 1){
            return base;
        }

        // 用右移 >> 代替除以2
        double res = powerWithUnsignedExponent(base, exponent >> 1);
        res *= res;
        if ((exponent & 0x1) == 1){  // 位与判断一个数是奇数还是偶数
            res *= base;
        }

        return res;
    }

    /**
     * 快速幂
     * 比如 3^8, 8的二进制是 1000
     * 3^8
     * = 3^(1 * 2^3 + 0 * 2^2 + 0 * 2^1 + 0 * 2^0)
     * = (3^(2^3))^1 * (3^(2^2))^0 * (3^(2^1))^0 * (3^(2^0))^0
     * = 3^(2^3) * 1 * 1 * 1
     * @param base
     * @param exponent
     * @return
     */
    public static double quickPower(double base, int exponent) {
        double res = 1;
        while(exponent != 0) {
            if ((exponent & 1) == 1) { // 只有二进制的位是1，才记入结果
                res *= base;    // 循环第一次执行到这里，相当于最右位：base^(2^0)
            }
            /*
               循环第一次走到base *= base，就是base^2，第二次执行到这里就是4次方，
               第三次执行到这里就是8次方，只有二进制的位上是1才记入结果，
               不然只是计算平方，供后面是1的使用
             */
            base *= base;   // base^2, base^4, base^8 ……  只有二进制是1的才记住结果
            exponent = exponent >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
//        double res = power(3, 5);
        double res = quickPower(3, 5);
        System.out.println("幂运算的结果：" + res);
    }
}
