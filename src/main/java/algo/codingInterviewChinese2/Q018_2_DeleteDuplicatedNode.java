package algo.codingInterviewChinese2;

import algo.util.ListNode;
import algo.util.MyLinkList;

/**
 * 题目二：删除链表中重复的节点
 * 在一个排序的链表中，如何删除重复的节点？
 *  1  2  3  3  4  4  5
 *  以上链表中的3和4都重复了，所以3全部删除，4全部删除，得到的链表：
 *  1  2  5
 */
public class Q018_2_DeleteDuplicatedNode {

    public ListNode deleteDuplication(ListNode head){
        if (head == null)
            return null;

        ListNode preNode = null;  // 前一个节点
        ListNode curNode = head;  // 当前节点

        while (curNode != null){
            ListNode nextNode = curNode.next;  // 后一个节点
            boolean needDelete = false;    // 删除标记
            if (nextNode != null && nextNode.val == curNode.val) {    // 发现相同节点
                needDelete = true;
            }
            if (!needDelete){
                preNode = curNode;
                curNode = curNode.next;
            } else {
                int value = curNode.val;
                ListNode toBeDeleted = curNode;
                while (toBeDeleted != null && toBeDeleted.val == value){
                    nextNode = toBeDeleted.next;  // 下一个节点往后移动
                    toBeDeleted = nextNode;  // 这个节点也可能是要删除的，进入while判断
                }

                if (preNode == null) { // 说明删除的节点是头节点
                    head = nextNode;
                } else {
                    preNode.next = nextNode;
                }
                curNode = nextNode;
            }
        }

        return head;
    }

    public static void main(String[] args){
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

        while(head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }

    }
}
