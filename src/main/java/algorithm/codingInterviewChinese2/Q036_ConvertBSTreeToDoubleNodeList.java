package algorithm.codingInterviewChinese2;

import algorithm.util.BinaryTreeNode;

import java.util.Stack;

/**
 * 将搜索二叉树转换成有序的双向链表
 * <p>
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 中序遍历
 */
public class Q036_ConvertBSTreeToDoubleNodeList {

    static BinaryTreeNode head, tail;

    public static BinaryTreeNode treeToNodeList(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        // 递归
        dfs(root);
        // 头尾节点相连
        // tail.right = head;
        // head.left = tail;

        return head;
    }

    // 方法1：递归
    private static void dfs(BinaryTreeNode cur) {
        if (cur == null) {
            return;
        }

        // 递归左子树
        dfs(cur.left);

        // 中序遍历的位置
        if (tail == null) {
            // head只设置这一次，而tail在往右移
            head = cur;
        } else {
            // tail 节点的右指针是cur
            tail.right = cur;
            // cur的左指针是 tail
            cur.left = tail;
        }
        
        // tail右移至cur
        tail = cur;

        // 递归右子树
        dfs(cur.right);
    }

    /**
     * 方法2：非递归
     *
     * @param root
     * @return
     */
    public static BinaryTreeNode convert2(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode cur = root;
        BinaryTreeNode lastNode = null;
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.right;
            } else {
                cur = stack.pop();
                if (lastNode != null) {
                    lastNode.left = cur;
                    cur.right = lastNode;
                }
                lastNode = cur;
                cur = cur.left;
            }
        }
        return lastNode;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(14);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(8);
        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(16);

        BinaryTreeNode head = treeToNodeList(root);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}
