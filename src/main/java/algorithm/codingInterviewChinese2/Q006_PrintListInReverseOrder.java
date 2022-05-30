package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;
import algorithm.util.MyLinkList;

import java.util.Stack;

/**
 * 从尾到头打印链表
 * 使用栈
 */
public class Q006_PrintListInReverseOrder {

    /**
     * 方法1：循环
     * 只是逆序打印链表，并没有反转链表，链表没有改变
      */
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

    /**
     * 方法2：使用递归
     * 只是逆序打印链表，并没有反转链表，链表没有改变
      */ 
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

    /**
     * 方法3 反转链表：递归
     * 链表中节点的前后关系被反转，头节点变尾节点
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        // 当递归到最后一个节点的时候，由于head.next == null，于是递归终止，返回上一层
        if (head == null || head.next == null)
            return head;
        ListNode last = reverse(head.next);
        /*
        1 -> 2 -> 3 -> 4 -> 5 -> 6
        last为6时，head为5，
        head.next是6，head.next.next就是6.next，本来是null，被赋值为5，就是向后的指针，改为向前指。
        也可以说，5.next就是6，经过head.next.next = head之后，得到6.next指向5，即 5 -> 6被改为 5 <- 6
        完成了节点的反转
         */
        head.next.next = head;
        // 取消原来指向后面的指针
        head.next = null;
        return last;
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

        System.out.println();
        ListNode newHead = solution.reverse(link.head);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }
}
