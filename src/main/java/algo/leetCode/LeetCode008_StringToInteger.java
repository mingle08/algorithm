package algo.leetCode;

/**
 * intput: "42"                output:  42
 *         "   -42"                      -42
 *         "4193 with words"            4193
 *         "words with 987"             0
 *         "-91283472332"               -2147483648
 */
public class LeetCode008_StringToInteger {

    public static int atoi(String str){
        if(str == null || str.length() < 1){
            return 0;
        }
        // 1. 去掉空格
        str = str.trim();

        // 2. 确定正负号
        int i = 0;   // index of the str
        char flag = '+';
        if(str.charAt(0) == '-'){
            flag = '-';
            i++;
        } else if(str.charAt(0) == '+'){
            flag = '+';
            i++;
        }

        // 3. 如果是数字就计算
        double res = 0;
        while(str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            res = res * 10 + str.charAt(i) - '0';
            i++;
        }

        if(flag == '-') res = -1 * res;
        if(res > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(res < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)res;

    }

    public static void main(String[] args){
        System.out.println(atoi("42"));
        System.out.println(atoi("    -42"));
        System.out.println(atoi("4193 with words"));
        System.out.println(atoi("words and 987"));
        System.out.println(atoi("-91283472332"));

    }
}
