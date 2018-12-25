package algo.leetCode;

import algo.util.TreeNode;

public class Q124_BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        getMaxSumWithCurNode(root, maxSum);
        return maxSum;
    }


    int getMaxSumWithCurNode(TreeNode curNode, int maxSum){
        int lmax = 0, rmax = 0;
        int value = curNode.val; // 包含当前节点的最大路径和
        if(curNode.left != null){
            lmax = getMaxSumWithCurNode(curNode.left, maxSum);
        }
        if(curNode.right != null){
            rmax = getMaxSumWithCurNode(curNode.right, maxSum);
        }

        value = value + (lmax>0?lmax:0) + (rmax>0?rmax:0) ;
        if(value > maxSum)
            maxSum = value;
        // 注意这里的返回值，取左右子树其中一条路径
        return curNode.val+Math.max( lmax>0?lmax:0, rmax>0?rmax:0 );

    }

    public static void main(String[] args){
        Q124_BinaryTreeMaximumPathSum solution = new Q124_BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        int maxSum = solution.maxPathSum(root);
        System.out.println(maxSum);

    }
}
