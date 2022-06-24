package algorithm.leetCode;

import algorithm.util.ListNode;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存在一位数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode002_AddTwoNodes {

    public ListNode addTwoNodes(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = new ListNode(0);
        dummy.next = head;
        ListNode sum = head;
        ListNode carry = new ListNode(0);
        sum.next = carry;
        // 只要有一个不为空
        // 考虑2个链表长度不同
        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            sum.val += a + b;

            if (sum.val >= 10) {
                sum.val -= 10;
                carry.val += 1;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            // 如果2个链表都没有后继节点，就不需要再创建新的节点，
            if (l1 == null && l2 == null) {
                break;
            } else {
                sum = carry;
                carry = new ListNode(0);
                sum.next = carry;
            }
        }

        // 如果最后的进位是0，sum.next设为null
        if (carry.val == 0) sum.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        LeetCode002_AddTwoNodes solution = new LeetCode002_AddTwoNodes();
        ListNode l10 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l12 = new ListNode(3);
        ListNode l20 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(4);

        l10.next = l11;
        l11.next = l12;
        l20.next = l21;
        l21.next = l22;

        ListNode l3 = solution.addTwoNodes(l10, l20);
        while (l3 != null) {
            System.out.print(l3.val + " ");
            l3 = l3.next;
        }

        System.out.println();
        // 7个9
        ListNode l30 = new ListNode(9);
        ListNode l31 = new ListNode(9);
        ListNode l32 = new ListNode(9);
        ListNode l33 = new ListNode(9);
        ListNode l34 = new ListNode(9);
        ListNode l35 = new ListNode(9);
        ListNode l36 = new ListNode(9);

        // 4个9
        ListNode l40 = new ListNode(9);
        ListNode l41 = new ListNode(9);
        ListNode l42 = new ListNode(9);
        ListNode l43 = new ListNode(9);

        l30.next = l31; l31.next = l32; l32.next = l33;
        l33.next = l34; l34.next = l35; l35.next = l36;
        l40.next = l41; l41.next = l42; l42.next = l43;

        ListNode l5 = solution.addTwoNodes(l30, l40);

        while (l5 != null) {
            System.out.print(l5.val + " ");
            l5 = l5.next;
        }

        System.out.println();
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(0);
        ListNode node2 = solution.addTwoNodes(node0, node1);
        while (node2 != null) {
            System.out.print(node2.val + " ");
            node2 = node2.next;
        }
    }
}
