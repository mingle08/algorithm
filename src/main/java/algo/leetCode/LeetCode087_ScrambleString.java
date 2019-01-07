package algo.leetCode;

public class LeetCode087_ScrambleString {

    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length() != s2.length())
            return false;
        int len = s1.length();
        int[] letters = new int[26];
        for(int i = 0; i < len; i++){
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(letters[i] != 0){
                return false;
            }
        }

        /**
         * s1和s2的前i个字符区域和后len-i个字符区域比较 (其实就是这两个节点没有进行交换)
         * 或者s1的i个字符与s2的后k个字符比较 以及s1的后len-i个字符和s2的前len-i字符比较 (这两个节点进行了交换)
         * 只要有一种状态成立即可。
         */
        for(int i = 1; i < len; i++){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)) ){
                return true;
            } if(isScramble(s1.substring(0, i), s2.substring(len - i)) && isScramble(s1.substring(i), s2.substring(0, len - i)) ){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        LeetCode087_ScrambleString solution = new LeetCode087_ScrambleString();

        String s1 = "great";
        String s2 = "rgeat";
//        String s1 = "abcde";
//        String s2 = "caebd";

        boolean flag = solution.isScramble(s1, s2);
        System.out.println(flag);
    }
}