package algorithm.leetCode;

public class LeetCode189_RotateArray {

    // 环状替换
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }

    // 最大公约数
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }

}
