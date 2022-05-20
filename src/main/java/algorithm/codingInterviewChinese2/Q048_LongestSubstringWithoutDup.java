package algorithm.codingInterviewChinese2;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
 */
public class Q048_LongestSubstringWithoutDup {

    public int maxLength(String str){
        if (str == null || str.length() == 0)
            return 0;

//        int preLength = 0;  // f(i-1)
        int curLength = 0;  // f(i)
        int maxLength = 0;
        int[] pos = new int[26];
        for (int i = 0; i < 26; i++)
            pos[i] = -1;

        for (int k = 0; k < str.length(); k++) {
            int letterVal = str.charAt(k) - 'a';
            if (pos[letterVal] < 0 || k - pos[letterVal] > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength)
                    maxLength = curLength;

                curLength = k - pos[letterVal];
            }
            pos[letterVal] = k;
        }

        if (curLength > maxLength)
            maxLength = curLength;

        return maxLength;
    }

    public int maxLength2(String str){
        if (str == null || str.length() == 0)
            return 0;

        int[] lastPos = new int[26];
        for (int i = 0; i < 26; i++)
            lastPos[i] = -1;

        char[] S = str.toCharArray();
        int i = -1;
        int res = 0;
        for (int k = 0; k < S.length; k++) {
            // 字母在26个字母中的位置，下标从0开始计算
            int j = S[k] - 'a';

            // 如果重复出现，i更新到新出现的位置
            if (lastPos[j] > -1) {
//                i = Math.max(i, lastPos[j]);
                if (lastPos[j] > i) i = lastPos[j];
            }
            // 记录当前字母出现的位置
            lastPos[j] = k;
            res = Math.max(res, k - i);
        }

        return res;
    }

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

                window.put(c, window.get(c) - 1);
            }
            res = Math.max(res, right - left);
        }

        return res;
    }

    public static void main(String[] args){
        Q048_LongestSubstringWithoutDup solution = new Q048_LongestSubstringWithoutDup();
        String str = "arabcacfr";
        int cnt = solution.maxLength2(str);
        int res = solution.find(str);
        System.out.println(cnt + ", " + res);
    }
}
