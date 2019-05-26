package algo.swordToOffer;

import algo.util.TreeNode;

public class Q055_1_TreeDepth {
    public int depth(TreeNode root){
        if (root == null)
            return 0;

        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }
}
