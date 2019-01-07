package algo.swordToOffer;

/**
 * 丑数：只包含因子2,3,5的数。
 * 求按从小到大的顺序的第1500个丑数
 */
public class Q049_UglyNumber {

    public int getUglyNumber(int index){
        if (index < 0)
            return 0;

        int[] uglyNumber = new int[index];
        uglyNumber[0] = 1;
        int nextUglyIndex = 1;
        int indexMultiply2 = 0;
        int indexMultiply3 = 0;
        int indexMultiply5 = 0;
        while (nextUglyIndex < index){
            int num2 = uglyNumber[indexMultiply2] * 2;
            int num3 = uglyNumber[indexMultiply3] * 3;
            int num5 = uglyNumber[indexMultiply5] * 5;
            int min = Math.min(num2, Math.min(num3, num5));
            uglyNumber[nextUglyIndex] = min;
            while (uglyNumber[indexMultiply2] * 2 <= uglyNumber[nextUglyIndex])
                indexMultiply2++;

            while (uglyNumber[indexMultiply3] * 3 <= uglyNumber[nextUglyIndex])
                indexMultiply3++;

            while (uglyNumber[indexMultiply5] * 5 <= uglyNumber[nextUglyIndex])
                indexMultiply5++;

            nextUglyIndex++;
        }
        return uglyNumber[index - 1];
    }

    public static void main(String[] args){
        Q049_UglyNumber solution = new Q049_UglyNumber();
        int number = solution.getUglyNumber(1500);
        System.out.println(number);  // 859963392
    }
}
