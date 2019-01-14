package algo.swordToOffer;

public class Q044_DigitsInSequence {
    public int digitAtIndex(int index){
        if (index < 0)
            return -1;

        int digits = 1;
        while (true){
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits)
                return digitAtIndex(index, digits);

            index -= digits * numbers;
            digits++;
        }
    }

    /**
     * m位的数字总共有多少个，例如，输入2，返回二位数（10~99）的个数90；输入3，则返回三位数（100~199）的个数900
     * @param digits
     * @return
     */
    private int countOfIntegers(int digits){
        if (digits == 1)
            return 10;

        int count = (int)Math.pow(10, digits - 1);
        return 9 * count;
    }

    /**
     * 当我们知道要找的那一位数字位于某m位数之中后，就可以找出那一位数字
     * @param index
     * @param digits
     * @return
     */
    private int digitAtIndex(int index, int digits){
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
     * @param digits
     * @return
     */
    private int beginNumber(int digits){
        if (digits == 1)
            return 0;

        return (int)Math.pow(10, digits - 1);
    }

    public static void main(String[] args){
        Q044_DigitsInSequence solution = new Q044_DigitsInSequence();
        int index = solution.digitAtIndex(1001);
        System.out.println(index);
    }
}
