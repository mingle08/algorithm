package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;

/**
 * 题目一：在O(1)时间内删除链表节点
 * 1，链表是单向的，只有向后的指针，没有向前的指针
 * 2，规定方法的参数，都是链表节点：void deleteNode(ListNode head, ListNode toBeDeleted)
 *
 * 在单向链表中删除一个节点的二种方法：
 * 1. 在删除节点i之前，先从链表的头节点开始遍历到i前面的一个节点h，把h的next指向i的下一个节点j，再删除节点i；
 * 2. 把节点j的内容复制覆盖节点i，接下来再把节点i的next指向j的下一个节点，再删除节点j，这种方法不用遍历链表上
 *    节点i前面的节点
 * 第二种方法的时间复杂度：
 *     对于 n-1 个非尾节点而言，我们可以在 O(1) 时间内把下一个节点的内存复制覆盖要删除的节点，并删除下一个节点；
 *     对于尾节点而言，由于仍然需要顺序遍历查找，时间复杂度为O(n)，因此，总的平均时间复杂度为：
 *         [(n-1) * O(1) + O(n)] / n = O(1)
 *     结果还是O(1)，符合面试官的要求。
 */
public class Q018_1_DeleteNodeInList {

    /**
     * curr与dummy都指向原链表的头节点，所以删除的时候，不用判断删除的是头节点还是尾节点
     * @param head
     * @param toBeDeleted
     * @return
     */
    public static ListNode deleteNode(ListNode head, ListNode toBeDeleted) {
        // dummy只作为指针，指向原链表的头节点，不参与循环操作
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 1，要删除的节点不是尾节点
        if (toBeDeleted.next != null) {
            // 待删除节点的下一个节点
            ListNode nextNode = toBeDeleted.next;
            // 用下一个节点覆盖
            toBeDeleted.val = nextNode.val;
            toBeDeleted.next = nextNode.next;

            nextNode = null;
        }
        // 2，要删除的节点是尾节点，因为尾节点后面是空，不需要处理，需要处理的是与前节点的关系，要拿到前节点，把它的下个节点设为null
        // 2.1 链表只有一个节点，删除头节点（也是尾节点）
        else if (head.next == null && head == toBeDeleted) {
            dummy.next = null;
        }
        // 2.2 链表中有多个节点，删除尾节点
        else {
            ListNode cur = head;
            while (cur.next != toBeDeleted) {
                cur = cur.next;
            }
            cur.next = null;
        }

        return dummy.next;
    }

    public static void printNode(ListNode node) {
        while(node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        /*ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;*/

        printNode(node1);

        ListNode newNode = deleteNode(node1, node1);

        printNode(newNode);
    }
}
