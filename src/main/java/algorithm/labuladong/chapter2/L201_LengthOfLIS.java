package algorithm.labuladong.chapter2;

import java.util.Arrays;

/**
 * 最长递增子序列的长度
 * 1，动态规划法
 * 2，二分查找（常人无法想到这个方法）
 */
public class L201_LengthOfLIS {
    // 动态规划法
    private static int lengthOfLIS1(int[] nums) {
        // dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case : dp数组全部都初始化为1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                /**
                 * dp[j]是以nums[j]结尾的最长递增子序列的长度
                 * dp[i]默认值是1
                 * 找到i前面，比nums[i]小的结尾，加上1，在形成的众多新的子序列中选取最长的那一个
                 */
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int k = 0; k < dp.length; k++) {
            res = Math.max(res, dp[k]);
        }

        return res;
    }

    // 二分查找
    private static int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数，初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            // 二分查找
            int left = 0, right = piles;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;

            // 把这张牌放到牌顶
            top[left] = poker;
        }
        // 牌堆数就是LIS长度
        return piles;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 5, 10, 11, 2, 9, 14, 13, 7, 4, 8, 12};
        int length = lengthOfLIS1(arr);
        System.out.println(length);
    }
}
