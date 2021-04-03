package algo.codingInterviewChinese2;

import algo.util.TreeNode;

/**
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。
 */
public class Q026_SubstructureInTree {
    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            // 如果发现树A某一节点的值和树B的头节点的值相同，则调用doesTree1HaveTree2，进行第二步判断
            if (root1.val == root2.val) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    private boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
    }
}
