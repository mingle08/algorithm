package algorithm.codingInterviewChinese2;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
 */
public class Q048_LongestSubstringWithoutDup {

    Integer find(String s) {
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
                // d是将要移出窗口的字符
                char d = S[left];
                // 右移窗口
                left++;
                /**
                  逐个删除d，收缩窗口，直到把重复的那个字符移出窗口
                  并不是每个d都是重复字符，直到找到那个重复字符并删除
                  因为是c个数大于1，c可能在中间，不在窗口最左边，移出窗口的是d，并不都是等于c
                 */
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args){
        Q048_LongestSubstringWithoutDup solution = new Q048_LongestSubstringWithoutDup();
        String str = "arabcacfr";
        int res = solution.find(str);
        System.out.println(res);
    }
}
