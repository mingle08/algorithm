package algo.swordToOffer;

/**
 * 题目：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如：把9表示成二进制是1001，有两位是2，如果输入9.则输出2.
 */
public class Q015_NumberOf1InBinary {
    public int numberOf1(int num){
        int count = 0;
        int flag = 1;
        while (num != 0){
            if ((num & flag) == 1){
                count++;
                flag = flag << 1;
            }
        }
        return count;
    }

    /**
     * 思路：把一个整数减去1，再和原整数做与运算，会把该整数最右边的1变成0.
     * 那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
     * 举例：一个二进制数1100，它的第二位是从最右边数起的一个1，
     * （1）减去1后，第二位变成0，它后面的两位0变成1，而前面的1保持不变，因此得到结果是1011
     * （2）再把1100和1011做位与（&）运算，得到的结果是1000.
     * 结论：我们把1100最右边的1变成了0，结果刚才就是1000
     * @param num
     * @return
     */
    public int numOf1(int num){
        int count = 0;
        while (num != 0){
            count++;
            //num & (num - 1) ： 可以将num二进制表示中最右边的1变为0
            num = num & (num - 1);
        }

        return count;
    }
}
