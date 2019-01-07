package algo.leetCode;

import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *
 * return
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class LeetCode113_PathSumII {

    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        //定义一个结果集合
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //定义一个中间集合
        List<Integer> temp = new ArrayList<>();
        path(root, list, temp, sum);
        return list;
    }

    public void path(TreeNode root, List<List<Integer>> list, List<Integer> temp, int nowSum) {
        //将当前节点的值加入中间集合中
        temp.add(root.val);
        nowSum -= root.val;
        if (root.left == null && root.right == null) {
            if (nowSum == 0) {
                //如果当前节点无子女，就判断该路径是否符合要求，如果符合那么就将该路径加入结果集合中
                list.add(new ArrayList<Integer>(temp));
            }
            //遍历完一条路径就回到调用点，这里也可以不写return，也会自动返回。但是加return可以略微提高效率。
            return;
        }
        // 左子树
        if (root.left != null) {
            path(root.left, list, temp, nowSum);
            temp.remove(temp.size() - 1);     // 函数返回后，要将中间集合最后一个元素删除（回溯）
        }
        // 右子树
        if (root.right != null) {
            path(root.right, list, temp, nowSum);
            temp.remove(temp.size() - 1);     // 函数返回后，要将中间集合最后一个元素删除（回溯）
        }
    }

    public static void main(String[] args){
        LeetCode113_PathSumII solution = new LeetCode113_PathSumII();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> res = solution.pathSumII(root, 22);
        
        System.out.println(res);
    }

}
