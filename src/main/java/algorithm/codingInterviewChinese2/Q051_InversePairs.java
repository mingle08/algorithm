package algorithm.codingInterviewChinese2;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。例如，在数组{7, 5, 6, 4}中，一共存在5个逆序对，
 * 分别是(7, 6)、(7, 5)、(7, 4)、(6, 4)和(5, 4)、
 *
 * 一个从小到大排序的数组，是没有逆序对的
 *
 * 使用归并排序，在归并之前，先统计逆序对
 */
public class Q051_InversePairs {

    public static int inversePairs(int[] data) {
        if (data == null || data.length < 0)
            return 0;
        return inversePairsCore(data, 0, data.length - 1);
    }

    private static int inversePairsCore(int[] data, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        // 左半边
        int leftCnt = inversePairsCore(data, start, mid);
        // 右半边
        int rightCnt = inversePairsCore(data, mid + 1, end);
        // 以下是左右的统计
        // i初始化为前半段最后一个数字的下标
        int i = mid;
        // j初始化为后半段最后一个数字的下标
        int j = end;
        int[] temp = new int[end - start + 1];    //临时区域
        int k = end - start;    //临时区域的指针
        int count = 0;
        while (i >= start && j >= mid + 1) {
            /**
             * 前面比后面大，就是逆序对
             */
            // 比较最后的数字，再往前比
            if (data[i] > data[j]) {
                // 大数从后往前存入，此时i下标的数字大
                temp[k--] = data[i--];
                // 是逆序对，统计数量
                count += j - mid;
            }
            /**
             * 否则，不是逆序对
             */
            else {
                // 大数从后往前存入，此时j下标的数字大
                temp[k--] = data[j--];
            }
        }

        // 如果右半边都已存入temp，剩下的左半边依次存入
        for (; i >= start; i--) {
            temp[k--] = data[i];
        }
        // 如果左半边都已存入temp，剩下的右半边依次存入
        for (; j >= mid + 1; j--) {
            temp[k--] = data[j];
        }
        // 复制temp数组到原数组
        for (k = 0; k < temp.length; k++)
            data[k + start] = temp[k];

        return leftCnt + rightCnt + count;
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        int cnt = inversePairs(arr);
        System.out.println("逆序对的个数为：" + cnt);
    }
}
