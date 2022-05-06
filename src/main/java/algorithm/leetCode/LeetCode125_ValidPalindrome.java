package algorithm.leetCode;

/**
 * 判读一个字符串是否是回文字符串（只判断期中的字符和数字）。
 */
public class LeetCode125_ValidPalindrome {

    public boolean isPanlindrome(String str){
        if (str == null)
            return false;

        char[] chs = str.toLowerCase().toCharArray();
        int len = chs.length;
        int left = 0;
        int right = len - 1;
        while (left < right){
            if (!(chs[left] >= '0' && chs[left] <= '9') || !(chs[left] >= 'a' && chs[left] <= 'z'))
                left++;
            else if (!(chs[right] >= '0' && chs[right] <= '9') || !(chs[right] >= 'a' && chs[right] <= 'z'))
                right--;
            else if (chs[left] == chs[right]){
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
