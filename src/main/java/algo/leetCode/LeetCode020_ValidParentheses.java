package algo.leetCode;

import java.util.Stack;

/**
 *  Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


 */
public class LeetCode020_ValidParentheses {
    public static boolean isValid(String str){
        if(str.length() == 0 || str.length() == 1){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                stack.push(str.charAt(i));
            }else{
                if (stack.size() == 0)
                    return false;
                char top = stack.pop();
                if (str.charAt(i) == ')'){
                    if (top != '(')
                        return false;
                } else if (str.charAt(i) == '}'){
                    if (top != '{')
                        return false;
                } else if (str.charAt(i) == ']'){
                    if (top != '[')
                        return false;
                }

            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args){
//        String str1 = "()";
//        String str2 = "(]";
//        boolean flag = isValid(str2);
//        System.out.println(flag);
//        String str3 = "()[]{}";
//        String str4 = "([)]";
        String str5 = "{[]}";
        boolean flag = isValid(str5);
        System.out.println(flag);
//
//        System.out.println(str1 + " " + isValid(str1));
//        System.out.println(str2 + " " + isValid(str2));
//        System.out.println(str3 + " " + isValid(str3));
//        System.out.println(str4 + " " + isValid(str4));
//        System.out.println(str5 + " " + isValid(str5));
    }
}
