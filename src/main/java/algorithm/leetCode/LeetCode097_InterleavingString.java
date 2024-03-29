package algorithm.leetCode;

public class LeetCode097_InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int length1 = s1.length();
        int length2 = s2.length();
        int length3 = s3.length();
        if (length1 + length2 != length3){
            return false;
        }
        //声明一个二维数组dp[][];其中dp[i][j]表示s1在第个位置，s2在第j个位置，s3在遍历第i+j个位置。dp[0][0]为s1和s2都为空
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];
        //当s1不是empty，s2为empty时。只需比较当前遍历的位置s1的字串和s3的字串是否相等
        for (int i = 0; i <= length1; i++){
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i)) ? true : false;
        }
        //当s2不是empty，s1是empty时
        for (int j = 0; j <= length2; j++){
            dp[0][j] = s2.substring(0, j).equals(s3.substring(0, j)) ? true : false;
        }
        //当s1和s2都不是空时。有两种情况，一种是从（i-1,j）到达（i，j）位置，如果（i-1，j)已经是交叉的了，只需比较s1的第i个位置的元素与s3的第i+j个位置的元素是否相等；另一种情况同理。
        for (int i = 1; i <= length1; i++){
            for (int j = 1; j <= length2; j++){
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                        (dp[i][j-1] && s2.charAt(j - 1) == s3.charAt(i + j -1));
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
