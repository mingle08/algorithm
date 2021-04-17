package algo.codingInterviewChinese2;

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
            int bitMask = 1; //位掩码
            //从右向左判断位数是否为1
            for (int i = bitSum.length - 1; i >= 0; i--) {
                int bit = num & bitMask;
                //位数为1
                if (bit != 0) {
                    bitSum[i] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int result = 0;
        for (int j : bitSum) {
            result = result << 1;
            result += j % 3; // 余数：要么为0，要么为1
        }
        return result;
    }


    public static void main(String[] args){
        int[] nums = {4, 4, 1, 1, 1, 7, 4};
        int n = findNumberAppearOnce(nums);

        System.out.println(n);

        int a = 5; // 0000 0101
        int b = a & 1;
        System.out.println(a + " & 1 = " + b);    // 0
    }
}
