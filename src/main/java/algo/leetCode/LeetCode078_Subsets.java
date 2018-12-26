package algo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode078_Subsets {

    public static void main(String[] args) {
        LeetCode078_Subsets solution = new LeetCode078_Subsets();
        int[] nums = {1,2,3};
        List<List<Integer>> resList = new ArrayList<>();
        
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        solution.backtracking(resList, list, nums, 0);
        System.out.println(resList);

    }
    
    private void backtracking(List<List<Integer>> resList,List<Integer> list,int[] nums,int start) {
        resList.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtracking(resList, list, nums, i+1);
            list.remove(list.size()-1);
        }
    }

}
