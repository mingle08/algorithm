package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode090_SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, list, nums, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> list, int[] arr, int start){
        result.add(new ArrayList<>(list));
        for (int i = start; i < arr.length; i++) {
            if (i > start && arr[i] == arr[i-1]){// 跳过重复的
                continue;
            }
            list.add(arr[i]);
            backtracking(result, list, arr, i+1);
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args){

        LeetCode090_SubsetsII solution = new LeetCode090_SubsetsII();
        int[] numbers = {1,2,2};
        List<List<Integer>> res = solution.subsetsWithDup(numbers);
        System.out.println(res.size());

    }
}
