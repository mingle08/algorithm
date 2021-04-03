package algo.codingInterviewChinese2;

import algo.util.ListNode;
import algo.util.MyLinkList;

/**
 *  反转链表：单向链表，反转是指前后关系反转，头节点变尾节点，尾节点变头节点，
 *  并不是反向打印链表
 *   a -> b -> c -> d -> e
 *   a <- b <- c <- d <- e
 */
public class Q024_ReverseNodeList {

    public ListNode reverseList(ListNode head){
        ListNode reverseHead = null;
        ListNode curr = head;
        ListNode pre = null;
        ListNode pNext = null;
        while (curr != null){ // 假设是头节点 a
            pNext = curr.next;  // 下一个节点是 b
            if (pNext == null)
                reverseHead = curr;

            curr.next = pre;    // 头指针的下一个节点指向前一个节点

            pre = curr;  // 前一个节点是 a
            curr = pNext;  // 头指针移动到 b，至此 b 指向 a
        }

        return reverseHead;
    }

    public static void main(String[] args){
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
