package algorithm.codingInterviewChinese2;

import algorithm.util.BinaryTreeNode;

/**
 * 判断一棵树是不是平衡二叉树
 * 后序遍历
 */
public class Q055_2_BalancedBinaryTree {
    public int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        // 遍历左子树
        int left = treeDepth(root.left);
        if (left == -1) {
            return -1;
        }
        // 遍历右子树
        int right = treeDepth(root.right);
        if (right == -1) {
            return -1;
        }
        // 绝对值相差是否大于1
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }
    }

    public boolean isBalanced(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        return treeDepth(root) != -1;
    }
}
