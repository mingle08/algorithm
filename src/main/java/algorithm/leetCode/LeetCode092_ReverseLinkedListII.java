package algorithm.leetCode;

import algorithm.util.ListNode;
import algorithm.util.MyLinkList;

/**
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * 先拿到left-1处的节点，right节点，然后都断开；
 * 反转left到right的链表
 * 重新连接
 */
public class LeetCode092_ReverseLinkedListII {

    public ListNode reverse(ListNode head, int left, int right){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode h = dummy;
        // 从dummy开始，到达left的前驱节点
        for (int a = 0; a < left - 1; a++) {
            h = h.next;
        }
        ListNode leftNode = h.next;
        ListNode rightNode = leftNode;
        // 从left开始，到达right节点
        for (int b = 0; b < right - left; b++) {
            rightNode = rightNode.next;
        }

        // 最后一段的头节点
        ListNode last = rightNode.next;
        // 截断
        h.next = null;
        rightNode.next = null;

        // 反转leftNode到rightNode的链表
        reverseNode(leftNode);
        // rightNode是头，leftNode是尾
        h.next = rightNode;
        leftNode.next = last;

        return dummy.next;

    }

    private void reverseNode(ListNode node) {
        ListNode pre = null, cur = node;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
    }

    public static void main(String[] args){
        LeetCode092_ReverseLinkedListII solution = new LeetCode092_ReverseLinkedListII();

        MyLinkList linkList = new MyLinkList();
        linkList.add(1);
        linkList.add(2);
        linkList.add(3);
        linkList.add(4);
        linkList.add(5);

        ListNode node = solution.reverse(linkList.head, 2, 4);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
}
