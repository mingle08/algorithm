package algo.leetcode;

public class LeetCode050_PowerXAndN {

    public static void main(String[] args) {
        algo.leetcode.LeetCode050_PowerXAndN solution = new algo.leetcode.LeetCode050_PowerXAndN();
        double x = 2;
        int n = 6;
        double res = solution.myPow(x, n);
        System.out.println(x + "的" + n + "次幂=" + res);

    }
    
    private double myPow(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        int h = n / 2; // 防止出现溢出：当n = Integer.MIN_VALUE时，-n会溢出

        if(n < 0){
            h = -h;
            x = 1/x;
        }
        double res = myPow(x, h);
        if(n%2 == 0)
            return res * res;
        return res * res * x;
    }

}
