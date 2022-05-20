package algorithm.codingInterviewChinese2;

import algorithm.util.TreeNode;

public class Q055_1_TreeDepth {
    public static int calcDepth(TreeNode root){
        // 递归回退条件
        if (root == null)
            return 0;

        int leftDepth = calcDepth(root.left);
        int rightDepth = calcDepth(root.right);

        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        int depth = calcDepth(node1);
        System.out.println(depth);
    }
}
