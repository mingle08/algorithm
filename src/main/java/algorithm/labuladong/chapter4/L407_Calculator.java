package algorithm.labuladong.chapter4;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 实现计算器
 * 功能如下：
 * 1 输入一个字符串，可以包含+ - * / 数字、括号及空格，你的算法返回运算结果
 * 2 要符合运算法则，括号的优先级最高，先乘除后加减
 * 3 除号是整数除法，无论正负都向0取整（5/2=2, -5/2=-2）
 * 4 可以假定输入的算式一定合法，且计算过程不会出现整形溢出，不会出现除数为0的意外情况
 *
 * 比如输入如下字符串，算法返回9
 * 3 * (2 - 6 / (3 - 7))
 */
public class L407_Calculator {

    static Integer calculate(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
        }
        return helper(list);
    }

    private static Integer helper(LinkedList<Character> list) {
        Stack<Integer> stk = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录num前的符号，初始化为 +
        char sign = '+';
        while (!list.isEmpty()) {
            char c = list.removeFirst();
            // 如果是数字，连续读取出来，比如12，1要乘以10再加2
            if (isDigit(c))
                num = 10 * num + (c - '0');

            // 遇到左括号开始递归计算 num
            if (c == '(')
                num = helper(list);

            // 如果不是数字，就是遇到了下一个符号，之前的数字和符号就要存进栈中
            if ((!isDigit(c) && c != ' ') || list.size() == 0) {
                int pre;
                switch (sign) {
                    case '+':
                        stk.push(num);
                        break;
                    case '-':
                        stk.push(-num);
                        break;
                    // 只要拿出前一个数字做对应运算即可
                    case '*':
                        pre = stk.pop();
                        // 把乘法的结果push入栈
                        stk.push(pre * num);
                        break;
                    case '/':
                        pre = stk.pop();
                        stk.push(pre / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }

            // 遇到右括号返回递归结果
            if (c == ')')
                break;
        }

        // 将栈中所有结果求和就是答案
        return sum(stk);
    }

    private static boolean isDigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    private static Integer sum(Stack<Integer> stack) {
        Integer res = 0;
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "1 - 12 + 3";
        Integer res = calculate(str);
        System.out.println(res);

        String str2 = "3 * (4 - 5 / 2) - 6";
        res = calculate(str2);
        System.out.println(res);

        String str3 = "3 * (2 - 6 / (3 - 7))";
        res = calculate(str3);
        System.out.println(res);
    }
}
