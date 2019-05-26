package algo.Sword;

import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 之字形水平打印二叉树
 *                          1
 *                   2             3
 *              4       5       6      7
 *           8   9    10 11   12 13  14 15
 *
 */
public class Q032_3_PrintTreesInZigzag {

    public void printInZigZag(TreeNode root){
        if (root == null)
            return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Stack<TreeNode>> list = new ArrayList<>();
        list.add(stack1);
        list.add(stack2);
        int cur = 0;
        int next = 1;
        list.get(cur).push(root);

        while (!list.get(0).isEmpty() || !list.get(1).isEmpty()){
            TreeNode node = list.get(cur).pop();
            System.out.print(node.val + " ");

            if (cur == 0){ // 第一层， 第三层
                // 下一层（子节点），先存左，再存右，因为栈是后进先出，子节点先打印右，再是左
                if (node.left != null){
                    list.get(next).push(node.left);
                }
                if (node.right != null){
                    list.get(next).push(node.right);
                }
            } else { // 第二层，第四层
                // 下一层（子节点），先存右，再存左
                if (node.right != null){
                    list.get(next).push(node.right);
                }
                if (node.left != null){
                    list.get(next).push(node.left);
                }
            }

            if (list.get(cur).empty()){
                System.out.println();
                cur = 1 - cur;
                next = 1 - next;
            }

        }
    }

    public static void main(String[] args){
        Q032_3_PrintTreesInZigzag solution = new Q032_3_PrintTreesInZigzag();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);

        solution.printInZigZag(root);
    }
}
