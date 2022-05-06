package algorithm.leetCode;

import algorithm.dataStruct.ListNode;

/**
 * Example:

 Given this linked list: 1->2->3->4->5

 For k = 2, you should return: 2->1->4->3->5

 For k = 3, you should return: 3->2->1->4->5

 Reverse a link list between pre and next exclusively
       * an example:
       * a linked list:
       * 0->1->2->3->4->5
       * |           |
       * pre        end
       * after call pre = reverse(pre, end)
       *
       * 0->3->2->1->4->5
       *          |  |
       *          pre end
 */
public class LeetCode025_ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
        {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int count = 0;
        /**
         * 因为pre和dummy都是指向头节点0，所以二者同时变化
         */
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null)
        {
            count ++;
            ListNode post = cur.next;  // 临时变量
            if(count == k)
            {
                /**
                 * 可以有返回值，也可以没有返回值
                 */
                pre = reverse(pre, post); // 等号左边的pre，表示pre移动到新位置
                count = 0;
            }
            cur = post;  // 赋值，相当于cur = cur.next;  迭代cur
        }
        return dummy.next;
    }

    /**
     * 此方法可以有返回值，也可以是void; 不影响结果
     * @param pre
     * @param end
     * @return
     */
    private static ListNode reverse(ListNode pre, ListNode end)
    {
        if(pre==null || pre.next==null)
            return pre;
        ListNode root = pre.next;
        ListNode current = pre.next.next;
        while(current != end)
        {
            ListNode tmp = current.next;    // 1. 临时变量
            current.next = pre.next;   // 2. 指向的下一个节点改变了
            pre.next = current;       // 3. 指向的下一个节点改变了
            current = tmp;           // 4. 赋值。第1步与第4步，相当于current = current.next，向下迭代
        }
        root.next = end;
        return root;
    }

    public static void main(String[] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode newNode = reverseKGroup(node1, 3);

        System.out.println(newNode);
    }
}
