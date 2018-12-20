package algo.swordToOffer;

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

    public void deleteNode(ListNode head, ListNode toBeDeleted){
        if (head == null || toBeDeleted == null)
            return;

        // 要删除的节点，不是尾节点
        if (toBeDeleted.next != null){
            ListNode nextNode = toBeDeleted.next;  // j 节点
            toBeDeleted.val = nextNode.val;  // j 节点的内容覆盖 i 节点
            /**
             * 覆盖了 i 的j，相当于 删除了i，现在i的位置是 j，下一个节点，是原来 j 的下个节点
             */
            toBeDeleted.next = nextNode.next;

            nextNode = null;
        } else if (head == toBeDeleted){ // 链表只有一个节点，既是头节点，也是尾节点
            head = null;
            toBeDeleted = null;
        } else { // 链表有多个节点，删除的节点是尾节点
            ListNode node = head;
            while (node.next != toBeDeleted){
                node = node.next;
            }
            node.next = null;
            toBeDeleted = null;
        }
    }
}
