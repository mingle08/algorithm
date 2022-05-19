package algorithm.codingInterviewChinese2;

/**
 * 输入2个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n。
 * 比如10的二进制表示为1010，13的二进制表示为1101，需要改变1010中的3位才能得到1101.
 * 我们可以分为二步解决这个问题：
 * 1，求这二个数的异或：异或的规则是转换成二进制比较，相同为0，不同为1.
 * 2，统计异或结果中1的位数
 */
public class Q015_NumOfBitToChange {

    private static int countNumOfBit(int m, int n) {
        // 1，异或
        int x = m ^ n;
        // 2，统计异或结果中1的位数
        int count = numOf1(x);
        return count;
    }

    private static int numOf1(int num){
        int count = 0;
        while (num != 0){
            count++;
//            num = num & (num - 1);  //  将num二进制表示中最右边的1变为0
            num &= (num - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 13;
        int count = countNumOfBit(a, b);
        System.out.println(count);
    }
}
