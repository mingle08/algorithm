package algo.codingInterviewChinese2;

import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 题目三：之字形水平打印二叉树
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层
 * 按照从右向左的顺序打印，第三行再按照从左到右的顺序打印，其它行以此类推。
 * 例如，按之字形打印如下的二叉树的结果为：
 *  1
 *  3  2
 *  4  5  6  7
 *  15 14 13 12 11 10 9 8
 *
 *  二叉树如下图
 *
 *                  1
 *           2             3
 *      4       5       6      7
 *   8   9    10 11   12 13  14 15
 *
 *
 *   思路：使用2个栈。
 *   如果当前打印的是奇数层（第一层、第三层等），则先保存左子节点再保存右子节点（先左后右）到第一个栈里；
 *   如果当前打印的是偶数层（第二层、第四层等），则先保存右子节点再保存左子节点（先右后左）到第二个栈里。
 *
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
