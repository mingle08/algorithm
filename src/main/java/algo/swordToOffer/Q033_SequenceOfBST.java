package algo.swordToOffer;

public class Q033_SequenceOfBST {
    public boolean verifySequenceOfBST(int[] sequence, int start, int end){
        if ( start >= end ){//递归临界点
            return true;
        }
        int root = sequence[end];//后序遍历序列的最后一个元素为二叉树的根节点
        int i = start;
        //找到第一个大于等于根结点的元素i,i左侧为左子树、i右侧为右子树
        while( sequence[i] < root ){
            i++;
        }
        int j = i;
        while( j < end ){//依次遍历右侧，看是否所有元素均大于根结点
            if ( sequence[j] < root ) {
                return false;//若出现小于根结点的元素，则直接返回false
            }
            j++;
        }
        //分别递归判断左/右子序列是否为后序序列
        boolean left = verifySequenceOfBST(sequence, start,i-1);
        boolean right = verifySequenceOfBST(sequence,i+1, end);
        return left && right;
    }

    public static void main(String[] args){
        Q033_SequenceOfBST solution = new Q033_SequenceOfBST();
        int[] arr = {5, 7, 6, 9, 11, 10, 8};
        boolean flag = solution.verifySequenceOfBST(arr, 0, arr.length - 1);
        System.out.println(flag);
    }

}
