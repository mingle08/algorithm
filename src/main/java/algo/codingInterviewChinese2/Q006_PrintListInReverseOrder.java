package algo.codingInterviewChinese2;

import algo.util.ListNode;
import algo.util.MyLinkList;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * 使用栈
 */
public class Q006_PrintListInReverseOrder {

    public void printListReversely(ListNode node){
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

    public static void main(String[] args){
        Q006_PrintListInReverseOrder solution = new Q006_PrintListInReverseOrder();

        MyLinkList link = new MyLinkList();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);

        solution.printListReversely(link.head);


    }
}
