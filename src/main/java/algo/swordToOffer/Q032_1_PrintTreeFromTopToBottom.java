package algo.swordToOffer;


import algo.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 不分行从上到下打印二叉树
 */
public class Q032_1_PrintTreeFromTopToBottom {

    public void print(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }

        }
    }

    public static void main(String[] args){
        Q032_1_PrintTreeFromTopToBottom solution = new Q032_1_PrintTreeFromTopToBottom();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        solution.print(root);
    }
}
