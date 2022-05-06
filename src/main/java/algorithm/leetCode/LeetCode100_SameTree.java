package algorithm.leetCode;

import algorithm.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 *
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 *
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 */
public class LeetCode100_SameTree {

    // 1. 递归
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        if((p!=null && q==null)||(p==null && q!=null)) return false;
        return p.val==q.val && isSameTree1(p.left,q.left) && isSameTree1(p.right,q.right);
    }

    // 2. 队列
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(p);
        queue.add(q);  //两个树的节点双双进队列
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();  //出队列，如果队列头为空，返回null
            TreeNode node2 = queue.poll();

            if(node1 == null && node2 == null)
                continue;
            else if(node1 == null || node2 == null || node1.val != node2.val)
                return false;

            queue.add(node1.left);
            queue.add(node2.left);
            queue.add(node1.right);
            queue.add(node2.right);
        }
        return true;
    }

}
