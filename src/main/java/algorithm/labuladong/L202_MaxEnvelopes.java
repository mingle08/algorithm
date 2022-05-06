package algorithm.labuladong;

import java.util.Arrays;
import java.util.Comparator;

public class L202_MaxEnvelopes {
    private static int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        // 对高度数组寻找LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        return lengthOfLIS(height);
    }

    private static int lengthOfLIS(int[] nums) {
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

    public class Envelope {
        private int width;
        private int height;
        public Envelope(int w, int h) {
            width = w;
            height = h;
        }
    }

    public static void main(String[] args) {

    }
}
