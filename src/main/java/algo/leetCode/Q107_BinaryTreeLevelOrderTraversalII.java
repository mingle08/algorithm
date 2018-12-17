package algo.leetCode;

import algo.util.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q107_BinaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        List<TreeNode> nodeList = new ArrayList();
        if(root == null)
            return res;
        nodeList.add(root);
        while(!nodeList.isEmpty()){
            List<Integer> curList = new ArrayList();//每次当前层节点都要重新初始化
            List<TreeNode> nextList = new ArrayList();//初始化下一层所有节点的nodeList
            for(TreeNode cur:nodeList){//cur是当前节点，nodeList是当前层的所有节点
                curList.add(cur.val);
                if(cur.left!=null)
                    nextList.add(cur.left);//下一层节点
                if(cur.right!=null)
                    nextList.add(cur.right);//下一层节点
            }
            nodeList = nextList;
            res.add(0,curList);//当前层所有节点的nodeList倒插进返回结果中
        }
        return res;
    }

    /**
     * [3,9,20,null,null,15,7]
     * @param args
     */
    public static void main(String[] args){
        Q107_BinaryTreeLevelOrderTraversalII solution = new Q107_BinaryTreeLevelOrderTraversalII();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solution.levelOrderBottom(root);

        System.out.println(result);


    }
}
