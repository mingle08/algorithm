package algo.leetCode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q105_constructBinaryTreeFromPreorderAndInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder,inorder,0,0,inorder.length-1);
    }
    public TreeNode build(int[] pre, int[] in, int preStart,int inStart,int inEnd){
        if(preStart > pre.length - 1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int rootIndex = 0; //记录中序遍历中的根节点的位置
        for(int i = inStart; i <= inEnd; i++){
            if(root.val == in[i]){
                rootIndex = i;
                break;
            }
        }
        root.left = build(pre,in,preStart + 1, inStart,rootIndex - 1);//找出左子树的各个位置
        root.right = build(pre,in,preStart + rootIndex - inStart + 1,rootIndex + 1,inEnd);//找出右子树的各个位置
        return root;
    }
}
