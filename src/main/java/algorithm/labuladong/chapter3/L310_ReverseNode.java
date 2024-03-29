package algorithm.labuladong.chapter3;

import algorithm.util.ListNode;

public class L310_ReverseNode {

    // 1，反转整个链表，有递归和循环2种方式
    /* 1.1 反转整个链表的递归写法 */
    public ListNode reverse(ListNode head) {
        // 当递归到最后一个节点的时候，由于head.next == null，于是递归终止，返回上一层
        if (head == null || head.next == null)
            return head;
        ListNode last = reverse(head.next);
        /*
        1 -> 2 -> 3 -> 4 -> 5 -> 6
        递归到最后一个节点6时，因为head.next == null，返回6，
        用last接收，一直是6，递归继续往上层返回。
        当head为5时，
        head.next是6，head.next.next就是6.next，本来是null，被赋值为5，就是向后的指针，改为向前指。
        也可以说，5.next就是6，经过head.next.next = head之后，得到6.next指向5，即 5 -> 6被改为 5 <- 6
        完成了节点的反转
         */
        head.next.next = head;
        // 取消原来指向后面的指针
        head.next = null;
        return last;
    }

    /* 1.2 反转整个链表的循环写法 */
    public ListNode reverseByLoop(ListNode head) {
        ListNode pre, cur, next;
        pre = null; cur = head; next = head;
        while (cur != null) {
            // 先拿到cur的下一个节点
            next = cur.next;
            // 逐个节点反转
            cur.next = pre;
            // 更新指针位置
            pre = cur;
            cur = next;
        }
        // 返回反转后的头节点
        return pre;
    }

    // 后继节点
    ListNode successor = null;

    /**
     * 2，反转链表前N个节点
     * 与反转整个链表相比，方法多了一个参数 int N
    */
    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点，后面再用
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        /**
         * 让反转之后的head节点和后面的节点连起来
         * debug之后得知，递归返回过程中，5会指向successor，上一层4也会指向successor，
         * 3，2，1依次都会指向successor
         * 也就是说successor的前驱节点一直在替换，走到最后的节点1（原head）指向之后反转结束，不再替换
          */
        head.next = successor;
        // last一经返回，一直保持不变，本例中一直是4（reverseN(head, 4);）
        return last;
    }

    /**
     *  3，反转链表的一部分
     *  指定反转的索引区间[m, n)
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            // 相当于反转前n个元素
            return reverseN(head, n);
        }
        // 对于 head.next 来说，就是反转区间 [m - 1, n - 1]
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 反转第left个和right个节点之间的链表
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode h = dummy;
        // 从dummy开始，到达left的前驱节点
        for (int a = 0; a < left - 1; a++) {
            h = h.next;
        }
        ListNode leftNode = h.next;
        ListNode rightNode = leftNode;
        // 从left开始，到达right节点
        for (int b = 0; b < right - left; b++) {
            rightNode = rightNode.next;
        }

        // 最后一段的头节点
        ListNode last = rightNode.next;
        // 截断
        h.next = null;
        rightNode.next = null;

        // 反转leftNode到rightNode的链表
        reverse(leftNode);
        // rightNode是头，leftNode是尾
        h.next = rightNode;
        leftNode.next = last;

        return dummy.next;
    }


    public static void main(String[] args) {
        L310_ReverseNode solution = new L310_ReverseNode();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode newHead = solution.reverseN(head, 4);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }

    }
}
