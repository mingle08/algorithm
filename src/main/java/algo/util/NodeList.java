package algo.util;

public class NodeList {

    public ListNode first;
    public ListNode last;

    public NodeList(){
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    // 从尾部加入新元素
    public void add(int num){
        ListNode newNode = new ListNode(num);

        ListNode oldLast = last;
        last = newNode;
        last.next = null;

        if(isEmpty())
            first = last;
        else
            oldLast.next = last;

    }
}
