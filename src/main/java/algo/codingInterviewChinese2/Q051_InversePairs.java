package algo.codingInterviewChinese2;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。例如，在数组{7, 5, 6, 4}中，一共还在5个逆序对，
 * 分别是(7, 6)、(7, 5)、(7, 4)、(6, 4)和(5, 4)、
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
        int left = inversePairsCore(data, start, mid);
        int right = inversePairsCore(data, mid + 1, end);

        // i初始化为前半段最后一个数字的下标
        int i = mid;
        // j初始化为后半段最后一个数字的下标
        int j = end;
        int[] temp = new int[end - start + 1];    //临时区域
        int k = end - start;    //临时区域的指针
        int count = 0;
        while (i >= start && j >= mid + 1) {
            if (data[i] > data[j]) {
                temp[k--] = data[i--];
                count += j - mid;
            } else {
                temp[k--] = data[j--];
            }
        }

        for (; i >= start; i--) {
            temp[k--] = data[i];
        }
        for (; j >= mid + 1; j--) {
            temp[k--] = data[j];
        }
        for (k = 0; k < temp.length; k++)
            data[k + start] = temp[k];

        return left + right + count;
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 6, 4};
        int cnt = inversePairs(arr);
        System.out.println("逆序对的个数为：" + cnt);
    }
}
