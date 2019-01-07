package algo.leetCode;

import java.util.Arrays;

/**
 * Given array nums = [-1, 2, 1, -4], and target = 1.

 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class LeetCode016_3SumClosest {

    public static int threeSumClosest(int[] arr, int target){
        if(arr == null || arr.length < 3){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length ; i++) {
            int low = i + 1;
            int high = arr.length - 1;
            while(low < high){
                int sum = arr[i] + arr[low] + arr[high];
                int diff = Math.abs(target - sum );
                if(diff < min){
                    min = diff;
                    result = sum;
                }

                if(target == sum){
                    return result;
                }else if(target > sum){
                    low++;
                }else {
                    high--;
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        int[] nums = {-1, 2, 1, -4};
        int res = threeSumClosest(nums, 1);
        System.out.println(res);
    }
}
