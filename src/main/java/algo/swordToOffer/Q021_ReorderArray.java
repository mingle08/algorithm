package algo.swordToOffer;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 奇偶数的判断
 *  n & 1 == 0  偶
 *  n & 1 == 1  奇
 */
public class Q021_ReorderArray {

    public void reorderOddEvent(int[] arr, int len){
        reorder(arr, len);
    }

    private void reorder(int[] num, int len){
        if (num == null || len == 0)
            return;

        int start = 0;
        int end = len - 1;
        while (start < end){
            while (start < end && (num[start] & 1) != 0)
                start++;

            while (start < end && (num[end] & 1) == 0)
                end--;

            if (start < end){
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
            }
        }

    }

    public static void main(String[] args){
        Q021_ReorderArray solution = new Q021_ReorderArray();

        int[] arr = {10, 6, 4, 5, 2, 7, 8, 3, 9};
        int len = arr.length;
        solution.reorder(arr, len);
        System.out.println(arr[len-1]);
    }
}
