package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given array nums = [-1, 0, 1, 2, -1, -4],

 * A solution set is:
 * [
 *  [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class LeetCode015_3Sum {

    public static List<List<Integer>> threeSum(int[] nums, int target){

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 避免重复的集合
            if(i>0 && nums[i] == nums[i-1]) continue;

            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);

                    // 每一次遇到符合条件的元素集合后，再移动二个指针
                    j++;
                    k--;

                    // 避免重复元素
                    while(j < k && nums[j] == nums[j-1]) j++;
                    while(j < k && nums[k] == nums[k+1]) k--;
                } else if(sum < target){ // 小于，移到左指针
                    j++;
                }else if(sum > target){// 大于，移动右指针
                    k--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args){
        int[] a = {-1, 0, 1, 2, -1, -4};
        long startTime = System.nanoTime();
        List<List<Integer>> list = threeSum(a, 0);
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime) + "ns");
        System.out.println(list.size());
    }
}
