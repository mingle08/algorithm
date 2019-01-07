package algo.swordToOffer;

import algo.util.ListNode;
import algo.util.MyLinkList;

/**
 * 二个链表的第一个公共节点
 * 1. 遍历二个链表，得到它们的长度
 * 2. 二个长度相减，假设差是 m，就是长的比短的多 m 个节点个数
 * 3. 使用二个指针，第一个指针先让长的链表走 m 步，然后二个指针一起走，比较每次的二个节点值
 */
public class Q052_FirstCommonNodeOfTwoNodeList {

    public ListNode findFirstCommonNode(ListNode node1, ListNode node2){
        // 得到二个链表的长度
        int len1 = getListLength(node1);
        int len2 = getListLength(node2);
        int lengthDiff = len1 - len2;

        ListNode headLong = node1;  // 长链表
        ListNode headShort = node2;  // 短链表
        if (len2 > len1){
            headLong = node2;
            headShort = node1;
            lengthDiff = len2 - len1;
        }

        for (int i = 0; i < lengthDiff ; i++) {
            headLong = headLong.next;
        }

        while (headLong != null && headShort != null
                && headLong.val != headShort.val){
            headLong = headLong.next;
            headShort = headShort.next;
        }

        ListNode firstCommonNode = headLong;

        return firstCommonNode;
    }

    // 链表的节点数
    private int getListLength(ListNode node){
        int num = 0;
        if (node == null)
            return num;

        while (node != null){
            node = node.next;
            num++;
        }
        return num;
    }

    public static void main(String[] args){
        Q052_FirstCommonNodeOfTwoNodeList solution = new Q052_FirstCommonNodeOfTwoNodeList();

        MyLinkList link1 = new MyLinkList();
        link1.add(1);
        link1.add(2);
        link1.add(3);
        link1.add(6);
        link1.add(7);

        MyLinkList link2 = new MyLinkList();
        link2.add(4);
        link2.add(5);
        link2.add(6);
        link2.add(7);

        ListNode firstCommonNode = solution.findFirstCommonNode(link1.head, link2.head);

        System.out.println(firstCommonNode.val);


    }
}
