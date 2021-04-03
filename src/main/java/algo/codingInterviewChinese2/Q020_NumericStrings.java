package algo.codingInterviewChinese2;

public class Q020_NumericStrings {

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
}
