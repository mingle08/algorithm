package algorithm.codingInterviewChinese2;

import algorithm.util.TreeNode;

/**
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。
 */
public class Q026_SubstructureInTree {
    // 递归
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            // 如果发现树A某一节点的值和树B的头节点的值相同，则调用doesTree1HasTree2，进行第二步判断
            if (root1.val == root2.val) {
                result = doesTree1HasTree2(root1, root2);
            }
            if (!result) {
                // root1的左子树是否包含root2
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                // root1的右子树是否包含root2
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        // 走到这一步，说明root1 != null && root2 != null && root1 == root2，所以接下来，要比较左子树和右子树
        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}
