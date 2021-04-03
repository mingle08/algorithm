package algo.codingInterviewChinese2;

import algo.util.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 例如，输入图中的二叉树和整数22，则打印出两条路径，第一条路径包含节点10和12，
 * 第二条路径包含节点10、5、7
 *
 *          10
 *      5       12
 *   4    7
 */
public class Q034_PathInTree {
    public List<List<Integer>> findPath(BinaryTreeNode root, List<List<Integer>> res,
                                        List<Integer> path, int expectedSum) {

        if (root == null)
            return res;

        int curSum = 0;
        return findPathCore(root, res, path, expectedSum, curSum);
    }

    private List<List<Integer>> findPathCore(BinaryTreeNode root, List<List<Integer>> res,
                                             List<Integer> path, int expectedSum, int curSum) {

        curSum += root.val;
        path.add(root.val);

        // 如果是叶节点，并且路径上节点值的和等于输入的值
        // 则打印出这条路径
        boolean isLeaf = root.left == null && root.right == null;
        if (curSum == expectedSum && isLeaf) {
            res.add(path);
        }

        // 如果不是叶节点，则遍历它的子节点
        if (root.left != null)
            findPathCore(root.left, res, path, expectedSum, curSum);

        if (root.right != null)
            findPathCore(root.right, res, path, expectedSum, curSum);

        // 在返回父节点之前，在路径上删除当前节点
        path.remove(path.size() - 1);

        return res;
    }

    public static void main(String[] args) {
        Q034_PathInTree solution = new Q034_PathInTree();

        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        res = solution.findPath(root, res, path, 22);

        System.out.println(res);

    }
}
