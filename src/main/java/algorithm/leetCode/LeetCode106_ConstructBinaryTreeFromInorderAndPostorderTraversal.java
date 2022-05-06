package algorithm.leetCode;

import algorithm.util.TreeNode;

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class LeetCode106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length - 1 ,postorder,0,postorder.length - 1 );
    }

    private TreeNode build(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd){
        if(inStart > inEnd || postStart > postEnd){
            return null ;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        for(int i = inStart ;
            i <= inEnd ;
            i++ ){
            if(inorder[i] == postorder[postEnd]){
                index = i ;
                break;
            }
        }
        root.left = build(inorder,inStart,index-1,postorder,postStart,postStart + (index-inStart) -1);
        root.right = build(inorder,index+1,inEnd,postorder,postStart + (index - inStart),postEnd-1);
        return root ;
    }

    public void preorderTraversal(TreeNode root){
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void main(String[] args){
        LeetCode106_ConstructBinaryTreeFromInorderAndPostorderTraversal solution = new LeetCode106_ConstructBinaryTreeFromInorderAndPostorderTraversal();

        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode root = solution.buildTree(inorder, postorder);

        solution.preorderTraversal(root);
    }


}
