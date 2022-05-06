package algorithm.leetCode;

import algorithm.dataStruct.ListNode;

/**
 * Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class LeetCode019_RemoveNthNodeFromEnd {

    public ListNode removeFromEnd(ListNode head, int n){
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;

        // 找到第n个节点
        for (int i = 0; i < n + 1 ; i++) {
            fast = fast.next;
        }

        if(fast == null){
            head = head.next;
            return head;
        }

        // slow 与 fast相差 n个节点
        // 当fast.next为null时，slow在倒数第n个位置上
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args){



    }
}
