package algo.leetCode;

import java.util.HashMap;
import java.util.Map;

public class Q001_TwoSum {

    public int[] findTwoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        int[] index = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                index[0] = map.get(target - nums[i]);
                index[1] = i;
                break;
            }

            map.put(nums[i], i);

        }

        return index;

    }

    public static void main(String[] args){
        Q001_TwoSum solution = new Q001_TwoSum();
        int[] arr = {2, 4, 7, 11, 15};
        int[] index = solution.findTwoSum(arr, 9);
        System.out.println(index[0] + ", " + index[1]);

    }


}
