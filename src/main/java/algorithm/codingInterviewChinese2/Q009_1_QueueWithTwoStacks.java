package algorithm.codingInterviewChinese2;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数appendTail和deleteHead，分别完成在队列尾部插入节点和在队列头部删除节点的功能。
 */
public class Q009_1_QueueWithTwoStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // 栈1做插入
    public void appendTail(Integer num){
        s1.push(num);
    }

    /**
     * 栈2做删除
     * 比如s1压入1，2，3，栈顶是3
     * 队列是先进先出，1先进，所以1要先出
     * 把s1的元素依次弹出，并压入s2，3先入栈，1在栈顶
     * s2弹出1，就实现了1先出来
     * @return
     */
    public Integer deleteHead(){
        // 如果栈2为空，则把栈1元素全部弹出，压入栈2
        if (s2.isEmpty()){
            while (s1.size() > 0){
                s2.push(s1.pop());
            }
        }
        // 否则，弹出栈2 顶部元素
        return s2.pop();
    }
}
