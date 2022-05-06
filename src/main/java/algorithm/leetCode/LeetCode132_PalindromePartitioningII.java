package algorithm.leetCode;


public class LeetCode132_PalindromePartitioningII {

    /**
     * 解题思路：动态规划问题。
     *   dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。（0,i）的子串中包括了i+1个字符。
     *  分几种情况：
     *   1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
     *   2.对于任意大于1的i，如果s.substring(j,i+1)( 1 =< j <=  i ,即遍历i之前的每个子串)是回文时，dp[i] = min(dp[i], dp[j-1]+1);
     *    (注：j不用取0是因为若j == 0，则又表示判断（0，i）)。
     */
    public int minCut(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        //dp[i]存放(0,i)即以i的字符结束的子串的最小切割数，则所求为dp[s.length()-1];
        dp[0] = 0;//一个字符，不需要切割
        for(int i = 1; i < s.length(); i++)
        {
            //dp[i]赋初值
            dp[i] = is_palindrome(s.substring(0,i+1)) ? 0 : i+1;
            //  1=<j<=i的子串回文判定
            for(int j = i; j >= 1; j--)
            {
                if(is_palindrome(s.substring(j,i+1)))
                {
                    dp[i] = Math.min(dp[i],dp[j-1]+1);
                }
            }
        }
        return dp[s.length()-1];
    }
    //判断回文串例程
    private boolean is_palindrome(String s)
    {
        int begin = 0;
        int end = s.length()-1;
        while(begin < end)
        {
            if(s.charAt(begin) != s.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }

    /**
     * 求所有回文子串时，dp[i][j]保存从i到j是否是回文子串 dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
     *
     * count[i]表示从i到最后得最少划分次数count[i]=min(1+count[j+1])(dp[i][j]=true);
     * @param s
     * @return
     */
    public int minCut2(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int i = s.length()-1; i >= 0; i--)
        {
            for(int j = i; j < s.length(); j++)
            {
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1] == 1))
                {
                    dp[i][j] = 1;
                }
            }
        }

        int[] count = new int[s.length()+1];

        for(int i = s.length()-1; i >= 0; i--)
        {
            count[i] = Integer.MAX_VALUE;
            for(int j = i; j < s.length(); j++)
            {
                if(dp[i][j] == 1)
                {
                    count[i] = Math.min(1+count[j+1],count[i]);
                }
            }
        }

        return count[0]-1;
    }

    public static void main(String[] args){
        LeetCode132_PalindromePartitioningII solution = new LeetCode132_PalindromePartitioningII();
        String str = "aab";
        int count = solution.minCut2(str);
        System.out.println(count);
    }
}
