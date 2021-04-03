package algo.codingInterviewChinese2;

import algo.util.TreeNode;

import java.util.Stack;

public class Q054_KthNodeInBST {

    /**
     *  此方法用递归是错误的，只是恰巧第3大的是4，第4大的应该是5，但是得出的是2
     *  剑指offer 用递归，是因为参数k取的是地址  unsigned int& k
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

    public TreeNode findKthNode(TreeNode root, int k){
        //栈顶元素保证一直是cur的父节点
        if(root == null || k < 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        while (!stack.isEmpty() || cur != null){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                count++;
                if(count == k)
                    return cur;

                cur = cur.right;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Q054_KthNodeInBST solution = new Q054_KthNodeInBST();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

//        System.out.println(solution.kthNode(root, 3).val);  // 4
//        System.out.println(solution.kthNode(root, 4).val);  // 2
//        System.out.println(solution.kthNode(root, 6).val);  // 3

        System.out.println(solution.findKthNode(root, 3).val);  // 4
        System.out.println(solution.findKthNode(root, 4).val);  // 5
        System.out.println(solution.findKthNode(root, 6).val);  // 7

    }
}
