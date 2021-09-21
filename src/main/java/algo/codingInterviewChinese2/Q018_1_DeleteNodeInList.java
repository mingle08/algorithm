package algo.codingInterviewChinese2;

import algo.util.ListNode;

/**
 * 在链表中删除一个节点的二种方法：
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
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
        // dummy只作为指针，指向原链表的头节点，不参与循环操作
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // curr参与循环操作
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
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
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        printNode(node1);

        ListNode newNode = deleteNode(node1, 9);

        printNode(newNode);
    }
}
