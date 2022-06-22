package algorithm.labuladong.chapter3;

import algorithm.util.ListNode;

public class L309_PalindromeLink {

    boolean isPalindrome(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow指针现在指向链表中点
        if (fast != null)
            slow = slow.next;

        ListNode left = head;
        // 反转从slow到尾节点，得到的right是原来的尾节点，只不过指针向前
        ListNode right = reverse(slow);
        while (right != null) {
            if (left.val != right.val)
                return false;

            left = left.next;
            right = right.next;
        }
        return true;
    }

    //
    ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
        }
        return pre;
    }
}
