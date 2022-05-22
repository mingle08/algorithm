package algorithm.labuladong.chapter5;

public class L504_TrapWater {
    // 动态规划法
    public static int trap1(int[] height) {
        int ans = 0;
        int len = height.length;
        if (len < 3) return 0;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        // 初始化base case
        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            // 最大值
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int j = len - 2; j >= 0; j--) {
            // 最大值
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        for (int k = 1; k < len - 1; k++) {
            // 注意，是最小值
            ans += Math.min(leftMax[k], rightMax[k]) - height[k];
        }

        return ans;
    }

    // 双指针法
    public static int trap2(int[] height) {
        if (height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int ans = 0;

        int left_max = height[0];
        int right_max = height[n - 1];
        while (left < right) {
            left_max = Math.max(left_max, height[left]);
            right_max = Math.max(right_max, height[right]);
            // ans += Math.min(left_max, right_max) - height[i]
            if (left_max < right_max) {
                ans += left_max - height[left];
                left++;
            } else {
                ans += right_max - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 1, 1, 2, 1};
        int ans1 = trap1(height);
        int ans2 = trap2(height);
        System.out.println(ans1 + ", " + ans2);
    }
}
