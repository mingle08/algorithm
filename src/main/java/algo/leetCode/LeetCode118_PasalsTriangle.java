package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118_PasalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0){
            return res;
        }

        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);  // 第一行的单独1
        res.add(pre);

        for(int i = 0; i<numRows-1; i++){
            List<Integer> cur = new ArrayList<Integer>();

            cur.add(1); //首部加第一个1
            for(int j = 1; j<pre.size(); j++){
                //第三行才会进入此循环
                cur.add(pre.get(j-1) + pre.get(j));
            }
            cur.add(1); //末尾加最后一个1

            res.add(cur);
            pre = cur;
        }
        return res;
    }

    public static void main(String[] args){
        LeetCode118_PasalsTriangle solution = new LeetCode118_PasalsTriangle();

        List<List<Integer>> res = solution.generate(5);

        System.out.println(res);

    }
}
