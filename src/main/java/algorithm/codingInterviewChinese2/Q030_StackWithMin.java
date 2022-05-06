package algorithm.codingInterviewChinese2;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 在该栈中，调用min、push以及pop的时间复杂度都是O(1)。
 *
 * 思路：维护一个辅助栈，存入最小元素和次小元素
 */
public class Q030_StackWithMin {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    // stack,minStack同步push
    public void push(int num){
        stack.push(num);
        if (num < min())
            minStack.push(num);
        else
            minStack.push(min());
    }

    // stack, minStack同步pop
    public int pop(){
        int val = stack.pop();
        minStack.pop();
        return val;
    }

    public int min(){
        if (minStack.isEmpty())
            return 0;

        return minStack.peek();
    }

    public static void main(String[] args){
        Q030_StackWithMin solution = new Q030_StackWithMin();
        int[] arr = {3, 4, 2, 1};
        for (int num : arr){
            solution.push(num);
            System.out.println(solution.min());
        }
        // 连续二次栈顶
        for (int i=0; i < 2; i++){
            solution.pop();
            System.out.println(solution.min());
        }

        // 压入0
        solution.push(0);
        System.out.println(solution.min());

    }
}
