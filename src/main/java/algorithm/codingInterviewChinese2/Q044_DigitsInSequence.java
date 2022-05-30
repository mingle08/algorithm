package algorithm.codingInterviewChinese2;

/**
 * 012345678910111213141516171819...99100...9991000...9999...
 * 1位数字有10个
 * 2位数字有90个，占位 180
 * 3位数字有900个，占位 2700
 * 。。。
 *
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * 下标从0开始算，第5位是5，第13位是数字11的第二个1，第19位是数字14的4
 *
 * 思路：比如输入19，先求得14，然后算出要14中的1还是4
 * 19 - 10 = 9
 * 9 < 2 * 90，说明是2位数
 * 9 / 2 = 4
 * 2位数的起始数字是10，在2位数中排行4的数，就是 10 + 4 = 14
 * 9 % 2 = 1
 * 即取14中下标为1的，那就是4
 *
 * 输入11
 * 11 - 10 = 1
 * 1 < 2 * 90，说明是2位数
 * 1 / 2 = 0
 * 2位数的起始数字是10，在2位数中排行0,就是10 + 0 = 10
 * 1 / 2 = 1
 * 10的下标1，是0
 */
public class Q044_DigitsInSequence {

    public char digitAtIndex(int n) {
        // 每个区间的起始数字
        int start = 1;
        // 几位数
        int digits = 1;
        // 例如 n = 15
        while (n > 9 * digits * start) {
            n -= 9 * digits * start;
            start *= 10;
            digits++;
        }
        // 如果是2位数，(n - 1) / digits表示在2位数中排第几，加上start就得出是哪个2位数
        // n 现在是 6， num = 10 + 5 / 2 = 12
        int num = start + (n - 1) / digits;
        // index = 5 % 2 = 1
        int index = (n - 1) % digits;
        String numStr = String.valueOf(num);
        // 字符串12的下标1对应的数字是2
        return numStr.charAt(index);
    }

    public static void main(String[] args) {
        Q044_DigitsInSequence solution = new Q044_DigitsInSequence();
        int index = 15;
        char num = solution.digitAtIndex(index);
        System.out.println(num);
    }
}
