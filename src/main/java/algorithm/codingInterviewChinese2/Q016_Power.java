package algorithm.codingInterviewChinese2;

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
        // 情况1：base为0
        if (base == 0) return 0;
        // 如果exponent是-2147483648
        int h = exponent / 2;
        // 情况2：指数是零或负数
        if (exponent < 0) {
            base = 1 / base;
            // 负数要转成正数
            h = -h;
        }
        double res = 0;
        // 指数是原来的一半
        res = powerLoop(base, h);
        // 所以要 res的平方
        if (exponent % 2 == 0)
            return res * res;
        // 指数如果是奇数，则要多乘一次基数
        return res * res * base;
    }

    /**
     * 快速幂的递归写法
     * @param base
     * @param exponent
     * @return
     */
    private static double powerRecursively(double base, int exponent){
        if (exponent == 0){
            return 1;
        }

        /*
          base case 递归终止条件
          无论指数是奇是偶，右移一位都能达到指数为1
        */
        if (exponent == 1){
            return base;
        }

        // 用右移 >> 1 代替除以2
        double res = powerRecursively(base, exponent >> 1);
        // 1，做平方运算的是res
        res *= res;
        /*
          2，如果是奇数，再乘以base
          与1运算判断一个数是奇数还是偶数
          如果指数是5，只有递归返回到最上面一层，才会执行这个if
          如果是偶数，不会执行此if
         */
        if ((exponent & 0x1) == 1){  //
            res *= base;
        }

        return res;
    }

    /**
     * 快速幂的循环写法
     *
     * @param base
     * @param exponent
     * @return
     */
    public static double powerLoop(double base, int exponent) {
        double res = 1;
        while(exponent != 0) {
            /*
              如果指数是5，第一次循环会执行这里，还有最后一次循环会执行这里
              因为5右移一位是2，2右移一位是1。
              偶数：只有最后2右移一位变成1才会执行这个if，总共1次
              奇数：第一次循环会执行这个if，最后2右移一位变成1，也会执行这个if，总共2次
              所以无论奇偶，最后指数右移都会变成1，都会执行这里
              比如3^5，第一次执行 base是3，res是3；第二次执行，base已经变成81了，res是3，结果是3 * 81
              做平方运算的是base
            */
            if ((exponent & 1) == 1) {
                res *= base;
            }
            /*
               base平方，对比递归写法，是res平方
             */
            base *= base;
            // 指数右移
            exponent = exponent >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        double res = power(2, -2147483648);
//        double res = quickPower(3, 5);
        System.out.println("幂运算的结果：" + res);
    }
}
