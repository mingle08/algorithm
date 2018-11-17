package algo.dataStruct.tree.bst;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

public class BstTest {

    /**
     * 构建二叉树：左节点的值，小于根节点的值，右节点的值，大于根节点的值
     * @param node
     * @param val
     */
    public static void buildBst(TreeNode node, int val){
        if(node.val == val){
            return;
        }
        if (val < node.val){// 左节点的值小于根节点的值
            if(node.left == null){
                node.left = new TreeNode(val);
            }else{
                buildBst(node.left, val);
            }
        }else{// 右节点的值大于根节点的值
            if(node.right == null){
                node.right = new TreeNode(val);
            }else{
                buildBst(node.right, val);
            }

        }
    }

    /**
     * 前序遍历： 根  --->  左  --->  右
     * 使用Stack
     * @param node
     */
    public static void DLR(TreeNode node){
        if(node != null){
            Stack<TreeNode> stack = new Stack<>();
            stack.push(node);
            while(!stack.isEmpty()){
                // 先弹出根节点
                node = stack.pop();
                System.out.print(node.val + " ");
                // 右节点，先放入栈中，所以后出栈
                if(node.right != null){
                    stack.push(node.right);
                }

                // 左节点后放入栈中，所以先出栈
                if (node.left != null){
                    stack.push(node.left);
                }
            }
        }
    }

    /**
     * 中序遍历：   左  --->   根    --->  右
     * @param node
     */
    public static void LDR(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        while(node != null || !stack.isEmpty()){
            if(node != null){
                // 先将根节点加入到栈中，再依次将左子树的左节点全部加入到栈中
                stack.push(node);
                node = node.left;
            }else{// 栈不为空
                // 先取出栈中左节点的值，和根节点的值，再放入右节点
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历：左 ---> 右 ---> 根
     * 使用二个Stack
     * @param node
     */
    public static void LRD(TreeNode node){
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(node);
        TreeNode temp = null;
        while(!stack1.isEmpty()){
            temp = stack1.pop();
            if(temp.left != null){
                stack1.push(temp.left);
            }
            if(temp.right != null){
                stack1.push(temp.right);
            }
            stack2.push(temp);
        }

        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().val + " ");
        }
    }

    /**
     * 层序遍历：  使用LinkedBlockingDeque
     * @param node
     */
    public static void levelOrder(TreeNode node){
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }

    }

    public static void main(String[] args){
        int[] arr = new int[]{6,9,1,5,8};
        TreeNode root = new TreeNode(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            buildBst(root, arr[i]);
        }

        levelOrder(root);
        System.out.println("=============");
        LDR(root);
    }
}
