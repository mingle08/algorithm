package algorithm.codingInterviewChinese2;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：请实现一个函数用来判断字符串是在表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是
 */
public class Q020_NumericStrings {

    // TODO
    public static boolean isNumeric(char[] str) {
        int index = 0;
        if (str == null || str.length == 0) {
            return false;
        }
        boolean numeric = scanInteger(str, index);

        //判断小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            numeric = scanUnsignedInteger(str, index) || numeric;
        }
        //判断指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            numeric = numeric && scanInteger(str, index);
        }
        return numeric && index >= str.length;

    }

    //扫描无符号的整数
    public static boolean scanUnsignedInteger(char[] str, int index) {
        int before = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > before;
    }

    //扫描可能以表示正负的'+'或者'-'为起始的0~9的数位
    public static boolean scanInteger(char[] str, int index) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str, index);
    }


    // 状态机
    public boolean isNumber(String s) {
        Map<Character, Integer>[] states = new HashMap[]{//状态信息
                new HashMap<Character, Integer>() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }}, // 0.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 4);
                }},                           // 1.
                new HashMap<Character, Integer>() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }}, // 2.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},              // 3.
                new HashMap<Character, Integer>() {{
                    put('d', 3);
                }},                                        // 4.
                new HashMap<Character, Integer>() {{
                    put('s', 6);
                    put('d', 7);
                }},                           // 5.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                }},                                        // 6.
                new HashMap<Character, Integer>() {{
                    put('d', 7);
                    put(' ', 8);
                }},                           // 7.
                new HashMap<Character, Integer>() {{
                    put(' ', 8);
                }}                                         // 8.
        };
        char[] cs = s.toCharArray();
        int cur = 0;//当前状态
        char t;
        for (char c : cs) {
            if (c >= '0' && c <= '9') t = 'd';
            else if (c == '+' || c == '-') t = 's';
            else if (c == 'e' || c == 'E') t = 'e';
            else if (c == '.' || c == ' ') t = c;
            else t = '?';

            Integer next = states[cur].get(t);
            if (next == null) {
                return false;
            }
            cur = next;
        }
        return cur == 2 || cur == 3 || cur == 7 || cur == 8;
    }


}
