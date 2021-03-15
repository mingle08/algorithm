package algo.sort;

/**
 * 非比较排序
 * 1，计数排序
 * 2，桶排序
 * 3，基数排序
 */
public class NonComparativeSort {

    /**
     * 计数排序
     * @param arr
     */
    public static void countSort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("数组中最大值为：" + max + ",最小值为：" + min);
        int len = max - min + 1;
        int[] count = new int[len];
        for (int k : arr) {
            count[k - min]++;   // k - min 使计数数组下标从0开始
        }

        int index = 0;
        for (int i = 0; i < len; i++) {
            for (int c = 0; c < count[i]; c++) {    // count[i] : 数字出现的次数
                arr[index++] = i + min;     // 原来减少了min，现在加上min，就变成了原来的值
            }
        }

    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixSort(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        int len;
        for (len = 1; max / len > 0; len *= 10) {
            //存储待排元素的临时数组
            int[] temp = new int[arr.length];
            //分桶个数
            int[] buckets = new int[10];

            //将数据出现的次数存储在buckets中
            for (int num : arr) {
                // (num / len) % 10 :value的最底位(个位)
                buckets[(num / len) % 10]++;
            }

            /*
                确定前面有几个数
                每个索引对应的值记录已经排序多少个元素，桶中i位置元素值即为落入桶i中数组元素在排序后的序列中的下标值
                因为此时桶中i位置元素值为所有小于落入桶i位置数组元素的数组元素个数总和
             */
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];
            }

            //将数据存储到临时数组temp中
            for (int i = arr.length - 1; i >= 0; i--) {
                temp[buckets[(arr[i] / len) % 10] - 1] = arr[i];
                buckets[(arr[i] / len) % 10]--;
            }

            //将有序元素temp赋给arr
            System.arraycopy(temp,0, arr, 0, arr.length);
        }
    }

    public static void main(String[] args) {
//        int[] nums = {2, 8, 4, 6, 5, 9, 8, 3, 7, 2, 8, 4, 6, 9};
//        countSort(nums);
//        int[] nums = {23, 3, 37, 124, 100, 42, 31, 156, 16, 29, 156, 144, 137, 82, 62, 49, 113, 192, 70};
        int[] nums = {23, 3, 37, 124, 17, 31, 42};
        radixSort(nums);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }
}
