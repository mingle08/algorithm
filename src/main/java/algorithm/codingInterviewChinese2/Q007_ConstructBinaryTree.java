package algorithm.codingInterviewChinese2;

import algorithm.util.TreeNode;

/**
 * 根据前序序列和中序序列来构建二叉树
 * 二叉树(nil表示空）
 *                     1
 *               2             3
 *          4     nil     5         6
 *      nil    7      nil  nil    8    nil
 *
 * 前序遍历序列  {1, 2, 4, 7, 3, 5, 6, 8}
 *             Root
 *
 * 中序遍历序列  {4, 7, 2, 1, 5, 3, 8, 6}
 *                       Root
 *
 * 分析：
 * 1，前序遍历序列中，第一个数，就是根节点Root，
 * 2，找到中序遍历中的根节点，左侧是左子树，有3个左子节点，右侧是右子树，有4个右子节点
 * 3，前序遍历序列中，左子树和右子树也是按前序遍历的；中序遍历序列中，左子树和右子树也是按中序遍历的
 * 4，递归
 */
public class Q007_ConstructBinaryTree {

    public static TreeNode construct(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0
                || inOrder.length == 0 || preOrder.length != inOrder.length) {
            return null;
        }

        // 1，求出二叉树的根节点
        TreeNode root = new TreeNode(preOrder[0]);
        root.left = null;
        root.right = null;
        // 2，求出左子树的个数
        int leftNum = 0;
        for (int j : inOrder) {
            if (root.val == j) {
                break;
            } else {
                leftNum++;
            }
        }
        // 3，求出右子树的个数
        int rightNum = inOrder.length - 1 - leftNum;
        // 4，重建左子树
        if (leftNum > 0) {
            // 4.1 左子树的先序序列
            int[] leftPreOrder = new int[leftNum];
            //4.2 左子树的中序序列
            int[] leftInOrder = new int[leftNum];
            for (int i = 0; i < leftNum; i++) {
                leftPreOrder[i] = preOrder[i + 1];    // 因为第一位是根节点，所以是 i + 1
                leftInOrder[i] = inOrder[i];
            }
            // 4.3 递归构建左子树
            TreeNode leftRoot = construct(leftPreOrder, leftInOrder);

            root.left = leftRoot;
        }
        // 5，重构右子树
        if (rightNum > 0) {
            // 5.1 右子树的先序序列
            int[] rightPreOrder = new int[rightNum];
            // 5.2 右子树的中序序列
            int[] rightInOrder = new int[rightNum];
            for (int i = 0;  i < rightNum; i++) {
                rightPreOrder[i] = preOrder[leftNum + 1 + i];    // 根节点和左子树都在左侧
                rightInOrder[i] = inOrder[leftNum + 1 + i];
            }
            // 5.3 递归构建右子树
            TreeNode rightRoot = construct(rightPreOrder, rightInOrder);

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

        TreeNode root = construct(preOrder, inOrder);

        System.out.println(root.val);

        // 后序遍历
        postTraversal(root);

    }
}
