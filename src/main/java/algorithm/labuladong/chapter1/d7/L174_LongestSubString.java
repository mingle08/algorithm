package algorithm.labuladong.chapter1.d7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最长无重复子串
 * 输入一个字符串s，请计算s中不包含重复字符的最长子串长度
 * 比如，输入s = "aabab"，算法返回2，因为无重复的最长子串是"ab"或者"ba"，长度为2。
 */
public class L174_LongestSubString {
    static Integer find(String s) {
        Map<Character, Integer> window = new HashMap<>();
        char[] S = s.toCharArray();

        int left = 0, right = 0;

        int res = 0;
        while (right < s.length()) {
            // c是将要移入窗口的字符
            char c = S[right];
            // 右移窗口
            right++;

            // 进行窗口内数据的一系列操作
            window.put(c, window.getOrDefault(c, 0) + 1);

            // 判断左侧窗口是否要收缩
            while (window.get(c) > 1) {
                // 右移窗口
                left++;
                window.put(c, window.get(c) - 1);
            }

            res = (right - left > res) ? right - left : res;
        }

        return res - 1;
    }


    public static int lengthOfLongestSubstring(String s) {
        int max = 0, temp = 0, i = 0, j = 0;
        int length = s.length();
        Set<Character> set = new HashSet<>();	//滑动窗口的 set 解法

        //用窗口来进行优化
        while(i < length && j < length) {
            //窗口是一个 [start, end]，则 j 是 end，i 是start
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = (j - i > max) ? j - i : max;
            } else {	//移动 start，是一步一步移动的！
                set.remove(s.charAt(i));
                i++;
            }

        }

        return max;
    }



    public static void main(String[] args) {
        String s = "arabcacfr";
        System.out.println(find(s) + ", " + lengthOfLongestSubstring(s));
    }
}
