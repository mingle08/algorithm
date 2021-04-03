package algo.codingInterviewChinese2;

/**
 * 二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数是不是某二叉搜索树的后序遍历结果。如果是则返回true，否则返回false.
 * 假设输入的数组的任意两个数字都互不相同。例如，输入数组{5,7,6,9,11,10,8}，则返回true，因为这个整数
 * 序列是下图二叉树的后序遍历结果。如果输入的数组是{7,4,6,5}，则没有哪棵二叉搜索树的后序遍历结果是这个
 * 序列，因此返回false.
 *
 *               8
 *         6         10
 *      5    7     9    11
 *
 * 思路：二叉搜索树的特点：左子树的节点值小于根节点的值，右子树的节点值大于根节点的值
 */
public class Q033_SequenceOfBST {
    public boolean verifySequenceOfBST(int[] sequence, int start, int end) {
        if (start >= end) {//递归临界点
            return true;
        }
        int root = sequence[end];//后序遍历序列的最后一个元素为二叉树的根节点
        int i = start;
        // 统计左子树的节点数
        while (sequence[i] < root) {
            i++;
        }
        int j = i;
        while (j < end) {//依次遍历右侧，看是否所有元素均大于根结点
            if (sequence[j] < root) {
                return false;//若出现小于根结点的元素，则直接返回false
            }
            j++;
        }
        //分别递归判断左/右子序列是否为后序序列
        boolean left = verifySequenceOfBST(sequence, start, i - 1);
        boolean right = verifySequenceOfBST(sequence, i + 1, end);
        return left && right;
    }

    public static void main(String[] args) {
        Q033_SequenceOfBST solution = new Q033_SequenceOfBST();
        int[] arr = {5, 7, 6, 9, 11, 10, 8};
        boolean flag = solution.verifySequenceOfBST(arr, 0, arr.length - 1);
        System.out.println(flag);
    }

}
