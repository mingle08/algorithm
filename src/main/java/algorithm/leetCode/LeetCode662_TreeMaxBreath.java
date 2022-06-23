package algorithm.leetCode;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.util.TreeNode;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 *
 * 层序遍历
 */
public class LeetCode662_TreeMaxBreath {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        // 需要计算每一层的宽度, 并从中取最大值, 用BFS来做
        Queue<TreeNode> queue = new LinkedList<>();
        // 保存节点的索引值
        Queue<Integer> indexQueue = new LinkedList<>();
        int res = 1;
        queue.offer(root);
        // 索引从0开始
        indexQueue.offer(0);
        while (!queue.isEmpty()) {
            // 将这一层的拿出来
            int size = queue.size();
            int l = 0; // 该层第一个节点的下标
            int r = 0; // 该层最后一个节点的下标
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = indexQueue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    // 父节点的索引是index，则左子节点的索引是 2 * index + 1
                    indexQueue.offer(2 * index + 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    // 父节点的索引是index，则右子节点的索引是 2 * index + 1
                    indexQueue.offer(2 * index + 2);
                }
                if (i == 0) l = index;
                if (i == size - 1) r = index;
            }
            // 每一层都计算一下宽度，与res比较，取较大值
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode662_TreeMaxBreath treeMaxBreath = new LeetCode662_TreeMaxBreath();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(9);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;

        int breath = treeMaxBreath.widthOfBinaryTree(node1);
        System.out.println(breath);
    }
}
