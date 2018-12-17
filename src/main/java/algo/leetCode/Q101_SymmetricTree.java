package algo.leetCode;

import algo.util.TreeNode;

/**
 * 判断一棵树是不是对称的：
 * 1. 树是空的，true。
 * 2. 判断这棵树的左子树和右子树是否对称。
 * 3. 两棵子树的对称条件：
 *    （1）根节点相等，
 *    （2）左子树的左子树和右子树的右子树对称，
 *    （3）左子树的右子树和右子树的左子树对称
 */
public class Q101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        else {
            return isSymmetric(root.left, root.right);
        }
    }
    private boolean isSymmetric(TreeNode leftChild, TreeNode rightChild) {
        if (leftChild == null && rightChild == null) {
            return true;
        }
        else if (leftChild == null || rightChild == null) {
            return false;
        }
        return leftChild.val == rightChild.val
                && isSymmetric(leftChild.left, rightChild.right)
                && isSymmetric(leftChild.right, rightChild.left);
    }
}
