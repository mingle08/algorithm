package algorithm.labuladong.chapter3;

import algorithm.util.BinaryTreeNode;

/**
 * 完全二叉树的节点数为什么那么难计算
 * 
 * 完全二叉树：Complete Binary Tree，每一层都是紧凑靠左排列的
 * 满二叉树：Perfect Binary Tree，是一种特殊的完全二叉树，每层都是满的，像一个稳定的三角形
 */
public class L304_CountNodes {
    
    // 普通二叉树，求节点个数
    public int countNodes1(BinaryTreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes1(root.left) + countNodes1(root.right); 
    }

    // 满二叉树，求节点个数
    public int countNodes2(BinaryTreeNode root) {
        int h = 0;
        // 计算树的高度
        while (root != null) {
            root = root.left;
            h++;
        }
        // 节点总数就是2^h - 1
        return (int)Math.pow(2, h) - 1;
    }

    /*
        完全二叉树，求节点个数

        此算法的时间复杂度是O(logNlogN)
        关键点在于，左右子树的递归只要有一个会真的递归下去，另一个一定会触发 hl == hr而立即返回，不会递归下去。
        为什么呢？原因如下：
        一棵完全二叉树的两棵子树，至少有一棵是满二叉树。
    */
    public int countNodes3(BinaryTreeNode root) {
        BinaryTreeNode l = root, r = root;
        // 记录左、右子树的高度
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        // 如果左右子树的高度相同，说明是一棵满二叉树
        if (hl == hr) {
            return (int)Math.pow(2, hl) - 1;
        }
        // 如果左右高度不同，则按照普通二叉树的逻辑计算
        return 1 + countNodes3(root.left) + countNodes3(root.right);
    }
}
