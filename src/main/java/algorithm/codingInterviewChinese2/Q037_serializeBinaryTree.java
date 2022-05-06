package algorithm.codingInterviewChinese2;

import java.util.LinkedList;
import java.util.Queue;

import algorithm.util.TreeNode;

public class Q037_serializeBinaryTree {

    // 序列化
    public String serialize(TreeNode root, StringBuilder sb){
        if (root == null)
            sb.append("$, ");
        else {
            sb.append(root.val + ", ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        return sb.toString();
    }

    // 反序列化
    int index = -1;
    public TreeNode deserialize(String[] arr){
        index++;
        int len = arr.length;
        if (index > len)
            return null;

        TreeNode node = null;
        if (!"$".equals(arr[index])){
            node = new TreeNode(Integer.valueOf(arr[index]));
            node.left = deserialize(arr);
            node.right = deserialize(arr);
        }

        return node;
    }

    public void print(TreeNode root){
        if (root == null)
            return ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int toBePrinted = 1;  // 当前层还未打印的节点数
        int nextLevelCount = 0;  // 下一层的节点数

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null){
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null){
                queue.add(node.right);
                nextLevelCount++;
            }

            toBePrinted--;
            // 每打印完一层，另起一行，重新给2个变量赋值
            if (toBePrinted == 0){
                // 另起一行打印
                System.out.println();
                // 换行之后，待打印的节点数，初始化为nextLevelCount
                toBePrinted = nextLevelCount;
                // 再下一行，节点数初始化为0
                nextLevelCount = 0;
            }
        }
    }

    public static void main(String[] args){
        Q037_serializeBinaryTree solution = new Q037_serializeBinaryTree();

        String str = "1,2,4,$,$,$,3,5,$,$,6,$,$";
        String[] arr = str.split(",");
        TreeNode root = solution.deserialize(arr);

        solution.print(root);

        String str2 = solution.serialize(root, new StringBuilder());
        System.out.println(str2);
    }
}
