package algo.leetCode;

import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q095_UniqueBinarySearchTreeII {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            TreeNode[] resarr =  recursion(1, n, dp);
            List<TreeNode> res = new ArrayList<>();
            for (TreeNode node : resarr) {
                res.add(node);
            }
            return res;
        }
    }

    public TreeNode[] recursion (int s, int e, int[] dp) {
        TreeNode[] roots = null;
        int curlen = 0;
        if (s > e) {
            roots = new TreeNode[1];
            roots[0] = null;
            return roots;
        }
        roots = new TreeNode[dp[e - s + 1]];
        for (int i = s; i <= e; i++) {
            TreeNode[] lefts = recursion(s, i - 1, dp);  //递归构造左子树
            TreeNode[] rights = recursion(i + 1, e, dp);  //递归构造右子树
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    roots[curlen++] = root;
                }
            }
        }

        return roots;
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public List<TreeNode> generateTrees2(int n) {
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(n<1){
            return res;
        }

        return helper(1,n);
    }

    private List<TreeNode> helper(int left, int right){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(left > right){
            res.add(null);
            return res;
        }

        for(int i = left; i<=right; i++){
            // 以 i 为根节点的树，左孩子的值都小于 i，即在[1, i-1]区间
            List<TreeNode> leftRes = helper(left,i-1);
            // 以 i 为根节点的树，右孩子的值都大于 i，即在[i+1, n]
            List<TreeNode> rightRes = helper(i+1, right);

            //从leftRes中挨个取结果，配合从rightRes中挨个取结果后分别放在以i为root的左右子树上
            for(int m = 0; m<leftRes.size(); m++){
                for(int n = 0; n<rightRes.size(); n++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftRes.get(m);
                    root.right = rightRes.get(n);
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Q095_UniqueBinarySearchTreeII solution = new Q095_UniqueBinarySearchTreeII();

        List<TreeNode> res = solution.generateTrees2(3);

        System.out.println(res.size());

    }

}
