package algo.swordToOffer;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class Q09_QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void appendTail(Integer num){
        stack2.push(num);
    }

    public Integer deleteHead(){
        if (stack2.isEmpty()){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
