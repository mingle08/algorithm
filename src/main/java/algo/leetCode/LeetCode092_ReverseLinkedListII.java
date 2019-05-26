package algo.leetCode;

import algo.util.ListNode;
import algo.util.MyLinkList;

/**
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 */
public class LeetCode092_ReverseLinkedListII {

    public ListNode reverse(ListNode head, int m, int n){
        if (head == null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        int i = 1;
        while (pre.next != null && i < m){
            pre = pre.next;
            i++;
        }
        if (i < m)
            return head;

        ListNode mNode = pre.next;
        ListNode cur = mNode.next;
        /**
         * 每次循环的结果是：
         * 1. 把cur指向的元素移到m位置；
         * 2. mNode和cur各向后移动一步
         */
        for (int j = 0; j < n - m; j++) {
            mNode.next = cur.next;  // mNode不再指向cur，而是指向cur的下一个元素，因为cur的元素需要移动位置
            cur.next = pre.next;  // 反转方向
            pre.next = cur;      // 将cur指向的元素移到m位置

            cur = mNode.next;

        }

        return dummy.next;

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

        System.out.println(node.next);

    }
}
