package algo.swordToOffer;

import algo.util.ListNode;
import algo.util.MyLinkList;

/**
 *   a -> b -> c -> d -> e
 *   a <- b <- c <- d <- e
 */
public class Q024_ReverseNodeList {

    public ListNode reverseList(ListNode head){
        ListNode reverseHead = null;
        ListNode pNode = head;
        ListNode pre = null;
        while (pNode != null){ // 假设是头节点 a
            ListNode pNext = pNode.next;  // 下一个节点是 b
            if (pNext == null)
                reverseHead = pNode;

            pNode.next = pre;    // 头指针的下一个节点指向前一个节点

            pre = pNode;  // 前一个节点是 a
            pNode = pNext;  // 头指针移动到 b，至此 b 指向 a
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
