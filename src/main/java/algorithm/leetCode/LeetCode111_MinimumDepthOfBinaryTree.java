package algorithm.leetCode;

import algorithm.util.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class LeetCode111_MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root){
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        else {
            int leftDepth = minDepth(root.left) + 1;
            int rightDepth = minDepth(root.right) + 1;
            return 1 + (leftDepth < rightDepth ? leftDepth : rightDepth);
        }
    }
}
