package algo.leetCode;

import java.util.HashSet;

public class LeetCode128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();
        for(int i = 0;i<nums.length;i++)
            sets.add(nums[i]);

        int max = 0;  // 众多连续的个数，取最大值
        int count;  // 每一个数字所处的连续序列的最长个数
        for(int i = 0;i<nums.length;i++){
            count = 0;
            int val = nums[i];
            int valTmp = val;
            // 循环找比当前值大的相邻数
            while(sets.contains(valTmp)){
                count++;
                sets.remove(val);  // 每判断一个数之后，从set中删除
                valTmp++;
            }
            // 循环找比当前值小的相邻数
            while(sets.contains(val-1)){
                count++;
                sets.remove(val-1); // 每判断一个数之后，从set中删除
                val--;
            }
            if(count>max)
                max = count;
        }

        return max;
    }

    public static void main(String[] args){
        LeetCode128_LongestConsecutiveSequence solution = new LeetCode128_LongestConsecutiveSequence();
        int[] num = {100, 4, 200, 1, 3, 2};
        int count = solution.longestConsecutive(num);
        System.out.println(count);
    }
}
