package algorithm.codingInterviewChinese2;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class Q009_1_QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // 栈1做插入
    public void appendTail(Integer num){
        stack1.push(num);
    }

    // 栈2做删除
    public Integer deleteHead(){
        // 如果栈2为空，则把栈1元素全部弹出，压入栈2
        if (stack2.isEmpty()){
            while (stack1.size() > 0){
                stack2.push(stack1.pop());
            }
        }
        // 否则，弹出栈2 顶部元素
        return stack2.pop();
    }
}
