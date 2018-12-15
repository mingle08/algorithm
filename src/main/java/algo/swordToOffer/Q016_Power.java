package algo.swordToOffer;

/**
 * 一个整数n可以用 n & 1 来判断奇偶性
 * 例如：21 & 1
 * 10101 & 00001  = 1 ( &操作，二个都为1，结果才等于 1 ）
 *
 * 16 & 1
 * 10000 & 00001 = 0
 */
public class Q016_Power {

    public double powerWithUnsignedExponent(double base, int exponent){
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
}
