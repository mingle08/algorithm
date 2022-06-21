package algorithm.labuladong.chapter5;

/**
 * 双指针，从中间向两边开花
 */
public class L506_LongestPalindrome {

    String longestPalindrome(String str) {
        // 初始化为原字符串第一个字母
        String res = str.substring(0, 1);
        int maxLength = 1;
        for (int i = 0; i < str.length(); i++) {
            // 奇数
            String s1 = palindrome(str, i, i);
            // 偶数
            String s2 = palindrome(str, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    String palindrome(String s, int left, int right) {
        int len = s.length();
        // 把left, right初始值赋值给i，j
        int i = left, j = right;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        // 不能取 i，不能取 j
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        L506_LongestPalindrome palindrome = new L506_LongestPalindrome();
        String s = "acaba";
        String res = palindrome.longestPalindrome(s);
        System.out.println(res);
    }
}
