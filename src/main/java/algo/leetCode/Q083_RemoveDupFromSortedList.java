package algo.leetCode;

public class Q083_RemoveDupFromSortedList {
    public static void main(String[] args) {
        Q083_RemoveDupFromSortedList solution = new Q083_RemoveDupFromSortedList();
        NodeList headNode = new NodeList();
        headNode.add(1);
        headNode.add(1);
        headNode.add(1);
        headNode.add(2);
        headNode.add(3);
        headNode.add(3);
        headNode.add(5);

//        ListNode newNode = solution.deleteDuplicates(headNode.head);
        ListNode newNode = solution.removeDuplicates(headNode.head);

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
            } else {
                tmp.next = head;  // tmp的第二个节点是2；
                tmp = tmp.next;   // tmp后移，变成2；
                head = head.next; // head指向3

            }
        }
        tmp.next = head;  // head指向5， tmp现在是2，next指向5
        return dummy.next;
    }

    public ListNode removeDuplicates(ListNode head) {
        ListNode cur = head;
        if (cur == null ){
            return head;
        }
        while (cur.next != null){
            if (cur.val == cur.next.val){
                cur.next = cur.next.next; //当前值与下一个值相等， 则删除
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
