package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;
import algorithm.util.MyLinkList;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * 使用栈
 */
public class Q006_PrintListInReverseOrder {

    // 方法1：循环
    public void printListReversingly_Iteratively(ListNode node){
        Stack<ListNode> stack = new Stack<>();

        while (node != null){
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()){
            node = stack.pop();
            System.out.print(node.val + " ");
        }
    }

    // 方法2：使用递归
    public void printListReversingly_Recursively(ListNode node) {
        if (node != null) {
            if (node.next != null) {
                printListReversingly_Recursively(node.next);
            }
            /*
             第一次调用这一句，是最后一个节点，它的next节点是null
             然后因为执行完成，返回递归的上一层，这时上一层已经执行完33行，于是向下执行这一句
             因为执行完成，返回递归的上一层……
             不断返回上一层递归，就逆向打印了链表
             */
            System.out.print(node.val + " ");
        }
    }

    public static void main(String[] args){
        Q006_PrintListInReverseOrder solution = new Q006_PrintListInReverseOrder();

        MyLinkList link = new MyLinkList();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);

        solution.printListReversingly_Iteratively(link.head);
        System.out.println();
        solution.printListReversingly_Recursively(link.head);


    }
}
