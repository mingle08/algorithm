package algorithm.leetCode;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.util.TreeNode;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class LeetCode111_MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root){
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0)
            return left + right + 1;
        return Math.min(left, right) + 1;
    }

    // 方法2
    int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root本身就是一层，将depth初始化为1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                /* 判断是否到达终点 */
                if (cur.left == null && cur.right == null)
                    return depth;
                /* 将cur的相邻节点加入队列 */
                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            /* 在这里增加步数 */
            depth++;
        }
        return depth++;
    }

    public static void main(String[] args) {
        LeetCode111_MinimumDepthOfBinaryTree solution = new LeetCode111_MinimumDepthOfBinaryTree();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        int depth = solution.minDepth(node1);
        System.out.println(depth);
        depth = solution.minDepth2(node1);
        System.out.println(depth);
    }
}
