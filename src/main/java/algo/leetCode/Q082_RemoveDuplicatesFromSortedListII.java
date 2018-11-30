package algo.leetCode;

public class Q082_RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        Q082_RemoveDuplicatesFromSortedListII solution = new Q082_RemoveDuplicatesFromSortedListII();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        
        ListNode newNode = solution.deleteDuplicates(node1);
        
        System.out.println(newNode.val);

    }
    
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next != null && head.next.next != null) {
            if(head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

}
