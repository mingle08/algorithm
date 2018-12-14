package algo.leetCode;

/**
 * 二叉树的中序遍历
 * 附上前序，后序遍历
 */

import java.util.*;

/**
 *                         4
 *
 *                   2          6
 *
 *              1      3     5       7
 */
public class Q094_BinaryTreeInorderTraversal {

    // 创建二叉树
    public TreeNode createBinaryTree() {
        TreeNode nodeA = new TreeNode(4);
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(6);
        TreeNode nodeD = new TreeNode(1);
        TreeNode nodeE = new TreeNode(3);
        TreeNode nodeF = new TreeNode(5);
        TreeNode nodeG = new TreeNode(7);
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;

        return nodeA;
    }

    public static void printTreeNode(TreeNode node){
        System.out.print(node.val + " ");

    }

    // 前序  非递归
    public void preOrderTraversal(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0){
            // 将所有左孩子压栈
            if (node != null){
                printTreeNode(node);    // 访问
                stack.push(node);    // 压栈
                node = node.left;
            } else {
                node = stack.pop();    // 出栈
                node = node.right;
            }
        }
    }

    // 中序  非递归
    public void inOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || stack.size() > 0){
            if (node != null){
                stack.push(node);  // 压栈
                node = node.left;
            } else {
                node = stack.pop();  // 出栈
                printTreeNode(node);  // 访问
                node = node.right;
            }
        }
    }

    // 后序  非递归
    public void nonRecPostOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> output = new Stack<TreeNode>();  //按出栈顺序将元素装入此栈中
        TreeNode node = root;
        while(node != null || stack.size()>0){
            if(node != null){
                output.push(node);
                stack.push(node);    // 压栈
                node = node.right;
            }else{
                node = stack.pop();  // 出栈
                node = node.left;
            }
        }

        // 访问
        while(output.size()>0){
            TreeNode out = output.pop();
            System.out.print(out.val + " ");
        }
    }

    public static void main(String[] args){
        Q094_BinaryTreeInorderTraversal solution = new Q094_BinaryTreeInorderTraversal();
        TreeNode root = solution.createBinaryTree();

        solution.inOrderTraversal(root);
    }


}

