package algo.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题意 ：给定一个字符串S和T，找出S中包含T所有字符的最小子串。
 *
 * 注意：题目中只说明包含T中所有字符，顺序任意。
 * 例如，S = “ADOBECODEBANC”，T = “ABC”，
 * 则满足题意的最小子串为“BANC”。当没有满足题意的子串时返回空字符串。
 *
 * 思路：采用滑动窗口，窗口有左右边界，先通过扩展右边界找出一个包含T中所有字符的子串，然后收缩左边界，
 * 直到不能再收缩。记录此时的子串。然后收缩左边界，继续扩展右边界，直到再找到满足要求的子串，和上次的
 * 进行比较，保存更小的子串。返回执行，直到右边界到达S串尾，且左边界不能再收缩。
 *
 */
public class LeetCode076_MinimumWindowSubstring {

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        LeetCode076_MinimumWindowSubstring solution = new LeetCode076_MinimumWindowSubstring();
        String win = solution.minWindow(S, T);
        
        System.out.println(win);

    }
    
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length())
            return "";
        // HashMap的key为t中各个字符，value为对应字符个数
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        // minLeft为最小窗口左下标，minLen为最小长度，count用来计数
        int minLeft = 0, minLen = s.length() + 1, count = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如果map.get(c)说明t中还有字符没有包含，计数器+1
                if (map.get(c) > 0){
                    count++;
                }
                map.put(c, map.get(c) - 1);
            }
            // 如果left到i中包含t中所有字符
            while (count == t.length()) {
                if (i - left + 1 < minLen) {
                    minLeft = left;
                    minLen = i - left + 1;
                }
                c = s.charAt(left);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0)
                        count--;
                }
                left++;
            }
        }
        if (minLen > s.length())
            return "";
 
        return s.substring(minLeft, minLeft + minLen);
    }

}
