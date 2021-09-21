package algo.codingInterviewChinese2;

/**
 * 题目二：0 ~ n-1 中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出该数字
 *
 * 例如 n = 6， n - 1 = 5，即长度为5的递增排序数组
 * 0，1，2，3，5
 * 数组中开始的一些数字与它们的下标相同，也就是说，0在0下标，1在1下标，以此类推。
 * 如果不在数组中的那个数字记为m，那么所有比m小的数字的下标都与它们的值相同。由于m不在数组中，那么m + 1处于下标为m的位置，m+2处于下标为m+1的位置，以此类推。
 * 我们发现m正好是数组中第一个数值与下标不相等的下标
 */
public class Q053_02_MissingNumber {
    public static int getMissingNumber(int[] num) {
        if (num == null || num.length <= 0)
            return -1;

        int left = 0;
        int right = num.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            // 如果中间元素的值和下标不相等
            if (num[mid] != mid){
                // 并且它前面一个元素和它的下标相等，这说明这个中间的数字正好是第一个值和下标不相等的元素
                if (mid == 0 || num[mid - 1] == mid - 1) {
                    return mid;
                }
                // 否则，继续在左半边查找
                right = mid - 1;
            } else
                left = mid + 1;
        }
        if (left == num.length) {
            return num.length;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,5};
        int index = getMissingNumber(arr);
        System.out.println(index);
    }
}
