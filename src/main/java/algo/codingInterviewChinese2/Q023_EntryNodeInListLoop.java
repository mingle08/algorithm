package algo.codingInterviewChinese2;

import algo.util.ListNode;

/**
 * 链表中环的入口节点
 * 思路：（1）求出环上的一个节点：快慢指针
 *      （2）求出环的节点数 k
 *      （3）2个指针，第一个指针先走 k 步，第二个指针才开始走（2个指针步长都是1）
 */
public class Q023_EntryNodeInListLoop {

    // 找到环中的任意一个节点
    private ListNode meetingNode(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode pSlow = head.next;
        if (pSlow == null) {
            return null;
        }
        ListNode pFast = pSlow.next;

        while (pFast != null && pSlow != null){
            if (pFast == pSlow) {
                return pFast;
            }
            // 慢指针走一步
            pSlow = pSlow.next;
            /**
             * 快指针走二步
             * 1， 先走一步
             * 2， 判断当前快指针不是null，再走一步
             */
            // 1, 第一步
            pFast = pFast.next;
            // 2, 第二步
            if (pFast != null)
                pFast = pFast.next;
        }

        return null;
    }

    public ListNode entryNodeOfLoop(ListNode head){
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;

        // 得到环中节点的数目
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode){
            pNode1 = pNode1.next;
            nodesInLoop++;
        }

        // 先移动pNode1，次数为环中节点的数目
        pNode1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.next;
        }

        // 再移动pNode1和pNode2：相同的速度
        ListNode pNode2 = head;
        while (pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }

    public static void main(String[] args) {
        Q023_EntryNodeInListLoop solution = new Q023_EntryNodeInListLoop();
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        root.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        ListNode meet = solution.meetingNode(root);
        System.out.println("环中的一个节点：" + meet.val);
        ListNode entry = solution.entryNodeOfLoop(root);
        System.out.println("环的入口为：" + entry.val);
    }
}
