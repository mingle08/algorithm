package algorithm.codingInterviewChinese2;

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
        // 那就真的需要一个栈来模拟压入和弹出
        Stack<Integer> stack = new Stack<Integer>();
        //必须提前判断长度是否相等
        if(popArr.length != pushArr.length || pushArr.length == 0) {
            return false;
        }
        // 记录弹出序列的下标
        int popIndex=0;
        for (int i : pushArr) {
            // 每压入一个数字，就判断是不是要弹出
            stack.push(i);
            // 因为不知道压入的数字什么时候弹出，只能每压入一个就跟弹出序列比较，判断是不是要弹出
            while (!stack.empty() && stack.peek() == popArr[popIndex]) {    // 弹出的下标
                stack.pop();
                popIndex++;    // 弹出的下标
            }
        }
        // 最后判断栈是否为空
        return stack.empty();
    }

    public static void main(String[] args){
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {4, 5, 3, 2, 1};
        int[] a3 = {4, 3, 5, 1, 2};

        boolean isPopOrder = isPopOrder(a1, a2);
        System.out.println(isPopOrder);
        boolean isPopOrder2 = isPopOrder(a1, a3);
        System.out.println(isPopOrder2);
    }

}
