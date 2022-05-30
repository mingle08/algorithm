package algorithm.labuladong.chapter3;

import algorithm.util.TreeNode;

/**
 * 二叉树的最近公共祖先
 * 输入一棵树以root为根的二叉树和该二叉树上的2个节点p和q，请计算这2个节点的最近公共祖先
 *
 * 递归什么时候终止退出？
 * 当节点不是叶子节点，或节点值不等于p或q时，会一直递归
 * 当节点是叶子节点，或节点值等于p或q时返回上层递归
 *
 * 本题例子，最后退回到root是3，即根节点，左是5，右是null，是情况3，所以返回不是null的那个，也就是5
 */
public class L306_LowestCommonAncestor {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 两种情况的base case
        // 在递归过程中，这2句是用来退出递归回到上一层的
        if (root == null) return null;
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 情况1
        if (left != null && right != null) {
            return root;
        }

        // 情况2：叶子节点的左和右都为null
        if (left == null && right == null) {
            return null;
        }

        // 情况3
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        root.left = node5;
        root.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        TreeNode lca = lowestCommonAncestor(root, node6, node4);

        System.out.println(node6.val + "和" + node4.val + "的最小公共祖先是：" + lca.val);

    }
}
