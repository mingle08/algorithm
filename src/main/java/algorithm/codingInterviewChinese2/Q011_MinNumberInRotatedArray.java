package algorithm.codingInterviewChinese2;

/**
 * 找出旋转数组中的最小值
 * 什么是旋转数组？
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1
 */
public class Q011_MinNumberInRotatedArray {

    public int minNumber(int[] num, int len) throws Exception {
        if (num == null || len < 0)
            throw new RuntimeException("数组不能为空！");

        int left = 0;
        int right = len - 1;
        int mid = left;
        while (left < right) {
            /**
             * 2个指针的距离是1时，表明第一个指针已经指向第一个递增子数组的末尾，
             * 而第二个指针指向第二个递增子数组的开头
             */
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;

            // 如果left, right, mid指向的三个数字相等，只能顺序查找，比如{1, 1, 1, 0, 1}
            if (num[left] == num[mid] && num[mid] == num[right]) {
                return findMin(num, left, right);
            }

            // {3, 4, 5, 1, 2}
            if (num[mid] > num[right]) // 说明最小数在后面
                left = mid;
            // {4, 5, 1, 2, 3}
            else if (num[mid] < num[right])
                right = mid;
        }

        return num[mid];
    }

    // 处理两个指针所在的数相等，中间数也相等的情况：比如{1, 1, 1, 0, 1}
    private int findMin(int[] numbers, int low, int high) {
        int min = numbers[low];
        // 因为下标low的数已经赋值给min，for循环的 i 初始值为low + 1
        for (int i = low + 1; i <= high; i++) {
            if (min > numbers[i])
                min = numbers[i];
        }

        return min;
    }

    public static void main(String[] args) throws Exception {
        Q011_MinNumberInRotatedArray solution = new Q011_MinNumberInRotatedArray();

        int[] arr = { 3, 4, 5, 1, 2 };
        int length = arr.length;
        int min = solution.minNumber(arr, length);
        System.out.println(min);
    }
}
