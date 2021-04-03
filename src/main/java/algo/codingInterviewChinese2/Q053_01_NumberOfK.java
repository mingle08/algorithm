package algo.codingInterviewChinese2;

/**
 * 题目一：数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。例如，输入排序数组{1, 2, 3, 3, 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4.
 */
public class Q053_01_NumberOfK {

    // 查找第一个k的下标
    private int getFirstK(int[] data, int len, int k, int start, int end){
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        int midData = data[mid];
        if (midData == k){
            if (mid > 0 && data[mid - 1] != k || mid == 0){ // 如果前面一个数不等于k，说明midData是第一个k
                return mid;
            } else  // 在前半段，因为数组是递增的
                end = mid - 1;
        } else if (midData > k)
            end = mid - 1;
        else
            start = mid + 1;

        return getFirstK(data, len, k, start, end);
    }

    // 查找最后一个k的下标
    private int getLastK(int[] data, int len, int k, int start, int end){
        if (start > end)
            return -1;

        int mid = start + (end - start) / 2;
        int midData = data[mid];

        if (midData == k){
            if (mid < len - 1 && data[mid + 1] != k || mid == len - 1)
                return mid;
            else
                start = mid + 1;
        } else if (mid < k)
            start = mid + 1;
        else
            end = mid - 1;

        return getLastK(data, len, k, start, end);
    }

    // 计算目标出现的次数
    public int getNumberOfK(int[] data, int len, int k){
        int number = 0;
        if (data != null && len > 0){
            int first = getFirstK(data, len, k, 0, len - 1);
            int last = getLastK(data, len, k, 0, len - 1);

            if (first > -1 && last > -1)
                number = last - first;
        }

        return number;
    }

    public static void main(String[] args){
        Q053_01_NumberOfK solution = new Q053_01_NumberOfK();
        int[] num = {1, 2, 3, 3, 3, 3, 4, 5};
        int len = num.length;
        int number = solution.getNumberOfK(num, len, 3);
        System.out.println(number);
    }
}
