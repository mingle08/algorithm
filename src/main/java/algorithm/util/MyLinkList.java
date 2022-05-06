package algorithm.util;

public class MyLinkList {
    public ListNode head;
    public ListNode cur;

    public void add(int val){
        if(head == null){
            head = new ListNode(val);
            cur = head;
        } else {
            cur.next = new ListNode(val);
            cur = cur.next;
        }
    }

    public void printList(ListNode node){
        if(node == null){
            return;
        }
        cur = node;
        while(cur != null){
            System.out.println(node.val);
            cur = cur.next;
        }
    }
}
