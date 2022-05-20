package algorithm.codingInterviewChinese2;

import algorithm.binarytree.BinaryTree;
import algorithm.util.BinaryTreeNode;

import java.util.Stack;

import javax.activation.MailcapCommandMap;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

/**
 * 将搜索二叉树转换成有序的双向链表
 * <p>
 * 题目：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * 中序遍历
 */
public class Q036_ConvertBSTreeToDoubleNodeList {

    public static BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode lastNode = null;
        lastNode = convertNode(root, lastNode);
        BinaryTreeNode head = lastNode;
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }

    // 方法1：递归
    private static BinaryTreeNode convertNode(BinaryTreeNode root, BinaryTreeNode lastNode) {
        if (root == null)
            return lastNode;

        BinaryTreeNode cur = root;
        // 中序遍历：1，处理左子节点
        if (cur.left != null)
            lastNode = convertNode(cur.left, lastNode);
        cur.left = lastNode;    // 双向链接第1步

        // 中序遍历：2，处理根节点
        // 把根节点连接到链表中
        if (lastNode != null)
            lastNode.right = cur;   // 双向链接第2步，至此，完成双向链接

        // 最后节点往右移动
        lastNode = cur;
        // 中序遍历：3，处理右子节点
        if (cur.right != null)
            lastNode = convertNode(cur.right, lastNode);

        return lastNode;

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

        BinaryTreeNode head = convert(root);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
    }
}
