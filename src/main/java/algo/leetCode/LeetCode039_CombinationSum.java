package algo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode039_CombinationSum {
	public static void main(String[] args) {
		LeetCode039_CombinationSum solution = new LeetCode039_CombinationSum();
		int[] nums = {2,3,6,7};
		int target = 7;
		List<List<Integer>> res = solution.combinationSum(nums, target);
		System.out.println(res.size());
	}

	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        findSum(candidates, target, 0,0,temp, res);   
        return res;
    }
    
    public void findSum(int[] candidates, int target, int num, int level,List<Integer> temp, List<List<Integer>> res){
        if(num == target) {
            res.add(new ArrayList<>(temp));
            return;
        } else if(num > target) {
            return;
        } else {
            for(int i=level;i<candidates.length;i++) {
                temp.add(candidates[i]);
                findSum(candidates, target, num+candidates[i], i, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
	
}
