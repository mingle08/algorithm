package algo.codingInterviewChinese2;

public class Q044_DigitsInSequence {

    // 方法1
    public int digitAtIndex(int index) {
        if (index < 0)
            return -1;

        int digits = 1;    // 几位数
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
        // 从数值右边开始算的位置
        int indexFromRight = digits - index % digits;
        // 去除右边的indexFromRight-1个数字
        for (int i = 1; i < indexFromRight; i++)
            number /= 10;

        // 求个位数字
        return number % 10;
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

    // 方法2
    public int findNthDigit(int n) {
        int digits = 1;
        long count = 9;
        int start = 1;

        while (n > start * digits * count) {
            n -= start * digits * count;
            digits += 1;
            start *= 10;
        }

        start += (n - 1) / digits;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % digits));
    }

    public static void main(String[] args) {
        Q044_DigitsInSequence solution = new Q044_DigitsInSequence();
        int index = 1001;
//        int num = solution.digitAtIndex(index);
        int num = solution.findNthDigit(index);
        System.out.println(num);
    }
}
