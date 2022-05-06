package algorithm.leetCode;

import algorithm.util.ListNode;
import algorithm.util.MyLinkList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class LeetCode086_PartitionList {

    /**
     * 推荐第一种方法，思路更直观
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        // 头结点
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        // 当前结点
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = head;
            } else {
                cur2.next = head;
                cur2 = head;
            }
            head = head.next;
        }
        // important! avoid cycle in linked list.
        // otherwise u will get TLE.
        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }


    public ListNode partition2(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode insertPos = null;
        while(cur!=null){
            //定位需要插入的位置;
            if(cur.val >= x && insertPos == null){
                insertPos = pre;
            }
            //插入操作;
            if(cur.val < x && insertPos != null){
                pre.next = pre.next.next;
                cur.next = insertPos.next;
                insertPos.next = cur;
                insertPos = insertPos.next;
                cur = pre.next;
                continue;
            }
            pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }


    public static void main(String[] args){

        LeetCode086_PartitionList solution = new LeetCode086_PartitionList();

        MyLinkList linkList = new MyLinkList();
        linkList.add(1);
        linkList.add(4);
        linkList.add(3);
        linkList.add(2);
        linkList.add(5);
        linkList.add(2);

        ListNode node = solution.partition1(linkList.head, 3);
//        ListNode node = solution.partition2(linkList.head, 3);
        System.out.println(node.val);
    }
}
