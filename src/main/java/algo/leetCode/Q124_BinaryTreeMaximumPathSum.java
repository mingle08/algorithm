package algo.leetCode;

import algo.util.TreeNode;

/**
 * 题意及分析：一个二叉树，求以父子节点关系连接起来的最大路径。
 * 取当前点和左右边加和，当前点的值中最大的作为本层返回值。并在全局维护一个max。
 * 若路径经过一个点，那么对于当前点有四种情况，
 * (1) 一种是只经过该点就截止，
 * (2) 一种是该点加上左子节点的最大值，
 * (3) 另一种是该点加上右子节点的值，
 * (4) 最后一种是该点左右子树加上该点的值，
 * 比较四种情况就能得到在该点能取得的最大值，最后与全局的最大值比较。终能得到的结果就是最大值。
 */
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
