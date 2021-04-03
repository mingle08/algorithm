package algo.codingInterviewChinese2;

import algo.util.TreeNode;

/**
 *  给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 *  树中的节点，除了左，右，还有父节点
 *
 *                     a
 *            b               c
 *     d           e       f    g
 *               h   i
 *  1. 如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点（因为是中序遍历）
 *    例如，节点b的下一个节点是h，节点a的下一个节点是f
 *  2. 如果一个节点无右子树，分二种情况：
 *    （1）它是它父节点的左子节点，那么它的下一个节点就是它的父节点：节点d的下一个节点是b，节点f的下一个节点是c
 *    （2）它是它父节点的右子节点，这个情况就比较复杂。我们可以沿着指向父节点的指针一直向上遍历，
 *         直到找到一个是它父节点的左子节点的节点。如果这样的节点存在，那么这个节点的父节点，
 *         就是我们要找的下一个节点。例如，i的下一个节点是a，g没有下一个节点
 */
public class Q008_NextNodeInBinaryTree {

    public static TreeNode getNext(TreeNode pNode){
        if(pNode==null)
            return null;
        TreeNode pNext = null;
        if (pNode.right != null){
            TreeNode pRight = pNode.right;
            while (pRight.left != null) {    // 找最左子节点
                pRight = pRight.left;
            }
            pNext = pRight;
        } else if (pNode.parent != null){
            TreeNode pCur = pNode;
            TreeNode pParent = pNode.parent;
            while (pParent != null && pCur == pParent.right){
                pCur = pParent;
                pParent = pParent.parent;
            }

            pNext = pParent;
        }

        return pNext;
    }
}
