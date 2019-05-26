package algo.leetCode;

/**
          1
        /  \
       2    3
     / \    \
    4   5    7


           1 -> NULL
         /  \
        2 -> 3 -> NULL
       / \    \
      4-> 5 -> 7 -> NULL
 */

public class LeetCode117_PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (null == root) {
            return;
        }

        TreeLinkNode cur = root.next;
        TreeLinkNode p = null;

        while (cur != null) { // find last right node (left or right)
            if (cur.left != null) {
                p = cur.left;
                break;
            }
            if (cur.right != null) {
                p = cur.right;
                break;
            }
            cur = cur.next;
        }

        if (root.right != null) {
            root.right.next = p;
        }

        if (root.left != null) {
            root.left.next = root.right != null ? root.right : p;
        }

        connect(root.right); // from right to left
        connect(root.left);
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

}
