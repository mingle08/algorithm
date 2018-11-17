package algo.leetCode;

import java.util.Stack;

public class Q032_LongestValidParentheses {

    public static int longestValidParentheses(String str) {
        int result = 0;
        Stack<Character> stack1 = new Stack<Character>();
        Stack<Integer> stack2 = new Stack<Integer>();
        for (int i = 0; i < str.length(); i++) {
            char sub = str.charAt(i);
            // 匹配操作
            if (!stack1.isEmpty() && stack1.peek() == '(' && sub == ')') {
                stack1.pop();
                stack2.pop();
            } else {
                stack1.push(sub);
                // 更新最长子串
                if (stack2.isEmpty()) {
                    result = Math.max(result, i);
                } else if (i - stack2.peek() - 1 > 0) {
                    result = Math.max(result, i - stack2.peek() - 1);
                }
                stack2.push(i);
            }
        }

        if (!stack2.isEmpty()) {
            result = Math.max(result, str.length() - stack2.peek() - 1);
        } else {
            result = str.length();
        }

        return result;

    }
}
