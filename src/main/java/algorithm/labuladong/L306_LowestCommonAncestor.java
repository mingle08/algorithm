package algorithm.labuladong;

import algorithm.util.TreeNode;

public class L306_LowestCommonAncestor {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 两种情况的base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况1
        if (left != null && right != null) {
            return root;
        }

        // 情况2
        if (left == null && right == null) {
            return null;
        }

        // 情况3
        return left == null ? right : left;
    }
}
