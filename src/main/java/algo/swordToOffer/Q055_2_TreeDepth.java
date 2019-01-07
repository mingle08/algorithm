package algo.swordToOffer;

import algo.util.TreeNode;

/**
 * 判断一棵树是不是平衡二叉树
 * 后序遍历
 */
public class Q055_2_TreeDepth {
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
