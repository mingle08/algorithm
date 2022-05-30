package algorithm.codingInterviewChinese2;

/**
 * 题目：请实现一个函数用来判断字符串是在表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"及"-1E-16"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是
 */
public class Q020_NumericStrings {

    public static boolean isNumeric(char[] str) {
        int index = 0;
        if (str == null || str.length == 0) {
            return false;
        }
        boolean numeric = scanInteger(str, index);

        // 判断小数部分
        if (index < str.length && str[index] == '.') {
            index++;
            // 与上一步的结果numeric做||运算
            numeric = scanUnsignedInteger(str, index) || numeric;
        }
        // 判断指数部分
        if (index < str.length && (str[index] == 'e' || str[index] == 'E')) {
            index++;
            // 与上一步的结果numeric做&&运算
            numeric = numeric && scanInteger(str, index);
        }
        return numeric && index >= str.length;

    }

    // 扫描无符号的整数
    public static boolean scanUnsignedInteger(char[] str, int index) {
        int before = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }
        return index > before;
    }

    // 扫描可能以表示正负的'+'或者'-'为起始的0~9的数位
    public static boolean scanInteger(char[] str, int index) {
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUnsignedInteger(str, index);
    }

}
