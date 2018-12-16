package algo.leetCode;

import algo.util.ListNode;

public class Q061_RotateList {

    public static void main(String[] args) {
        Q061_RotateList solution = new Q061_RotateList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        
        ListNode newNode = solution.rotateRight(node1, 2);
        System.out.println(newNode.val);

    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0)
            return head;
        ListNode fast = head, slow = head,countlen = head;
        ListNode newhead = new ListNode(-1);
        int len = 0;
         
        while(countlen!=null){
            len++;
            countlen = countlen.next;
        }
         
        k = k%len;
        if(k==0)
            return head;
        /**
         * fast指针先走到3的位置
         * 
         *    1 ->  2  ->  3  ->  4  ->  5
         *                 |
         *                fast
         */
        for(int i = 0; i < k; i++)
            fast = fast.next;
        
        /**
         * 二个指针一起走
         * 1 ->  2  ->  3  ->  4  ->  5
         *              |             |
         *             slow          fast
         */
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        // 调整头和尾
        newhead = slow.next;    // 4成为新的头节点，替换掉原来的-1
        fast.next = head;       // 5的后面接原来的头节点1
        slow.next = null;       // 3是尾节点，后面没有节点
         
        return newhead;
    }

}
