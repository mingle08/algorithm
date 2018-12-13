package algo.leetCode;

import java.util.Stack;

public class Q098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val)
                return false;
            pre = root;
            root = root.right;
        }
        return true;
    }



    public boolean isValidBST2(TreeNode root) {
        return isValid(root, null, null);
    }

    public boolean isValid(TreeNode root, Integer min, Integer max) {
        if(root == null)
            return true;
        if(min != null && root.val <= min)
            return false;
        if(max != null && root.val >= max)
            return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
}