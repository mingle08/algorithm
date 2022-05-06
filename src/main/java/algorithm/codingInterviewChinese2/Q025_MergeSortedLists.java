package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;

/**
 * 合并两个排序的链表
 * 题目：输入2个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Q025_MergeSortedLists {

    public static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        ListNode mergedHead = null;
        if (head1.val < head2.val) {
            // 二者相比，head1的值较小，作为头节点
            mergedHead = head1;
            // 比较head1的下一个节点与head2，较小者作为下一个节点
            mergedHead.next = merge(head1.next, head2);
        } else {
            // 二者相比，head2的值较小，作为头节点
            mergedHead = head2;
            // 比较head1与head2的下一个节点，较小者作为下一个节点
            mergedHead.next = merge(head1, head2.next);
        }
        return mergedHead;
    }

    public static void main(String[] args) {
        // 构建链表1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 构建链表2
        ListNode nodeA = new ListNode(2);
        ListNode nodeB = new ListNode(4);
        ListNode nodeC = new ListNode(6);
        ListNode nodeD = new ListNode(8);
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        // 合并链表
        ListNode mergedHead = merge(node1, nodeA);

        while (mergedHead != null) {
            System.out.print(mergedHead.val + "\t");
            mergedHead = mergedHead.next;
        }
    }

}
