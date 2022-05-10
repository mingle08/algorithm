package algorithm.labuladong.chapter1.d7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串S和一个非空字符串T，找到S中所有是T的字母异位词的子串，返回这些子串的起始索引
 *
 * 字母异位词，就是全排列
 * 比如输入S = "cbaebabacd", T = "abc"，算法返回[0, 6]，
 * 因为S中两个子串"cba"和"bac"是T的排列，它们的起始索引是0和6
 */
public class L173_FindAnagrams {
    static List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        for (char ch : cht) {
            // Map中的getOrDefault方法，是1.8开始有的
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;

        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            // c是将要移入窗口的字符
            char c = chs[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列操作
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == need.get(c))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (right - left >= t.length()) {
                // 当窗口符合条件时，把起始索引加入res
                if (valid == need.size())
                    res.add(left);
                // d是将要移出窗口的字符
                char d = chs[left];
                // 右移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d))
                        valid--;
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String S = "cbaebabacd", T = "abc";
        List<Integer> res = findAnagrams(S, T);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
