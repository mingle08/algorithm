package algorithm.leetCode;

import algorithm.util.TreeNode;

/**
 * 搜索二叉树的中序遍历是有序数列。如果遍历结果是1、8、4、6、7、2、11，
 * 就知道是第二个结点和第6个结点反掉了。 在中序遍历输出的地方进行判断，如果是错误节点，就保留该节点
 * 如果遍历整个序列过程中只出现了一次顺序错误，说明就是这两个相邻节点需要被交换。
 * 如果出现了两次次序错误，那就需要交换这两个节点。
 */
public class LeetCode099_RecoverBinarySearchTree {

    public class Solution {
        TreeNode mistake1,mistake2;
        TreeNode pre=new TreeNode(Integer.MIN_VALUE);

        public void recoverTree(TreeNode root) {
            inorderTraversal(root);
            int temp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = temp;
        }
        private void inorderTraversal(TreeNode root) {
            if(root == null){
                return;
            }
            inorderTraversal(root.left);
            //中序遍历中间处理
            if(mistake1 == null && pre.val >= root.val){
                mistake1 = pre;
            }

            if(mistake1 != null && pre.val >= root.val){ // 注意，二次都是判断mistake1是不是null
                mistake2 = root;  // 说明有二处错误，不是第一次的相邻位置
            }
            pre = root;
            //处理结束
            inorderTraversal(root.right);

        }
    }
}
