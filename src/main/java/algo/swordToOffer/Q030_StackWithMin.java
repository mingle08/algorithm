package algo.swordToOffer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。在该栈中，调用min、push以及pop的时间复杂度都是O(1)。
 */
public class Q030_StackWithMin {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    // stack1,stack2同步push
    public void push(int num){
        stack1.push(num);
        if (num < min())
            stack2.push(num);
        else
            stack2.push(min());
    }

    // stack1, stack2同步pop
    public int pop(){
        int val = stack1.pop();
        stack2.pop();
        return val;
    }
    public int peek(){
        return stack1.peek();
    }

    public int min(){
        if (stack2.isEmpty())
            return Integer.MAX_VALUE;

        return stack2.peek();
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
