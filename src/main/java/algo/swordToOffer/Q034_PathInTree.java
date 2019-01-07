package algo.swordToOffer;

import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q034_PathInTree {
    public List<List<Integer>> findPath(TreeNode root, List<List<Integer>> res,
                                        List<Integer> path, int expectedSum){

        if (root == null)
            return res;

        int curSum = 0;
        res = findPathCore(root, res,  path, expectedSum, curSum);

        return res;
    }

    private List<List<Integer>> findPathCore(TreeNode root,  List<List<Integer>> res,
                                             List<Integer> path, int expectedSum,int curSum){

        curSum += root.val;
        path.add(root.val);

        // 如果是叶节点，并且路径上节点值的和等于输入的值
        // 则打印出这条路径
        boolean isLeaf = root.left == null && root.right == null;
        if (curSum == expectedSum && isLeaf){
            res.add(new ArrayList<>(path));
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

    public static void main(String[] args){
        Q034_PathInTree solution = new Q034_PathInTree();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        res = solution.findPath(root, res, path, 22);

        System.out.println(res);

    }
}
