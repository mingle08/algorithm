package algorithm.codingInterviewChinese2;

/**
 * 不用加减乘除，做加法
 * 题目：写一个函数，求两个整数之和，要求在函数体内不得使用“+”、“-”、“*”、“/”四则运算符号
 *
 * 思路：位运算（异或），步骤3个
 * 1，只做各位相加，不进位：0加0、1加1的结果都是0，0加1、1加0的结果都是1.这和异或^的结果是一样的
 * 2，做进位：0加0、0加1、1加0都不会产生进位，只有1加1时，会向前产生一个进位。
 *          这个进位，可以看作&运算，然后向左移一位
 * 3，把前面两个结果加起来：有可能有进位，所以重复循环这3步
 *
 * 加法器的原理
 */
public class Q065_AddTwoNumbers {

    public int add(int num1, int num2) {
        int sum, carry;
        do {
            // 1，异或^
            sum = num1 ^ num2;
            // 2，与&，因为进位要往前进一位，所以要左移
            carry = (num1 & num2) << 1;
            /**
             * 3，num1,nums2都向左移一位
             * 与第10题的逻辑很像
              */
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);    // 如果没有进位，就不用再循环了（此时num2是进位值）

        return num1;
    }
}
