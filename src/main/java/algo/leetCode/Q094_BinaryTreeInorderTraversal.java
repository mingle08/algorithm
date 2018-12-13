package algo.leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *                         1
 *
 *                   2          3
 *
 *              4      5     6       7
 */
public class Q094_BinaryTreeInorderTraversal {

    // 中序 递归
    public void inorderRecursive(TreeNode node){
        inorderRecursive(node.left);
        System.out.println(node.val);
        inorderRecursive(node.right);
    }

    // 中序   非递归
    public void inorderTraversal(TreeNode node){
        if(node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //
        Queue<Integer> q = new LinkedList<Integer>();
        TreeNode pCur = node;
        TreeNode outNode = null;
        while(pCur != null){
            stack.push(pCur);
            pCur=pCur.left;    // 遍历到左边叶节点时，pCur.left == null， 才进入下一步while

            // 上一步遍历左子树到底之后，再没有左子节点了，pCur.left为null
            while(pCur == null && !stack.isEmpty()){
                pCur = stack.peek();
                outNode = stack.pop();
                q.add(outNode.val);//
//               System.out.println(outNode.getData());
                pCur = pCur.right;
            }
        }
        for(Integer i : q)
            System.out.print(i+" ");
    }

    public TreeNode createBinaryTree() {
        TreeNode nodeA = new TreeNode(1);
        TreeNode nodeB = new TreeNode(2);
        TreeNode nodeC = new TreeNode(3);
        TreeNode nodeD = new TreeNode(4);
        TreeNode nodeE = new TreeNode(5);
        TreeNode nodeF = new TreeNode(6);
        TreeNode nodeG = new TreeNode(7);
        nodeA.left = nodeB;
        nodeA.right = nodeC;
        nodeB.left = nodeD;
        nodeB.right = nodeE;
        nodeC.left = nodeF;
        nodeC.right = nodeG;

        return nodeA;
    }

    public static void main(String[] args){
        Q094_BinaryTreeInorderTraversal solution = new Q094_BinaryTreeInorderTraversal();
        TreeNode root = solution.createBinaryTree();

        solution.inorderTraversal(root);
    }


}
