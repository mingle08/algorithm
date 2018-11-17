package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q046_Permutations {

    public static void main(String[] args) {
        Q046_Permutations solution = new Q046_Permutations();
        int[] arr = {2,3,5};
        List<List<Integer>> list = solution.permute(arr);
        System.out.println(list.size());

    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> array=new ArrayList<>();
         
         
        int n=nums.length;
        backtracking(list, array, 0, n, nums);
        return list;
    }
     
    public void backtracking(List<List<Integer>> list,List<Integer> array,int t,int n,int[] nums) {
        if(t>n) return;
        else if(t==n){
            list.add(new ArrayList<>(array));
        }else{
            for(int i=0;i<n;i++){
                if((!array.contains(nums[i]))){
                    array.add(nums[i]);
                    backtracking(list, array, t+1, n, nums);
                    array.remove(array.size()-1);  // 去掉最后面的元素
                }
            }
        }
    }

}
