package algorithm.leetCode;

import algorithm.util.TreeNode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class LeetCode112_PathSum {

    public boolean hasPath(TreeNode root, int sum){
        if (root == null)
            return false;
        if (root.left == null && root.right == null){
            if (root.val == sum)
                return true;
            return false;
        }

        boolean result;
        // 左子树
        result = hasPath(root.left, sum - root.val);
        if (result == true)
            return true;

        // 右子树
        result = hasPath(root.right, sum - root.val);
        if (result == true)
            return true;

        return false;
    }
}
