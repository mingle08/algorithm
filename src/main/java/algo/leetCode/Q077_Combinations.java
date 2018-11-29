package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q077_Combinations {

    public static void main(String[] args) {
        Q077_Combinations solution = new Q077_Combinations();
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
