package algo.codingInterviewChinese2;

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

        int start = 0;
        int end = len - 1;
        int mid = start;
        while (num[start] > num[end]){
            if (end - start == 1){
                mid = end;
                break;
            }

            mid = (start + end) / 2;

            // 如果start, end, mid指向的三个数字相等，只能顺序查找，比如{1, 1, 1, 0, 1}
            if (num[start] == num[mid] && num[mid] == num[end]){
                return midInOrder(num, start, end);
            }

            if (num[mid] >= num[start]) // 说明最小数在后面
                start = mid;
            else if (num[mid] <= num[end])
                end = mid;
        }

        return num[mid];
    }

    // 处理两个指针所在的数相等，中间数也相等的情况：比如{1, 1, 1, 0, 1}
    private int midInOrder(int[] numbers, int low, int high){
        int result = numbers[low];
        for (int i = low + 1; i <= high; i++) {
            if (result > numbers[i])
                result = numbers[i];
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        Q011_MinNumberInRotatedArray solution = new Q011_MinNumberInRotatedArray();

        int[] arr = {3, 4, 5, 1, 2};
        int length = arr.length;
        int min = solution.minNumber(arr, length);
        System.out.println(min);
    }
}
