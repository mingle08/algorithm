package algo.leetCode;

import algo.util.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 *
 */
public class Q114_FlattenBinaryTreeToLinkedList {

    public TreeNode flattenBT(TreeNode root) {
        if(root==null) return null;
        TreeNode rightNode = flattenBT(root.right);
        root.right=flattenBT(root.left);
        root.left=null;
        TreeNode temp = root;
        while(temp.right != null){
            temp = temp.right;
        }
        temp.right = rightNode;
        return root;
    }

    public void flatten(TreeNode root) {

        if(root == null)
            return;

        if (root.left != null)
            flatten(root.left);
        if (root.right != null)
            flatten(root.right);

        if (root.left == null && root.right == null)
            return;
        TreeNode tmp = root.right;  // 先用临时变量保存右节点，比如root是2，tmp就是4
        root.right = root.left;     // 新的右节点是原来的左节点，比如2的右节点是3
        root.left = null;           // 左节点置为空

        // 现在根节点2的右节点上是原来的左节点3，不为空，把根节点移到这个右节点3上
        while (root.right != null)
            root = root.right;

        // 新的根节点3，右节点设置成4
        root.right = tmp;
    }

    public void flatten_1(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();   // node是    1           2        3    4    5
            if(node.right != null)
                stack.push(node.right);  // stack :   [5]        [5  4]    [5 4]  [5]  [6]
            if(node.left != null)
                stack.push(node.left);   // stack : [5  2]      [5 4 3]    [5 4]  [5]  [6]
            if(!stack.isEmpty())
                node.right = stack.peek();  // node.right 为 2      3       4     5    6
            node.left = null;
        }
    }

    public static void main(String[] args){
        Q114_FlattenBinaryTreeToLinkedList solution = new Q114_FlattenBinaryTreeToLinkedList();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        root = solution.flattenBT(root);

        System.out.println(root.val);
    }
}