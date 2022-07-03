package algorithm.codingInterviewChinese2;

import algorithm.util.TreeNode;

import java.util.*;

/**
 * 分行从上到下打印二叉树
 * 思路：
 * （1）队列
 * （2）用一个变量size记录当前层有没有处理完
 */
public class Q032_2_PrintTreeInLines {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        int size = 0;
        q.add(root);
        while (!q.isEmpty()) {
            size = q.size();
            while (size > 0) {
                TreeNode cur = q.poll();
                temp.add(cur.val);

                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }


                size--;
            }
            // 循环结束，说明这层已遍历完成
            res.add(new ArrayList<>(temp));
            temp.clear();
        }

        return res;
    }

    public static void main(String[] args){
        Q032_2_PrintTreeInLines solution = new Q032_2_PrintTreeInLines();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;


        List<List<Integer>> res = solution.levelOrder(root);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
