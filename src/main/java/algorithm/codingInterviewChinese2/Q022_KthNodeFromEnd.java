package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;

/**
 * 链表中倒数第k个节点
 * 题目：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是：
 * 1，2，3，4，5，6.这个链表的倒数第三个节点是值为4的节点。
 * 链表是单向链表，每个节点只有向后的节点。
 * <p>
 * 思路一：先走到链表的尾端，再从尾端回溯 k 步，可是链表是单向链表，无法向前遍历，此路不通
 * 思路二：如果知道链表的节点数 n，那么倒数第k个节点，就是从头节点开始的第 n-k+1 个节点。
 * 怎么得到节点数 n？只需要从头开始遍历链表，每经过一个节点，计数器就加1。
 * 此思路要遍历两次链表，第一次是统计出链表中节点的个数，第二次就能找到第 n-k+1 个的节点
 * 思路三：只遍历一次链表：定义2个指针，第一个指针从链表的头开始遍历，走k-1步，第二个指针保持不动；
 * 从第k步开始，第二个指针也开始从链表的头部开始遍历。由于2个指针的距离保持在k-1，当第一个
 * （走在前面的）指针到达链表的尾节点时，第二个（走在后面的）指针正好指向倒数第k个节点
 * <p>
 * 相关题目：
 * 求链表的中间节点。如果链表中的节点总数为奇数，则返回中间节点；如果节点总数为偶数，则返回中间两个节点的任意一个。
 * 思路：快慢指针，一个指针走一步，另一个指针走2步。
 * 当快指针走到链表的末尾时，慢指针正好在链表的中间。
 */
public class Q022_KthNodeFromEnd {

    public ListNode findKthNodeFromEnd(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode ptrA = head;
        ListNode ptrB = head;
        // 先让A指针走 k-1 步
        for (int i = 0; i < k - 1; i++) {
            if (ptrA.next != null) {
                ptrA = ptrA.next;
            } else {    // 如果链表的节点数少于k
                return null;
            }
        }

        // 二个指针再一起走，当A指针走到最后一个节点，B指针停留的位置就是倒数K个节点
        while (ptrA.next != null) {
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }

        return ptrB;
    }
}
