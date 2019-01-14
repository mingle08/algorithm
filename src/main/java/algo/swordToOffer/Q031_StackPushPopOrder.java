package algo.swordToOffer;

import java.util.Stack;

public class Q031_StackPushPopOrder {
    public static boolean isPopOrder(int [] pushA,int [] popA) {
        if(pushA == null || popA == null)
            return false;
        Stack<Integer> stack = new Stack<Integer>();
        //必须提前判断长度是否相等
        if(popA.length != pushA.length || pushA.length == 0)
            return false;
        int popIndex=0;
        for(int pushIndex = 0; pushIndex < pushA.length; pushIndex++) {
            stack.push(pushA[pushIndex]);
            while(!stack.empty() && stack.peek() == popA[popIndex]) {
                stack.pop();
                popIndex++;
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
