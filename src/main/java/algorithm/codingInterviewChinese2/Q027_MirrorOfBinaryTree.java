package algorithm.codingInterviewChinese2;

import algorithm.util.TreeNode;

/**
 * 二叉树的镜像
 * 题目：请完成一个函数，输入一棵二叉树，该函数输出它的镜像
 *
 * 思路：
 * 前序遍历这棵树的每个节点，如果遍历到的节点有子节点，就交换它的两个子节点。
 * 当交换完所有非叶节点的左右子节点之后，就得到了树的镜像
 */
public class Q027_MirrorOfBinaryTree {

    public void mirrorRecursively(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }

        // 交换左子节点与右子节点
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) {
            mirrorRecursively(node.left);
        }
        if (node.right != null) {
            mirrorRecursively(node.right);
        }
    }
}
