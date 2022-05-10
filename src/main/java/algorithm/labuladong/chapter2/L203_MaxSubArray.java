package algorithm.labuladong.chapter2;

/**
 * 输入一个整数数组nums，请在其中找一个和最大的子数组，返回这个子数组的和
 * dp[i]表示以nums[i]为结尾的最大子数组和
 *
 */
public class L203_MaxSubArray {

    static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // base case
        // 第一个元素前面没有子数组
        dp[0] = nums[0];
        // 状态转移方程
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }
        // 得到nums的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    static int maxSubArray2(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        // base case
        int dp_0 = nums[0];
        int dp_1 = 0, res = dp_0;

        for (int i = 1; i < n; i++) {
            // dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            dp_1 = Math.max(nums[i], nums[i] + dp_0);
            dp_0 = dp_1;
            // 顺便计算最大的结果
            res = Math.max(res, dp_1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-3, 4, -1, 2, -6, 1, 4};
        int res1 = maxSubArray(nums);
        int res2 = maxSubArray2(nums);
        System.out.println(res1 + ", " + res2);
    }
}
