package algo.codingInterviewChinese2;


import algo.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 分行从上到下打印二叉树
 * 思路：增加2个变量，一个是当前层还未打印的节点数，另一个是下一层的节点数
 */
public class Q032_2_PrintTreeInLines {

    public void print(TreeNode root){
        if (root == null)
            return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int toBePrinted = 1;  // 当前层还未打印的节点数
        int nextLevelCount = 0;  // 下一层的节点数

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null){
                queue.add(node.right);
                nextLevelCount++;
            }

            toBePrinted--;
            // 每打印完一层，另起一行，重新给2个变量赋值
            if (toBePrinted == 0){
                // 另起一行打印
                System.out.println();
                // 换行之后，待打印的节点数，初始化为nextLevelCount
                toBePrinted = nextLevelCount;
                // 再下一行，节点数初始化为0
                nextLevelCount = 0;
            }
        }
    }

    public static void main(String[] args){
        Q032_2_PrintTreeInLines solution = new Q032_2_PrintTreeInLines();

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        solution.print(root);
    }
}
