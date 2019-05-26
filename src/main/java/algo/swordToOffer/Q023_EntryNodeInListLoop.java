package algo.swordToOffer;

import algo.util.ListNode;

/**
 * 链表中环的入口节点
 */
public class Q023_EntryNodeInListLoop {

    // 找到环中的任意一个节点
    private ListNode meetingNode(ListNode head){
        if (head == null)
            return null;

        ListNode pSlow = head.next;
        if (pSlow == null)
            return null;
        ListNode pFast = pSlow.next;

        while (pFast != null && pSlow != null){
            if (pFast == pSlow)
                return pFast;

            pSlow = pSlow.next;
            pFast = pFast.next;
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

        // 再移动pNode1和pNode2
        ListNode pNode2 = head;
        while (pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }
}
