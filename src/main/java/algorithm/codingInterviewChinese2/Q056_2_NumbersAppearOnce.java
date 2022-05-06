package algorithm.codingInterviewChinese2;

/**
 * 题目二：数组中唯一只出现一次的数字
 * 在一个数组中，除一个数字只出现一次之外，其它数字都出现3次，请找出那个只出现一次的数字
 *
 * {4, 4, 1, 1, 1, 7, 4}
 * bitSum 32位    最后几位是4 1 4
 * 1的二进制是 0001
 * 4的二进制是 0100
 * 7的二进制是 0111
 * 也就是
 *           0001
 *           0001
 *           0001
 *           0100
 *           0100
 *           0100
 *      +    0111
 *   ------------------
 *           0414
 *   用0414的每一位除以3，余数为 0111，也就是7
 */
public class Q056_2_NumbersAppearOnce {

    private static int findNumberAppearOnce(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] bitSum = new int[32];
        for (int num : nums) {
            //位掩码，二进制更好理解：0000 0001
            int bitMask = 1;
            //从右向左判断位数是否为1
            for (int i = bitSum.length - 1; i >= 0; i--) {
                int bit = num & bitMask;
                //位数为1，可能在不同的位置上，所以bit是2的幂
                if (bit != 0) {
                    bitSum[i] += 1;
                    System.out.println("bit=" + bit);
                }
                // 左移
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int j : bitSum) {
            /**
             * 因为j是从左到右遍历bitSum，感觉是在左移bitSum
             * result计算之后，结果要左移一位，让右边的一位来计算下一次结果
             */
            result = result << 1;
            // 余数：要么为0，要么为1
            result += j % 3;
        }
        return result;
    }


    public static void main(String[] args){
        int[] nums = {4, 4, 1, 1, 1, 7, 4};
        int n = findNumberAppearOnce(nums);

        System.out.println(n);
        // 0000 0101
        int a = 5;
        // 1相当于 0000 0001
        int b = a & 1;
        // 0
        System.out.println(a + " & 1 = " + b);
    }
}
