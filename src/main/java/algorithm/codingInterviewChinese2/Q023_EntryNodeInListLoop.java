package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;

/**
 * 链表中环的入口节点
 * 思路：（1）求出环上的一个节点：快慢指针
 * （2）求出环的节点数 k
 * （3）2个指针，第一个指针先走 k 步，第二个指针才开始走（2个指针步长都是1）
 */
public class Q023_EntryNodeInListLoop {

    // 找到环中的任意一个节点
    private ListNode meetingNode(ListNode head) {
        if (head == null) {
            return null;
        }
        // 设定慢指针起始位置
        ListNode pSlow = head.next;
        if (pSlow == null) {
            return null;
        }
        // 设定快指针起始位置
        ListNode pFast = pSlow.next;

        while (pFast != null && pSlow != null) {
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

    public ListNode entryNodeOfLoop(ListNode head) {
        ListNode meetingNode = meetingNode(head);
        if (meetingNode == null)
            return null;

        // 1，得到环中节点的数目
        int nodesInLoop = 1;
        ListNode pNode1 = meetingNode;
        while (pNode1.next != meetingNode) {
            pNode1 = pNode1.next;
            nodesInLoop++;
        }

        // 2，先移动pNode1，次数为环中节点的数目
        pNode1 = head;
        for (int i = 0; i < nodesInLoop; i++) {
            pNode1 = pNode1.next;
        }

        // 3，再移动pNode1和pNode2：相同的速度
        ListNode pNode2 = head;
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }

        return pNode1;
    }

    /**
     * 当快、慢指针相遇时，让其中任何一个指针指向头节点，然后让2个指针以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
     * 第一次相遇时，假设慢指针slow走了k步，那么快指针fast一定走了2k步，也就是说，比slow指针多走了k步（环长度的整数倍）
     * 设相遇点与环的起点的距离为m，那么环的起点与头节点head的距离为(k - m)，也就是说从head前进(k - m)步就能到达环的起点。
     * 而如果从相遇点继续前进(k - m)步，也恰好到达环的起点
     * 因为快指针比慢指针多走的k步，就是从相遇点出发再走k步（好几圈）回到相遇点的步数。从相遇点到头节点的k步，是快慢指针都走过的。
     * k步往回退m，就剩下(k - m)
     * 慢指针的后退m距离比较好理解，快指针走过的k步，在最后一圈，在距离相遇点m的地方停下，走过的距离就是(k - m)的距离
     * 把步理解为步长，理解成距离单位
     * @param head
     * @return
     */
    public ListNode findEntryNode(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.val == slow.val) break;
        }

        slow = head;
        while (slow.val != fast.val) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
        // 节点3是环的入口
        node6.next = node3;

        ListNode meet = solution.meetingNode(root);
        System.out.println("环中的一个节点：" + meet.val);
        ListNode entry = solution.entryNodeOfLoop(root);
        System.out.println("环的入口为：" + entry.val);
        ListNode enter = solution.findEntryNode(root);
        System.out.println("第二种找法，环的入口：" + enter.val);
    }
}
