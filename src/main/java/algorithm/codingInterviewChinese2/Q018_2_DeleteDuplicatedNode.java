package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;
import algorithm.util.MyLinkList;

/**
 * 题目二：删除链表中重复的节点
 * 在一个排序的链表中，如何删除重复的节点？
 * 1  2  3  3  4  4  5
 * 以上链表中的3和4都重复了，所以3全部删除，4全部删除，得到的链表：
 * 1  2  5
 *
 * 如果要求是：删除重复的元素，使得每个元素只出现一次
 * 1 2 3 3 4 4 5
 * 删除之后，得到的链表：
 * 1 2 3 4 5
 */
public class Q018_2_DeleteDuplicatedNode {

    public ListNode deleteDuplication(ListNode head) {
        if (head == null)
            return null;

        ListNode preNode = null;  // 前一个节点
        ListNode curNode = head;  // 当前节点

        while (curNode != null) {
            // 后一个节点
            ListNode nextNode = curNode.next;
            // 删除标记
            boolean needDelete = false;
            // 发现相同节点：当前节点和下一个节点
            if (nextNode != null && nextNode.val == curNode.val) {
                needDelete = true;
            }
            if (!needDelete) {
                preNode = curNode;
                curNode = curNode.next;
            } else {
                // 要被删除的节点的值
                int value = curNode.val;
                // 当前节点要删除
                ListNode toBeDeleted = curNode;
                while (toBeDeleted != null && toBeDeleted.val == value) {
                    // 下一个节点往后移动
                    nextNode = toBeDeleted.next;
                    // 下一个节点也要删除，进入while判断
                    toBeDeleted = nextNode;
                }
                // 跳出循环，说明nextNode不是重复节点

                // 说明删除的节点是头节点
                if (preNode == null) {
                    head = nextNode;
                } else {
                    // 当前节点和下一个节点是重复节点，被删除，此时的nextNode不是重复节点
                    preNode.next = nextNode;
                }
                curNode = nextNode;
            }
        }

        return head;
    }

    /**
     * 删除重复的元素，使得每个元素只出现一次
     *  * 1 2 3 3 4 4 5
     *  * 删除之后，得到的链表：
     *  * 1 2 3 4 5
     */
    ListNode deleteDup(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (fast.val != slow.val) {
                //
                slow.next = fast;
                // slow++
                slow = slow.next;
            }
            // fast++
            fast = fast.next;
        }
        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        Q018_2_DeleteDuplicatedNode solution = new Q018_2_DeleteDuplicatedNode();

        MyLinkList link = new MyLinkList();
        link.add(1);
        link.add(2);
        link.add(3);
        link.add(3);
        link.add(4);
        link.add(4);
        link.add(5);

        ListNode head = solution.deleteDuplication(link.head);

        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }

    }
}
