package algorithm.codingInterviewChinese2;

/**
 * 题目三：数组中数值和下标相等的元素
 * 假设一个单调递增的数组里的每个元素都是整数并且都是唯一的。请编程实现一个函数，找出数组中任意一个数值等于其下标的元素。
 * 例如，在数组中{-3, -1, 1, 3, 5}中，数字3和它的下标相等
 */
public class Q053_03_IntegerIdenticalToIndex {
    public static int getNumberSameAsIndex(int[] num) {
        if (num == null || num.length <= 0)
            return -1;

        int left = 0;
        int right = num.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (num[mid] == mid)
                return mid;

            if (num[mid] > mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 3, 5};
        int index = getNumberSameAsIndex(arr);
        System.out.println(index);
    }
}
