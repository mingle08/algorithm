package algorithm.codingInterviewChinese2;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 奇偶数的判断
 *  n & 1 == 0  偶
 *  n & 1 == 1  奇
 */
public class Q021_ReorderArray {

    /**
     *  1，不能保证相对位置不变
     *  2，原数组上操作
     * @param arr
     * @param len
     */
    public void reorderOddEvent(int[] arr, int len){
        reorder(arr);
    }

    private void reorder(int[] num){
        if (num == null || num.length == 0)
            return;

        int start = 0;
        int end = num.length - 1;
        while (start < end){
            // 1, 是奇数，不用交换，向后遍历
            while (start < end && !isEven(num[start]))
                start++;

            // 2, 是偶数，不用交换，向前遍历
            while (start < end && isEven(num[end]))
                end--;

            // 3, 执行到这一步，说明上面1步骤碰到偶数，2步骤碰到奇数，该交换位置了
            if (start < end){
                int temp = num[start];
                num[start] = num[end];
                num[end] = temp;
            }
        }

    }

    /**
     * 1，保持相对位置不变
     * 2，新建一个同样大小的数组
     * @param num
     * @return
     */
    private int[] reorder2(int[] num){
        if (num == null || num.length == 0)
            return null;

        int start = 0;
        int end = num.length - 1;
        // 新数组，奇数从前往后存，偶数从后往前存
        int[] arr = new int[num.length];
        for (int j : num) {
            // 1, 是奇数，向后遍历
            if (!isEven(j)) {
                arr[start++] = j;
            } else {
                arr[end--] = j;
            }
        }
        return arr;
    }


    // 判断是否偶数
    private boolean isEven(int a) {
        return (a & 1) == 0;
    }

    public static void main(String[] args){
        Q021_ReorderArray solution = new Q021_ReorderArray();

        int[] arr = {10, 6, 4, 5, 2, 7, 8, 3, 9};
//        solution.reorder(arr);
//        for (int num : arr) {
//            System.out.print(num + "\t");
//        }
//        System.out.println();
        int[] newArr = solution.reorder2(arr);
        for (int num : newArr) {
            System.out.print(num + "\t");
        }
    }
}
