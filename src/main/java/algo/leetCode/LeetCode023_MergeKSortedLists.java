package algo.leetCode;

import algo.dataStruct.ListNode;

public class LeetCode023_MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists){
        int len = lists.length;
        if (lists == null || len == 0)
            return null;
        if (len == 1)
            return lists[0];

        while (len > 1){
            int mid = (len + 1) / 2;
            for (int i = 0; i < len/2; i++) {
                lists[i] = mergeTwoLists(lists[i], lists[i+mid]);
            }
            len = mid;
        }
        return lists[0];
    }

    /**
     * 有序链表的组合，head1和head2为头结点，归并排序的核心思想
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode head1, ListNode head2){
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode head = new ListNode(0);
        ListNode pHead = head;

        // 二个链表归并排序
        while(head1 != null && head2 != null){
            if(head1.val <= head2.val){
                pHead.next = head1;   // 接入结果链表
                pHead = pHead.next;     // 移动指针
                head1 = head1.next;
            }else {
                pHead.next = head2;

                pHead = pHead.next;
                head2 = head2.next;
            }
        }

        if (head1 != null)
            pHead.next = head1;

        if (head2 != null)
            pHead.next = head2;

        return head.next;

    }
    
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(2);
        ListNode node8 = new ListNode(6);
        // 链表1
        node1.next = node2;
        node2.next = node3;
        // 链表2
        node4.next = node5;
        node5.next = node6;
        // 链表3
        node7.next = node8;

        // 把三个链表的头结点放到一个数组中
        ListNode[] lists = new ListNode[]{node1, node4, node7};
        
        ListNode newNode = mergeKLists(lists);
        
        System.out.println(newNode);

    }
}
