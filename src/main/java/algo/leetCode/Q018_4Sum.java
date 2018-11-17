package algo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
 [-1,  0, 0, 1],
 [-2, -1, 1, 2],
 [-2,  0, 0, 2]
 ]
 */
public class Q018_4Sum {
    public static List<List<Integer>> fourSum(int[] arr, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(arr == null || arr.length < 4)
            return result;
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {
            if(i != 0 && arr[i] == arr[i-1])
                continue;
            for(int j = i + 1; j < arr.length - 2; j++){
                if(j != 0 && arr[j] == arr[j-1])
                    continue;
                int m = j + 1;
                int n = arr.length - 1;
                while(m < n){
                    int sum = arr[i] + arr[j] + arr[m] + arr[n];
                    if(sum < target){
                        m++;
                    }else if(sum > target){
                        n--;
                    }else{
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[m]);
                        list.add(arr[n]);
                        result.add(list);
                        m++;
                        n--;
                        while(m < n && arr[n] == arr[n-1]){
                            n--;
                        }
                        while (m < n && arr[m] == arr[m-1]){
                            m++;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res.size());
    }
}
