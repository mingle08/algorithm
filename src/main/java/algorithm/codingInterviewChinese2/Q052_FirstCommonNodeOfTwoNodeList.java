package algorithm.codingInterviewChinese2;

import algorithm.util.ListNode;
import algorithm.util.MyLinkList;

/**
 * 输入2个链表，找出它们的第一个公共节点。链表节点定义如下：
 * struct ListNode {
 *     int m_nKey;
 *     ListNode* m_pNext;
 * }
 *
 * 二个链表的第一个公共节点
 * 1. 遍历二个链表，得到它们的长度
 * 2. 二个长度相减，假设差是 m，就是长的比短的多 m 个节点个数
 * 3. 使用二个指针，第一个指针先让长的链表走 m 步，然后二个指针一起走，比较每次的二个节点值
 *
 * 假设链表1的长度为 x + z，其中x为与链表2不同的部分，z为共同部分；
 * 链表2的长度为 y + z，其中y为与链表1不同的部分，z为共同部分;
 * 假设x > y
 * 方法1遍历的链表长度为：(x + z) + (y + z) + （x - y) + 2 * (y + 1) = 2(x + y + z + 1)
 * 其中，x - y是快指针先走的步数，然后2个指针一起走，+ 1是因为第一个共同节点都要再遍历一次
 * 方法2遍历的链表长度为：(x + z + y + 1) + (y + z + x + 1) = 2(x + y + z + 1）
 * +1也是因为第一个公共节点要再遍历一次
 * 可见2种方法，遍历的链表长度是相等的
 */
public class Q052_FirstCommonNodeOfTwoNodeList {

    /**
     *
     * @param node1
     * @param node2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode node1, ListNode node2) {
        // 得到二个链表的长度
        int len1 = getListLength(node1);
        int len2 = getListLength(node2);
        int lengthDiff = len1 - len2;

        ListNode headLong = node1;  // 长链表
        ListNode headShort = node2;  // 短链表
        if (lengthDiff < 0) {
            headLong = node2;
            headShort = node1;
            lengthDiff = len2 - len1;
        }

        // 长的链表，先走 lengthDiff步
        for (int i = 0; i < lengthDiff; i++) {
            headLong = headLong.next;
        }

        // 只要2个节点的值不相等，就一直往后遍历
        while (headLong != null && headShort != null
                && headLong.val != headShort.val) {
            headLong = headLong.next;
            headShort = headShort.next;
        }
        // 上面的循环跳出之后，就是遇到公共节点了
       return headLong;
    }

    // 链表的节点数
    private int getListLength(ListNode node) {
        int num = 0;
        if (node == null)
            return num;

        while (node != null) {
            num++;
            node = node.next;
        }
        return num;
    }

    /**
     * 先遍历自己的链表，到达末尾则转到另一条链表的头节点
     * 比如：
     * 1 2 3
     *        6 7
     *   4 5
     *
     * 链表1遍历的节点是 1 2 3 6 7 4 5 6
     * 链表2遍历的节点是 4 5 6 7 1 2 3 6
     * 最终会在第一个公共节点6停止遍历
     * 可见公共节点6会被遍历4次，前2次在各自链表的遍历中，没相遇。
     * 这是2个链表长度不等的情况。
     * 如果2个链表长度相同，公共节点在前2次遍历中就会相遇
     * @param node1
     * @param node2
     * @return
     */
    public ListNode getCommon(ListNode node1, ListNode node2) {
        ListNode cur1 = node1;
        ListNode cur2 = node2;
        int count = 0;
        // 停在第一公共节点
        while (cur1.val != cur2.val) {
            if (cur1 != null) {
                cur1 = cur1.next;
                // 当走完自己的路时，走别人的路
                if (cur1 == null) cur1 = node2;
            }

            if (cur2 != null) {
                cur2 = cur2.next;
                // 当走完自己的路时，走别人的路
                if (cur2 == null) cur2 = node1;
            }
            count++;
        }
        System.out.println("每个链表走了" + count + "步，来到第一个公共节点");
        return cur1;
    }

    public static void main(String[] args) {
        Q052_FirstCommonNodeOfTwoNodeList solution = new Q052_FirstCommonNodeOfTwoNodeList();

        MyLinkList link1 = new MyLinkList();
        link1.add(1);
        link1.add(2);
        link1.add(3);
        link1.add(6);
        link1.add(7);

        MyLinkList link2 = new MyLinkList();
//        link2.add(3);
        link2.add(4);
        link2.add(5);
        link2.add(6);
        link2.add(7);

        ListNode firstCommonNode = solution.findFirstCommonNode(link1.head, link2.head);

        System.out.println(firstCommonNode.val);

        ListNode firstCom = solution.getCommon(link1.head, link2.head);
        System.out.println(firstCom.val);

    }
}
