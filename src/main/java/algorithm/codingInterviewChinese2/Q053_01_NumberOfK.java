package algorithm.codingInterviewChinese2;

/**
 * 题目一：数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。例如，输入排序数组{1, 2, 3, 3, 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4.
 *
 * 可以只用查找右边界的方法
 * getLastOne(k) - getLastOne(k-1) == getLastOne(k) - getFirstK(k) + 1
 */
public class Q053_01_NumberOfK {

    // 查找第一个k的下标
    // private int getFirstK(int[] data, int len, int k, int start, int end){
    //     if (start > end)
    //         return -1;

    //     int mid = start + (end - start) / 2;
    //     if (data[mid] == k){
    //         /**
    //          * 如果前面一个数不等于k，说明midData是第一个k
    //          * 与getLastOne方法不同之处：data[mid - 1]，往前找
    //          *  end = mid - 1
    //          */
    //         if (mid > 0 && data[mid - 1] != k || mid == 0){
    //             return mid;
    //         } else  // 在前半段，因为数组是递增的
    //             end = mid - 1;
    //     } else if (data[mid] > k)
    //         end = mid - 1;
    //     else
    //         start = mid + 1;

    //     return getFirstK(data, len, k, start, end);
    // }

    // 查找最后一个k的下标
    private int getLastOne(int[] data, int len, int start, int end, int k){
        if (start > end)
            return -1;

        int mid = start + ((end - start) >> 1);

        if (data[mid] == k){
            /**
             * 如果后面一个数不等于k，说明midData是最后一个k
             * 与getFirstK方法不同之处：data[mid + 1]，往后找
             * start = mid + 1
              */
            if (mid < len - 1 && data[mid + 1] != k || mid == len - 1) {
                // 只有此处是返回找到的值
                return mid;
            } else
                start = mid + 1;
        } else if (data[mid] < k)
            start = mid + 1;
        else
            end = mid - 1;

        // 如果没有找到，就递归查找,start和end在变化
        return getLastOne(data, len, start, end, k);
    }

    // 计算目标出现的次数
    public int getNumberOfK(int[] data, int len, int k){
        int number = 0;
        if (data != null && len > 0){
//            int first = getFirstK(data, len, k, 0, len - 1);
            // getLastOne传入k-1，找k-1右边界，相当于getFirstK传入k，找k的左边界
            int first = getLastOne(data, len, 0, len - 1, k - 1);
            int last = getLastOne(data, len, 0, len - 1, k);

            if (first > -1 && last > -1)
//                number = last - first + 1;
                // 减去k-1的右边界，不用+1
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
