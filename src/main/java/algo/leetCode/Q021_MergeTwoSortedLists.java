package algo.leetCode;

import algo.dataStruct.ListNode;

/**
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Q021_MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode node1, ListNode node2){
        ListNode p1 = node1;
        ListNode p2 = node2;

        // 新建一个值为0的新节点，作为合并节点的头部
        ListNode head = new ListNode(0);
        ListNode mergeNode = head;

        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;

        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                mergeNode.next = p1;
                p1 = p1.next;
            }else {
                mergeNode.next = p2;
                p2 = p2.next;
            }

            mergeNode = mergeNode.next;
        }

        if(p1 != null)
            mergeNode.next = p1;
        if (p2 != null)
            mergeNode.next = p2;

        // 返回下一个节点，因为head的值是0
        return head.next;
    }
    
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        
        ListNode newNode = mergeTwoLists(node1, node4);
        
        System.out.println(newNode);
        
        
    }
}
