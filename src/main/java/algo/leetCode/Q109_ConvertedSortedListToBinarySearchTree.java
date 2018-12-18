package algo.leetCode;

import algo.util.TreeNode;

public class Q109_ConvertedSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return  null;
        return build(head,null);
    }

    public TreeNode build(ListNode head, ListNode tail){
        if (head == null)
            return null;
        if (head.next == null)
            return new TreeNode(head.val);

        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }

        // 中间节点，作为根节点
        TreeNode root = new TreeNode(slow.val);
        root.left = build(head, slow);
        root.right = build(slow.next, tail);

        return root;
    }
}
