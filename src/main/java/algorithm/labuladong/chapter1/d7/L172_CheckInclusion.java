package algorithm.labuladong.chapter1.d7;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入2个字符串S和T，请用算法判断S是否包含T的全排列，也就是要判断S中是否存在一个子串是T的一种全排列
 *
 */
public class L172_CheckInclusion {
    static boolean checkInclusion(String s, String t) {
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
            while (right - left >= t.length()) {
                // 在这里更新最小覆盖子串
                if (valid == need.size())
                    return true;
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
        // not found
        return false;
    }

    public static void main(String[] args) {
        String s = "helloworld";
        String t = "oow";
        boolean flag = checkInclusion(s, t);
        if (flag)
            System.out.println("bingo");
    }
}
