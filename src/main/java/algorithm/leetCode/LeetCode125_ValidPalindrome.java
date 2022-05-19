package algorithm.leetCode;

/**
 * 判读一个字符串是否是回文字符串（只判断期中的字符和数字）。
 */
public class LeetCode125_ValidPalindrome {

    public boolean isPanlindrome(String str){
        if (str == null)
            return false;

        char[] S = str.toLowerCase().toCharArray();
        int len = S.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            if (!(S[left] >= '0' && S[left] <= '9') || !(S[left] >= 'a' && S[left] <= 'z'))
                left++;
            else if (!(S[right] >= '0' && S[right] <= '9') || !(S[right] >= 'a' && S[right] <= 'z'))
                right--;
            else if (S[left] == S[right]){
                left++;
                right--;
            } else
                return false;
        }
        return true;
    }

    public static void main(String[] args){
        LeetCode125_ValidPalindrome solution = new LeetCode125_ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";
        boolean flag = solution.isPanlindrome(str);
        System.out.println(flag);
    }
}
