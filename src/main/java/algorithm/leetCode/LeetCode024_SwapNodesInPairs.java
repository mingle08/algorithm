package algorithm.leetCode;

import algorithm.dataStruct.ListNode;

/**
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class LeetCode024_SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head){
        if (head == null || head.next == null)
            return head;

        ListNode root = new ListNode(-1);
        root.next = head;

        ListNode ptr = root;

        while (head != null && head.next != null){
            // 第1个节点
            ListNode node1 = head;
            // 第3个节点
            ListNode node2 = head.next.next;

            // 交换：head.next是原来的第二个节点，现在成为root的下个节点，也就是第一个节点
            root.next = head.next;
            // 指针移到第二个节点位置
            root = root.next;
            // root现在指向第二个节点位置，放上原来的第一个节点
            root.next = node1;

            // node1交换到第2个节点位置上，它的下一个节点，就是第3个节点
            node1.next = node2;


            // root指向第三个位置
            root = root.next;
            // head也等于第三个节点
            head = node2;

        }
        return ptr.next;
    }

    public static ListNode swap(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while(p.next != null && p.next.next != null) {
            // 以 1 -> 2 -> 3 ->4 为例，要变成 2 -> 1 -> 4 -> 3
            // a是1
            ListNode a = p.next;
            // b是2
            ListNode b = a.next;
            // 原来p的后继节点是1，现在改为2
            p.next = b;
            // 1原来后面是2，现在改为2的后面，即3
            a.next = b.next;
            // 现在2的后面改为1，此时2指向1，到此1和2已经交换位置
            b.next = a;
            // p移到交换后的a上，即交换后的第二个节点，对于3 -> 4来说，p是指向3的
            p = a;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode newNode = swap(node1);

        while (newNode != null) {
            System.out.println(newNode.val);
            newNode = newNode.next;
        }
    }

}
