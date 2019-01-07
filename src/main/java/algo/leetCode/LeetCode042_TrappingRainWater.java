package algo.leetCode;

public class LeetCode042_TrappingRainWater {

    public static void main(String[] args) {
        LeetCode042_TrappingRainWater solution = new LeetCode042_TrappingRainWater();
        int[] block = {0,1,0,2,1,0,1,3,2,1,2,1};
        int area = solution.trap(block);
        System.out.println(area);
    }
    
    public int trap(int[] block) {
        int length;
        int left, right;
        int maxLeft = 0, maxRight = 0;// 记录当前位置左边， 右边的最大值
        int result = 0;
 
        if (block == null || (length = block.length) == 0)
            return 0;
        left = 0;
        right = length - 1;
 
        while (left < right) {
            maxLeft = Math.max(maxLeft, block[left]);
            maxRight = Math.max(maxRight, block[right]);
 
            if (maxLeft < maxRight) {
                result += maxLeft - block[left];
                left++;
            } else {
                result += maxRight - block[right];
                right--;
            }
        }
        return result;
    }

}
