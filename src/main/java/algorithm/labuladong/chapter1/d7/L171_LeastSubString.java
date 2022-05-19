package algorithm.labuladong.chapter1.d7;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串
 * 给定2个字符串S和T，请你在S中找到包含T中全部字母的最短子串。
 * 如果S中没有这样的子串，返回空串；如果存在这样的子串，则返回该子串
 *
 * 滑动窗口算法的思想：
 * 1，在字符串S中使用双指针中的左右指针技巧，初始化left = right = 0，把索引左闭右开区间[left, right)称为一个窗口
 * 2，先不断增加right指针扩大窗口[left, right)，直到窗口中的字符串符合要求（包含了T中的所有字符）
 * 3，此时，停止增加right，转而不断增加left指针缩小窗口[left, right)，直到窗口中的字符串不再符合要求（不包含T的所有字符了）。
 * 同时，每次增加left，我们都要更新一轮结果。
 * 4，重复第2和第3步，直到right到达字符串S的尽头。
 *
 * 第2步相当于在找一个"可行解"，然后第3步在优化这个"可行解"，最终找到最优解
 */
public class L171_LeastSubString {
    static String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        for (char ch : T) {
            // Map中的getOrDefault方法，是1.8开始有的
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c是将要移入窗口的字符
            char c = S[right];
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列操作
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c) == need.get(c))
                    valid++;
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d是将要移出窗口的字符
                char d = S[left];
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
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = "EBBANCF";
        String t = "ABC";
        String res = minWindow(s, t);
        System.out.println(res);
    }

}
