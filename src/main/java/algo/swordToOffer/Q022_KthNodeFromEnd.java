package algo.swordToOffer;

import algo.util.ListNode;

/**
 * 链表中倒数第k个节点
 */
public class Q022_KthNodeFromEnd {

    public ListNode findKthNodeFromEnd(ListNode head, int k){
        ListNode ptrA = head;
        ListNode ptrB = null;
        // 先让A指针走 k-1 步
        for (int i = 0; i < k - 1; i++) {
            if (ptrA.next != null){
                ptrA = ptrA.next;
            } else {
                return null;
            }
        }

        ptrB = head;
        // 二个指针再一起走，当A指针走到最后一个节点，B指针停留的位置就是倒数K个节点
        while (ptrA.next != null) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return ptrB;
    }
}
