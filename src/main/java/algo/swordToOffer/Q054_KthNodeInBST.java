package algo.swordToOffer;

import algo.util.TreeNode;

import java.util.LinkedList;

public class Q054_KthNodeInBST {
    /*private LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    public TreeNode findKthNode(TreeNode root, int k){
        findKthNodeCore(root);
        if(list.size() < k || k < 1) return null;
        else {
            return list.get(k-1);
        }
    }

    private void findKthNodeCore(TreeNode root){
        TreeNode target = null;
        if (root.left != null)
            findKthNodeCore(root.left);

        list.add(root);

        if (root.right != null)
            findKthNodeCore(root.right);

    }*/

    public TreeNode findKthNode(TreeNode root, int k){
        if (root == null || k == 0)
            return null;

        return doFindKthNode(root, 3);
    }

    private TreeNode doFindKthNode(TreeNode root, int k){
        TreeNode target = null;
        if (root.left != null)
            target = doFindKthNode(root.left, k);

        if (target != null)
            return target;

        /**
         * 每进入一层递归，k减1，因为如果是找第3个数，就是下一层递归的第2个数，再下一层递归的第1个数
         * 当k等于1时，这个数就是目标值
         */

        k--;
        if (k == 1)
            target = root;

        if (target == null && root.right != null)
            target = doFindKthNode(root.right, k);

        return target;
    }

    public static void main(String[] args){
        Q054_KthNodeInBST solution = new Q054_KthNodeInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        TreeNode target = solution.findKthNode(root, 3);
        System.out.println(target.val);
    }
}
