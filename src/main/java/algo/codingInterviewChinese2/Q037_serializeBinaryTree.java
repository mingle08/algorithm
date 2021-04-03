package algo.codingInterviewChinese2;

import algo.util.TreeNode;

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
    public TreeNode deserialize(String str){
        index++;
        int len = str.length();
        if (index > len)
            return null;
        String[] arr = str.split(",");
        TreeNode node = null;
        if (!"$".equals(arr[index])){
            node = new TreeNode(Integer.valueOf(arr[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }

        return node;
    }

    public static void main(String[] args){
        Q037_serializeBinaryTree solution = new Q037_serializeBinaryTree();

        String str = "1,2,4,$,$,$,3,5,$,$,6,$,$";
        TreeNode root = solution.deserialize(str);

        System.out.println(root.val);
    }
}
