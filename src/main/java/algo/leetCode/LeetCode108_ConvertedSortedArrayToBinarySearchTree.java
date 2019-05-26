package algo.leetCode;

import algo.util.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 */
public class LeetCode108_ConvertedSortedArrayToBinarySearchTree {

    public TreeNode arrayToTree(int[] nums){
        if (nums == null)
            return null;

        return convert(nums, 0, nums.length - 1);

    }

    private TreeNode convert(int[] arr, int left, int right){
        if (left <= right){
            // int mid = (left + right) / 2;     // 容易溢出
            int mid = left + (right - left) / 2;
            TreeNode newNode = new TreeNode(arr[mid]);
            newNode.left = convert(arr, left, mid - 1);
            newNode.right = convert(arr, mid + 1, right);
            return newNode;
        } else {
            return null;
        }

    }
}
