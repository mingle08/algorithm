package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;
import algorithm.util.MyLinkList;

/**
 * 反转链表：单向链表，反转是指前后关系反转，头节点变尾节点，尾节点变头节点，
 * 并不是反向打印链表
 * a -> b -> c -> d -> e
 * a <- b <- c <- d <- e
 */
public class Q024_ReverseNodeList {

    /**
     * 方法1 循环
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode curr = head;
        ListNode pre = null;
        ListNode pNext = null;

        while (curr != null) {
            /**
             * 1，保存下一个节点
             */
            // 下一个节点
            pNext = curr.next;
            // 反转链表的头部不断往后移
            if (pNext == null)
                reverseHead = curr;

            /**
             * 2，反转链表
             */
            curr.next = pre;

            /**
             * 3，向后移动
             */
            // 前一个节点后移至当前节点
            pre = curr;
            // 当前节点后移至原来的下一个节点
            curr = pNext;
        }

        return reverseHead;
    }

    /**
     * 方法2 递归
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

    public static void main(String[] args) {
        Q024_ReverseNodeList solution = new Q024_ReverseNodeList();
        MyLinkList link = new MyLinkList();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(4);
        link.add(5);
        ListNode reverseHead = solution.reverseList(link.head);

        System.out.println(reverseHead.val);
    }

}
