package algo.codingInterviewChinese2;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 题目：输入2个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列{1,2,3,4,5}是某栈的压栈序列，序列{4,5,3,2,1}是
 * 该序列的一个弹出序列，但{4,3,5,1,2} 就不可能是该压栈序列的弹出序列
 */
public class Q031_StackPushPopOrder {
    // 压入序列 pushArr，弹出序列 popArr
    public static boolean isPopOrder(int[] pushArr,int[] popArr) {
        if(pushArr == null || popArr == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        //必须提前判断长度是否相等
        if(popArr.length != pushArr.length || pushArr.length == 0) {
            return false;
        }
        int popIndex=0;
        for (int i : pushArr) {    // 压入的下标
            stack.push(i);    // 压入的下标
            while (!stack.empty() && stack.peek() == popArr[popIndex]) {    // 弹出的下标
                stack.pop();
                popIndex++;    // 弹出的下标
            }
        }
        return stack.empty();
    }

    public static void main(String[] args){
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4, 5, 3, 2, 1};

        boolean isPopOrder = isPopOrder(a1, a2);
        System.out.println(isPopOrder);
    }

}
