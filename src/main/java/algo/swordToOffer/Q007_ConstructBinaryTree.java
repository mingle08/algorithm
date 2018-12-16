package algo.swordToOffer;

import algo.util.TreeNode;

/**
 * 根据前序序列和中序序列来构建二叉树
 */
public class Q007_ConstructBinaryTree {

    public static TreeNode constructe(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0 || preOrder.length != inOrder.length) {
            return null;
        }

        // 二叉树的根节点
        TreeNode root = new TreeNode(preOrder[0]);
        root.left = null;
        root.right = null;
        // 左子树的个数
        int leftNum = 0;
        for (int i = 0;
             i < inOrder.length;
             i++) {
            if (root.val == inOrder[i]) {
                break;
            } else {
                leftNum++;
            } }
        // 右子树的个数
        int rightNum = inOrder.length - 1 - leftNum;
        // 重建左子树
        if (leftNum > 0) {
            //左子树的先序序列
            int[] leftPreOrder = new int[leftNum];
            //左子树的中序序列
            int[] leftInOrder = new int[leftNum];
            for (int i = 0;
                 i < leftNum;
                 i++) {
                leftPreOrder[i] = preOrder[i + 1];
                leftInOrder[i] = inOrder[i];
            }
            // 递归构建左子树
            TreeNode leftRoot = constructe(leftPreOrder, leftInOrder);

            root.left = leftRoot;
        }
        // 重构右子树
        if (rightNum > 0) {
            //右子树的先序序列
            int[] rightPreOrder = new int[rightNum];
            //右子树的中序序列
            int[] rightInOrder = new int[rightNum];
            for (int i = 0;
                 i < rightNum;
                 i++) {
                rightPreOrder[i] = preOrder[leftNum + 1 + i];
                rightInOrder[i] = inOrder[leftNum + 1 + i];
            }
            // 递归构建右子树
            TreeNode rightRoot = constructe(rightPreOrder, rightInOrder);

            root.right = rightRoot;
        }
        return root;
    }

    // 后序遍历，递归
    public static void postTraversal(TreeNode root){
        if (root != null){
            postTraversal(root.left);
            postTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public static void main(String[] args){
        // 前序序列
        int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
        // 中序序列
        int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode root = constructe(preOrder, inOrder);

        System.out.println(root.val);

        // 后序遍历
        postTraversal(root);

    }
}
