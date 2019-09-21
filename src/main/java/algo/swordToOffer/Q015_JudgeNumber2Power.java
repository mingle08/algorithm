package algo.swordToOffer;

/**
 * 用一条语句判断一个整数是不是2的整数次方。
 * 一个整数如果是2的整数次方，那么它的二进制表示中有且仅有一位是1，而其它所有位都是0.
 * 根据前面的分析，把这个整数减去1之后再和它自己做与运算，这个整数中唯一的1就会变成0，
 * 整个运算的结果就是0
 */
public class Q015_JudgeNumber2Power {

    private static boolean numberIs2Power(int num) {
        boolean flag = false;
//        num &= num - 1;
        if ((num & (num - 1)) == 0) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        // 直接使用二进制表示
        int num = 0b0100;
        boolean flag = numberIs2Power(num);
        System.out.println(flag);
    }
}
