package algorithm.labuladong.chapter5;

/**
 * 贪心算法
 */
public class L507_Jump {

    /**
     * 输入一个非负整数nums，数组元素nums[i]代表，如果站在位置i，最多能够向前跳几步。
     * 现在你站在第一个位置nums[0]，请问能否跳到nums的最后一个位置？
     * @param nums
     * @return
     */
    boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
            farthest = Math.max(farthest, i + nums[i]);
            // 可能碰到了0，卡住跳不动了
            if (farthest <= i) return false;
        }
        return farthest >= n - 1;
    }

    /**
     * 输入一个非负整数nums，数组元素nums[i]代表，如果站在位置i，最多能够向前跳几步。
     * 现在保证你一定可以跳到最后一格，请问你最少要跳多少次才能跳过去？
     * @param nums
     * @return
     */
    int jump(int[] nums) {
        int n = nums.length;
        // 从索引[i...end]起跳，最远能到的距离
        int farthest = 0;
        // 站在索引i，最多能跳到索引end
        int end = 0;
        // 记录跳跃次数
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            // 当end == i时，这次的跳跃计算最远距离已经完成
            if (end == i) {
                count++;
                // 下次跳跃的end更新为本次计算的最远距离
                end = farthest;
            }
        }
        return count;
    }
}
