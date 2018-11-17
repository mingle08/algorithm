package algo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q040_CombinationSumII {

	public static void main(String[] args) {
		Q040_CombinationSumII solution = new Q040_CombinationSumII();
		int[] nums = {10, 1, 2, 7, 6, 1, 5};
		int target = 8;
		List<List<Integer>> res = solution.combinationSum2(nums, target);
		System.out.println(res.size());

	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		combinationSum(result, list, candidates, target, 0);
		return result;
    }
	
	private void combinationSum(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int index){
 
		for(int i = index; i < candidates.length; i++){
			int temp = candidates[i];
			if(temp == target){
				list.add(temp);
				result.add(new ArrayList<Integer>(list));
				list.remove(list.size()-1);
				break;
			}
			if(candidates[i] < target){
				list.add(candidates[i]);
				combinationSum(result, list, candidates, target - temp, i + 1);
				list.remove(list.size()-1);
				while(i < candidates.length-1 && candidates[i] == candidates[i+1]){
					i++;
				}
			}
			if(temp > target){
				break;
			}
		}
	}

}
