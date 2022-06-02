package algorithm.codingInterviewChinese2;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目二：数组中唯一只出现一次的数字
 * 在一个数组中，除一个数字只出现一次之外，其它数字都出现3次，请找出那个只出现一次的数字
 *
 * {4, 4, 1, 1, 1, 7, 4}
 * bitSum 32位 最后几位是4 1 4
 * 1的二进制是 0001
 * 4的二进制是 0100
 * 7的二进制是 0111
 * 也就是
 * 0001
 * 0001
 * 0001
 * 0100
 * 0100
 * 0100
 * + 0111
 * ------------------
 * 0414
 * 用0414的每一位除以3，余数为 0111，也就是7
 */
public class Q056_2_NumbersAppearOnce {

    public static int findNumberAppearOnce(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] bitSum = new int[32];
        /**
         * 把数组的每一位数字转化为二进制形式并相加
         */
        for (int num : nums) {
            // 位掩码，二进制更好理解：0000 0001
            int bitMask = 1;
            // 从右向左判断位数是否为1
            for (int i = bitSum.length - 1; i >= 0; i--) {
                int bit = num & bitMask;
                /*
                 * // 因为num没移动，是bitMask左移，如果num是0010，bitMask左移到0010的1的位置，则num & bitMask的结果就是0010
                 * if (bit != 0) {
                 * bitSum[i] += 1;
                 * System.out.println("bit=" + bit);
                 * }
                 * // bitMask左移
                 * bitMask = bitMask << 1;
                 */
                if (bit == 1) {
                    bitSum[i] += 1;
                    System.out.println("bit=" + bit);
                }
                // num右移
                num = num >> 1;
            }
        }
        int result = 0;
        for (int j = 0; j < 32; j++) {
            /**
             * 因为j是从左到右遍历bitSum，感觉是在左移bitSum
             * result计算之后，结果要左移一位，让右边的一位来计算下一次结果
             */
            result = result << 1;
            // 余数：要么为0，要么为1
            result += bitSum[j] % 3;
        }
        return result;
    }

    // 为什么要用以上那么复杂的异或运算
    public static Set<Integer> findNum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            // 再次遇见就删除，没有就保存
            if (set.contains(i)) {
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return set;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 4, 1, 1, 1, 7, 4 };
        int n = findNumberAppearOnce(nums);

        System.out.println(n);
        // 0000 0101
        int a = 5;
        // 1相当于 0000 0001
        int b = a & 1;
        // 0
        System.out.println(a + " & 1 = " + b);

        Set<Integer> res = findNum(nums);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
