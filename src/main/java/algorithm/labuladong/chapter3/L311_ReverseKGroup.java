package algorithm.labuladong.chapter3;

import algorithm.util.ListNode;

public class L311_ReverseKGroup {
    
    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间[a, b)包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足k个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 反转区间[a, b)的元素，注意是左闭右开
     * 把反转整个链表的循环写法，修改2处：
     * （1）增加了方法参数 ListNode b
     * （2）while循环的条件，cur != b
     */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, next;
        pre = null; cur = a; next = a;
        // while 终止条件改一下就行
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 返回反转后的头节点
        return pre;

    }
}
