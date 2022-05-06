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

    // 方法1
    public int digitAtIndex(int index) {
        if (index < 0)
            return -1;

        // 几位数
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits)
                return digitAtIndex(index, digits);

            // 因为1位数有10个，总共就占10位；2位数有90个，占180位；3位数有900个，占2700位
            index -= digits * numbers;
            digits++;
        }
    }

    /**
     * m位的数字总共有多少个，例如，输入2，返回二位数（10~99）的个数90；输入3，则返回三位数（100~199）的个数900
     *
     * @param digits
     * @return
     */
    private int countOfIntegers(int digits) {
        if (digits == 1)
            return 10;

        int count = (int) Math.pow(10, digits - 1);
        return 9 * count;
    }

    /**
     * 当我们知道要找的那一位数字位于某m位数之中后，就可以找出那一位数字
     *
     * @param index
     * @param digits
     * @return
     */
    private int digitAtIndex(int index, int digits) {
        // 对应的数值
        int number = beginNumber(digits) + index / digits;

        String str = Integer.toString(number);
        int idx = index % digits;

        char c = str.charAt(idx);
        System.out.println("数值是：" + number + ", 下标" + idx + "对应的数字是：" + c);
        // 求个位数字
        return Character.getNumericValue(c);
    }

    /**
     * m位数的第1个数字：例如，第一个二位数是10，第一个三位数是100.
     *
     * @param digits
     * @return
     */
    private int beginNumber(int digits) {
        if (digits == 1)
            return 0;

        return (int) Math.pow(10, digits - 1);
    }

    public static void main(String[] args) {
        Q044_DigitsInSequence solution = new Q044_DigitsInSequence();
        int index = 11;
        int num = solution.digitAtIndex(index);
        System.out.println(num);
    }
}
