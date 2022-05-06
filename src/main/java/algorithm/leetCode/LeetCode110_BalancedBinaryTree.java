package algorithm.leetCode;

import algorithm.util.TreeNode;

public class LeetCode110_BalancedBinaryTree {
    private int depth(TreeNode root){
        if (root == null)
            return 0;

        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    // 方法1：一个节点会被重复遍历多次
    /*public boolean isBalanced(TreeNode root){
        if (root == null)
            return true;

        int diff = depth(root.left) - depth(root.right);
        if (diff > 1 || diff < -1)
            return false;

        return isBalanced(root.left) && isBalanced(root.right);

    }*/

    // 方法2：后序遍历
    private boolean isBalancedPostOrder(TreeNode root, int depth){
        if (root == null){
            depth = 0;
            return true;
        }

        int leftDepth = 0, rightDepth = 0;
        // 先遍历左子树，再遍历右子树
        if (isBalancedPostOrder(root.left, leftDepth)
                && isBalancedPostOrder(root.right, rightDepth)){
            int diff = leftDepth - rightDepth;
            if (diff <= 1 || diff >= -1){
                depth = 1 + (diff > 0 ? leftDepth : rightDepth);
                return true;
            }
        }

        return false;
    }

    public boolean isBalanced(TreeNode root){
        int depth = 0;
        return isBalancedPostOrder(root, depth);
    }


}
