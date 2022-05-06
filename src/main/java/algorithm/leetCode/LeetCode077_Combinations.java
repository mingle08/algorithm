package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 … n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class LeetCode077_Combinations {

    public static void main(String[] args) {
        LeetCode077_Combinations solution = new LeetCode077_Combinations();
        int n = 4, k = 2;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        solution.backtracking(res, tempList,  1, 1, n, k);

        System.out.println(res.size());
    }

    private void backtracking(List<List<Integer>> resList,List<Integer> list,int t,int start,int n, int k) {
        if(t>k){
            resList.add(new ArrayList<>(list));
        }else{
            for(int i=start;i<=n;i++){
                list.add(i);
                backtracking(resList, list, t+1,i+1, n, k);
                list.remove(list.size()-1);
            }
        }
    }

}
