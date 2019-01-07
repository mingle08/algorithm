package algo.Sword;

/**
 * 思路1：先复制结点，用next链接，最后根据原始结点的sibling指针确定该sibling结点距离头结点的位置，
 *       从而对复制结点设置sibling指针。但是该思路对于n个结点的链表，每个结点的sibling都需要O(n)
 *       个时间步才能找到，所以时间复杂度为O(n^2)
 *
 * 思路2：复制原始结点N创建N’，用next链接。将<N,N'>的配对信息存放入一个哈希表中；在设置sibling时，
 *       通过哈希表，只需要用O(1)的时间即可找到复制结点的sibling。该方法的时间复杂度为O(n)，但
 *       空间复杂度为O(n)。
 *
 * 思路3：复制原始结点N创建N’，将N'链接到N的后面；根据原始结点N的sibling可以快速设置N'结点的sibling，
 *       最后将这个长链表拆分成原始链表和复制链表（根据奇偶位置）
 */
public class Q035_CopyComplexNodeList {

    public class ComplexListNode {
        int val;
        ComplexListNode next = null;
        ComplexListNode sibling = null;

        ComplexListNode(int label) {
            this.val = label;
        }
    }

    /*
     * 主程序（包含三步）
     */
    public ComplexListNode copyList(ComplexListNode head) {
        copyNodes(head);                 //1.复制结点
        connectSiblingNodes(head);       //2.设置sibling
        return reconnectNodes(head);     //3.拆分长链表
    }

    /*
     * 1. 复制每个结点，并插入到原始节点的后面
     */
    private void copyNodes(ComplexListNode head) {
        ComplexListNode pNode = head;
        while(pNode != null) {
            ComplexListNode copydNode = new ComplexListNode(pNode.val);
            copydNode.next = pNode.next;    // 新节点的下个节点 B，是原来节点 A 的下个节点
            copydNode.sibling = null;
            pNode.next = copydNode;         // 原来节点 A 的下个节点，就是新节点 A'

            pNode = copydNode.next;         // 原节点移动到下一个原节点：A 经过 A' 到达 B
        }
    }

    /*
     * 第二步：根据原结点的sibling，设置复制结点的sibling
     */
    private void connectSiblingNodes(ComplexListNode head) {
        ComplexListNode pNode = head;
        while(pNode != null) {
            ComplexListNode copyNode = pNode.next;
            //必须考虑到siblingNode==null的情况
            if(pNode.sibling != null)
                copyNode.sibling = pNode.sibling.next;

            pNode = copyNode.next;  // 原节点移动到下一个原节点
        }
    }

    /*
     * 第三步：将长链表拆分成原始链表和复制链表（根据奇偶位置）
     */
    private ComplexListNode reconnectNodes(ComplexListNode head) {
        ComplexListNode copyHead = null;
        ComplexListNode copyNode = null;
        ComplexListNode pNode = head;
        if(pNode != null) {
            copyHead = copyNode = pNode.next;  // copyHead指向 A'
            pNode.next = copyNode.next;        // copyNode.next是 B，所以pNode现在是 A --> B
            pNode = pNode.next;                // pNode移动到 B
        }
        while(pNode != null) {
            copyNode.next = pNode.next;  // pNode是 B，pNode.next是 B'，此步让copyNode由A'指向B'
            copyNode = copyNode.next;    // copyNode移动到 B'
            pNode.next = copyNode.next;  // copyNode.next是C，此步让pNode（在B）的下个节点是C
            pNode = pNode.next;          // pNode移动到 C
        }
        return copyHead;
    }
}
