package algo.leetCode;

import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 层序遍历
 * 树为{3, 9, 20, null, null, 15, 7}
 *         3
 *      9      20
 *           15   7
 * 遍历的结果：{3,{9,20},{15,7}}
 */
public class Q102_BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size > 0){
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null){
                    queue.add(temp.left);
                }
                if (temp.right != null){
                    queue.add(temp.right);
                }
                size--;
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args){
        Q102_BinaryTreeLevelOrderTraversal solution = new Q102_BinaryTreeLevelOrderTraversal();
        // 把树构建起来
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = solution.levelOrder(root);

        System.out.println(res.size());
    }
}
