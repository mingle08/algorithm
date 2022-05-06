package algorithm.leetCode;

import java.util.HashMap;
/**
 * 注意保留已经计算过的f(n)，要不然效率会很低
 */
public class LeetCode070_ClimbingStairs {

    public static void main(String[] args) {
        LeetCode070_ClimbingStairs solution = new LeetCode070_ClimbingStairs();
        int steps = solution.climbStairs(5);
        System.out.println(steps);

    }

    public int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        return climbStair(n-1, map) + climbStair(n-2, map);
    }

    public int climbStair(int n,HashMap<Integer,Integer> map) {
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(map.containsKey(n)){
            return map.get(n);
        } else{
            int val = climbStair(n-1, map) + climbStair(n-2, map);
            map.put(n, val);
            return val;
        }
    }
}
