package algo.leetCode;

import algo.util.TreeNode;

public class Q110_BalancedBinaryTree {
    private int depth(TreeNode root){
        if (root == null)
            return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root){
        if (root == null)
            return true;

        int diff = depth(root.left) - depth(root.right);
        if (diff > 1 || diff < -1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }
}
