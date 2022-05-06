package algorithm.leetCode;

/**
 * 题目分析：本题假设给定的字符串为"s[1]s[2]……s[len]"，若我们用dp[i-1]表示前i-1个字符的解码方法数，
 * 那么求解dp[i]分为两步。
 * 第一，若第i个字符s[i]!='0'，那么第i个字符可以单独划分为一个字母，
 * 前i-1个字母的划分对其没有影响，即dp[i] = dp[i-1]；
 * 第二，若第i-1个字符和第i个字符可以组合成大于等于“10”， * 并且小于等于“26”的双字符，
 * 那么后两个字母组合一下，方法数为前i-2个字符的方法数，即dp[i] = dp[i] + dp[i-2]。

 */
public class LeetCode091_DecodeWays {

    public static int numDecodings(String s) {
        if(s.length()==0){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0)=='0'?0:1;
        if(s.length()==1){
            return dp[0];
        }
        int k = s.charAt(0) > '0' && s.charAt(1) > '0'? 1:0;
        dp[1] = k + (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6' ? 1:0);
        // 0下标和1下标都已算出，从2下标开始循环
        for (int i = 2; i < dp.length; i++) {
            if(s.charAt(i)!='0'){
                dp[i] += dp[i-1];
            }
            if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2' && s.charAt(i) <= '6'){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args){

        LeetCode091_DecodeWays solution = new LeetCode091_DecodeWays();

        String num = "322";
        int count = solution.numDecodings(num);

        System.out.println(count);

    }
}
