package algo.leetCode;


import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q103_BinaryTreeZigzagLevelOrderTraversal {

    // 二个栈
    public void printInZigZagLevel(TreeNode root){
        if (root == null)
            return;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<algo.util.TreeNode> stack2 = new Stack<>();
        List<Stack<TreeNode>> list = new ArrayList<>();
        list.add(stack1);
        list.add(stack2);
        int cur = 0;
        int next = 1;
        list.get(cur).push(root);

        while (!list.get(0).isEmpty() || !list.get(1).isEmpty()){
            algo.util.TreeNode node = list.get(cur).pop();
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
    
    // 递归
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new LinkedList<>();
        levelRecursion(root, res, 0);
        return res;
    }

    private void levelRecursion(TreeNode node, List<List<Integer>> result, int level){
        if (node == null)
            return;
        if (result.size() < level + 1){
            result.add(new LinkedList<Integer>());
        }
        if (level % 2 != 0){
            ((LinkedList<Integer>) result.get(level)).addFirst(node.val);
        } else {
            result.get(level).add(node.val);
        }

        levelRecursion(node.left, result, level + 1);
        levelRecursion(node.right, result, level + 1);
    }

    public static void main(String[] args){
        Q103_BinaryTreeZigzagLevelOrderTraversal solution = new Q103_BinaryTreeZigzagLevelOrderTraversal();

        algo.util.TreeNode root = new algo.util.TreeNode(1);
        root.left = new algo.util.TreeNode(2);
        root.right = new algo.util.TreeNode(3);
        root.left.left = new algo.util.TreeNode(4);
        root.left.right = new algo.util.TreeNode(5);
        root.right.left = new algo.util.TreeNode(6);
        root.right.right = new algo.util.TreeNode(7);
        root.left.left.left = new algo.util.TreeNode(8);
        root.left.left.right = new algo.util.TreeNode(9);
        root.left.right.left = new algo.util.TreeNode(10);
        root.left.right.right = new algo.util.TreeNode(11);
        root.right.left.left = new algo.util.TreeNode(12);
        root.right.left.right = new algo.util.TreeNode(13);
        root.right.right.left = new algo.util.TreeNode(14);
        root.right.right.right = new TreeNode(15);

        solution.printInZigZagLevel(root);

        System.out.println("====递归方法=======");

        List<List<Integer>> res = solution.zigzagLevelOrder(root);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++) {
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
