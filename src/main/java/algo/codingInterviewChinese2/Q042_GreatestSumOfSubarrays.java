package algo.codingInterviewChinese2;

public class Q042_GreatestSumOfSubarrays {

    public int findGreatestSumOfSubarrays(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return 0;
        }

        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int j : arr) {
            if (curSum <= 0)
                curSum = j;
            else
                curSum += j;

            if (curSum > greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }

    // 动态规划
    public int findGreatestSum(int[] arr) {
        int max = Integer.MIN_VALUE;
        int len = arr.length;
        int[] curSum = new int[len];    // curSum[i] 表示以第i个数字结尾的子数组的最大和
        curSum[0] = arr[0];

        for (int i = 1; i < len; i++) {
            if (curSum[i - 1] <= 0) {
                curSum[i] = arr[i];
            } else {
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
