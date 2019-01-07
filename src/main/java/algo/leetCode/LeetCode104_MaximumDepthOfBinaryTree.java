package algo.leetCode;

import algo.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode104_MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root){
        if (root == null)
            return 0;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int toBePrinted = 1;
        int next = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            toBePrinted--;
            if (node.left != null){
                queue.add(node.left);
                next++;
            }
            if (node.right != null){
                queue.add(node.right);
                next++;
            }

            if (toBePrinted == 0){
                toBePrinted = next;
                next = 0;
                level++;
            }
        }
        return level;
    }
}
