package algorithm.codingInterviewChinese2;

/**
 * 题目：输入一个整形数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
 * 求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)
 */
public class Q042_GreatestSumOfSubarrays {

    // 方法1 循环
    public int findGreatestSumOfSubarrays(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }

        int curSum = 0;
        // 初值为整数的最小值
        int greatestSum = Integer.MIN_VALUE;
        for (int j : arr) {
            // 和小于等于0，就让和等于当前的数
            if (curSum <= 0)
                curSum = j;
            // 和大于0，就加上当前的数
            else
                curSum += j;

            if (curSum > greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }

    // 方法2 动态规划
    public int findGreatestSum(int[] arr) {
        // 使用max记录最大值
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        // curSum[i] 表示以第i个数字结尾的子数组的最大和
        int[] curSum = new int[len];
        // base case
        curSum[0] = arr[0];
        // i从1开始
        for (int i = 1; i < len; i++) {
            // i-1的最大和小于等于0，i的最大和就等于arr[i]
            if (curSum[i - 1] <= 0) {
                curSum[i] = arr[i];
            } else {
                // i-1的最大和大于0，i的最大和就等于i-1最大和加上arr[i]
                curSum[i] = curSum[i - 1] + arr[i];
            }
            if (curSum[i] > max) {
                max = curSum[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q042_GreatestSumOfSubarrays solution = new Q042_GreatestSumOfSubarrays();
        int[] num = {1, -2, 3, 10, -4, 7, 2, -5};
        int sum = solution.findGreatestSumOfSubarrays(num);
        int sum2 = solution.findGreatestSum(num);
        System.out.println(sum + ", " + sum2);
    }
}
