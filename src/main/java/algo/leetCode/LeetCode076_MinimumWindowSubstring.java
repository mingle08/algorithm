package algo.leetCode;

import java.util.HashMap;
import java.util.Map;

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
