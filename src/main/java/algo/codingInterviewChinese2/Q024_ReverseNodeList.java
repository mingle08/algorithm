package algo.codingInterviewChinese2;

import algo.util.ListNode;
import algo.util.MyLinkList;

/**
 * 反转链表：单向链表，反转是指前后关系反转，头节点变尾节点，尾节点变头节点，
 * 并不是反向打印链表
 * a -> b -> c -> d -> e
 * a <- b <- c <- d <- e
 */
public class Q024_ReverseNodeList {

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
