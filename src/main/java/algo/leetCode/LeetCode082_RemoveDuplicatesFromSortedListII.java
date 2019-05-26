package algo.leetCode;

import algo.util.ListNode;

public class LeetCode082_RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {
        LeetCode082_RemoveDuplicatesFromSortedListII solution = new LeetCode082_RemoveDuplicatesFromSortedListII();
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
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy;

        while(head != null && head.next != null){
            if (head.val == head.next.val){ //遇到相同的元素，整段删除
                while(head.next != null && head.val == head.next.val){
                    head = head.next;
                }
                /**
                 * 第一次判断重复的1
                 * 走到这一步，指针在第三个1，后面是2，因为这个1也是要删除的，所以head指针后移到2上
                 * 第二次判断重复的3
                 */

                head = head.next;  // 第一次执行完成之后：head指向2;第二次执行完之后，head指向5
            } else {
                tmp.next = head;  // tmp的第二个节点是2；
                tmp = tmp.next;   // tmp后移，变成2；
                head = head.next; // head指向3

            }
        }
        tmp.next = head;  // head指向5， tmp现在是2，next指向5
        return dummy.next;
    }

}
