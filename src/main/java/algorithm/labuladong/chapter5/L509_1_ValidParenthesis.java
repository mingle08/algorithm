package algorithm.labuladong.chapter5;

import java.util.Stack;

public class L509_1_ValidParenthesis {

    /**
     * 处理一种括号
     * ch是(, [, {中的一种
     * @param str
     * @param ch
     * @return
     */
    static boolean isValid(String str, char ch) {
        char[] S = str.toCharArray();
        int left = 0;
        for (char c : S) {
            if (c == ch) {
                left++;
            } else {
                left--;
            }
            if (left < 0)
                return false;
        }

        return left == 0;
    }

    /**
     * 处理多种括号
     */
    static boolean isValid2(String str) {
        char[] S = str.toCharArray();
        Stack<Character> left = new Stack<>();
        for (char c : S) {
            if (c == '(' || c == '[' || c == '{') {
                left.push(c);
            } else {
                // 字符c是右括号
                if (!left.empty() && leftOf(c) == left.peek())
                    left.pop();
                else
                    return false;
            }
        }
        // 是否所有的左括号都被匹配了
        return left.empty();
    }

    private static char leftOf(char ch) {
        if (ch == ')') return '(';
        if (ch == ']') return '[';
        return '{';
    }

}
