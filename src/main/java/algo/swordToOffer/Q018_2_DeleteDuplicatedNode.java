package algo.swordToOffer;

import algo.util.ListNode;
import algo.util.MyLinkList;

public class Q018_2_DeleteDuplicatedNode {

    public ListNode deleteDuplication(ListNode head){
        if (head == null)
            return null;

        ListNode preNode = null;  // 前一个节点
        ListNode curNode = head;  // 当前节点

        while (curNode != null){
            ListNode nextNode = curNode.next;  // 后一个节点
            boolean needDelete = false;
            if (nextNode != null && nextNode.val == curNode.val)
                needDelete = true;

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

                if (preNode == null) // 说明删除的节点是头节点
                    head = nextNode;
                else
                    preNode.next = nextNode;

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

        System.out.println(head.next.next.val);
    }
}
