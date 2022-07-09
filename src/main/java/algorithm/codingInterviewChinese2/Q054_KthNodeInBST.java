package algorithm.codingInterviewChinese2;

import algorithm.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树的第K大节点
 * 题目：给定一棵二叉搜索树，请找出其中第K大节点。
 * 例如，在下图中的二叉搜索树里，按节点数值大小顺序，第三大节点的值是
 *
 *             5
 *      3             7
 * 2       4      6        8
 *
 * 中序遍历
 *
 * 与Leetcode上的第k大的意思正好相反：
 * 如果k=1，就是第1大，也就是最大的，所以是中序遍历的倒数第1个
 * 如果k=2，就是第2大，也就是倒数第2大，所以还是中序遍历的倒数第2个
 * 所以，以Leetcode为准
 */
public class Q054_KthNodeInBST {

    /**
     *  以下这个注释掉的方法，是仿照剑指offer书上的代码写的。
     *  如果仿照书上的方法，用java写成下面这样，是错误的。只是恰巧第3大的是4，第4大的应该是5，但是得出的是2
     *  但剑指offer书上是正确的，因为它是用C#写的，方法的第二个参数k取的是地址  unsigned int& k
     */
    /*int index = 0;
    public TreeNode kthNode(TreeNode root, int k){
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = kthNode(root.left,k);
            if(node != null)
                return node;

            index ++;
            if(index == k)
                return root;

            node = kthNode(root.right,k);
            if(node != null)
                return node;

        }
        return null;
    }*/

    /**
     * 中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public TreeNode findKthNode(TreeNode root, int k) {
        //栈顶元素保证一直是cur的父节点
        if (root == null || k < 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        List<TreeNode> res = new ArrayList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 统计数量
//                count++;
//                if (count == k)
//                    return cur;
                res.add(cur);
                cur = cur.right;
            }
        }
        return res.get(res.size() - k);
    }

    public static void main(String[] args) {
        Q054_KthNodeInBST solution = new Q054_KthNodeInBST();
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

//        System.out.println(solution.kthNode(root, 3).val);  // 4
//        System.out.println(solution.kthNode(root, 4).val);  // 2
//        System.out.println(solution.kthNode(root, 6).val);  // 3

//        System.out.println(solution.findKthNode(node1, 3).val);  // 4
//        System.out.println(solution.findKthNode(node1, 4).val);  // 5
//        System.out.println(solution.findKthNode(node1, 6).val);  // 7

        System.out.println(solution.findKthNode(node1, 1).val);
    }
}
