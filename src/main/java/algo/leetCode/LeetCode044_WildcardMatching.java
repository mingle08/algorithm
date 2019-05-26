package algo.leetCode;
/**
 *  输入:
        s = "adceb"
        p = "*a*b"
            输出: true
            解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
            
        输入:
        s = "acdcb"
        p = "a*c?b"
        输出: false        
 * 
 * 
 */
public class LeetCode044_WildcardMatching {

    public static void main(String[] args) {
        LeetCode044_WildcardMatching solution = new LeetCode044_WildcardMatching();
        String s = "adceb";
        String p = "*a*b";

        boolean flag = solution.isMatch(s, p);
        System.out.println(flag);
    }
    
    public static boolean isMatch(String s, String p) {
        // 申请dp[][]表格，dp[i][j]表示 若s(0,i-1)与p(0,j-1)匹配，dp[i][j]=true，否则为false
        int len1 = s.length(), len2 = p.length();
        //辅助数组dp，dp[i][j]表示s(0~i-1)与p(0~j-1)子串是否完全匹配
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;//s为空字符串 && p为空字符串
        for(int i = 1; i <= len1; i++)
            dp[i][0] = false;//s不为空，p为空字符串
        for(int j = 1; j <= len2; j++)
            dp[0][j] = (p.charAt(j-1) == '*' && dp[0][j-1]);//s为空字符串，p不为空
     
        //需s和p完全匹配，外层循环对p进行遍历
        for(int j = 1; j <= len2; j++)
            for(int i = 1; i <= len1; i++){
                if(p.charAt(j-1) != '*')
                    //若p[j-1]不为*，需判断s(0~i-2)与p(0~j-2)是否匹配（即dp[i-1][j-1]），并且s[i-1]与p[j-1]匹配
                    dp[i][j] = dp[i-1][j-1] && (s.charAt(i-1) == p.charAt(j-1) || '?' == p.charAt(j-1));
                else
                    //若p[j-1]为*,需判断s(0~i-2)与p(0~j-1)是否匹配（当前*匹配s[i-1]及之前部分字符）
                    //或者判断s(0~i-1)与p(0~j-2)是否匹配(当前*匹配空字符串)
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
     
        return dp[len1][len2];
    }

}
