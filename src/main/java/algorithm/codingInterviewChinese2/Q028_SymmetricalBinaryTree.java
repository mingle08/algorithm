package algorithm.codingInterviewChinese2;

import algorithm.util.TreeNode;

/**
 * 对称的二叉树
 * 题目：请实现一个函数，用来判断一棵二叉树是不是对称。如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Q028_SymmetricalBinaryTree {

    public boolean isSymmetrical(TreeNode root) {
        return isSymmetrical(root, root);
    }

    boolean isSymmetrical(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.val != root2.val) {
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
}
