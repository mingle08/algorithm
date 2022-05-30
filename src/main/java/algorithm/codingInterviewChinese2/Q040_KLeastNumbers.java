package algorithm.codingInterviewChinese2;

import java.util.ArrayList;
import java.util.TreeSet;

public class Q040_KLeastNumbers {

    /**
     * 题目：输入n个整数，找出其中最小的k个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4
     * 
     * 分析1：O(n)的算法，只有当我们可以修改输入的数组时可用
     * 我们可以基于Partition函数来解决这个问题。可以基于数组的第k个数字来调整，使得比第k个数字小的所有数字
     * 都位于数组的左边，比第k个数字大的所有数字都位于数组的右边。这样调整之后，位于数组中左边的k个数字就是
     * 最小的k个数字。
     */
    public int[] findKLeastNum(int[] numbers, int k) {
        if (numbers == null || numbers.length == 0 || k < 0)
            return null;
        // 用于存放最小的k个数
        int[] result = new int[k];

        int low = 0;
        int high = numbers.length - 1;
        int index = partition(numbers, low, high);
        while (index != k - 1) {
            if (index > k - 1) {
                high = index - 1;
                index = partition(numbers, low, high);
            } else {
                low = index + 1;
                index = partition(numbers, low, high);
            }
        }

        // 直到index == k - 1

        for (int i = 0; i < k; i++) {
            result[i] = numbers[i];
        }

        return result;
    }

    // 快速排序
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[low];  // 以pivot为基数
        int left = low;
        int right = high;
        int temp = 0;
        while (left < right) {
            // 1. 如果arr[high]大于pivot, high指针往左移
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            // 2. 如果arr[low] < pivot，low指针往右移
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            // 3. 交换
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        arr[low] = arr[left];
        arr[left] = pivot;
        return pivot;
    }

    // 分析2：O(nlogk)的算法，特别适用处理海量数据
    public int[] getKLeastNumbers(int[] num, int k) {
        while (num == null || k <= 0 || k > num.length)
            return null;
        // 用于存放最小的k个数
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            // 先放入k个数
            res[i] = num[i];
        }

        // 构造大顶堆
        for (int i = k / 2 - 1; i >= 0; i--)
            adjustHeap(res, i, k - 1);

        // 遍历原数组第k个开始之后的所有数据
        for (int i = k; i < num.length; i++) {
            /**
             * 因为是大顶堆，出现比顶更小的数字，换进来，因为我们求的是最小的k个数
             * 不断把堆顶（最大）的数字替换成更小的，最后就得到最小的k个数
             */
            if (num[i] < res[0]) {    //存在更小的数字时
                res[0] = num[i];
                adjustHeap(res, 0, k - 1);   //重新调整大顶堆
            }
        }

        return res;
    }

    // 大顶堆的调整方法：下沉
    private void adjustHeap(int[] arr, int start, int end) {
        // 父节点
        int pivot = arr[start];
        // 左孩子
        int leftChild = start * 2 + 1;
        // 右孩子
        int rightChild = leftChild + 1;
        while (leftChild <= end) {
            if (rightChild <= end && arr[rightChild] > arr[leftChild])
                leftChild++;

            if (arr[leftChild] < pivot)
                break;

            // 走到这里，说明上一步没有break，即arr[leftChild] >= pivot，需要交换
            arr[start] = arr[leftChild];
            start = leftChild;
            leftChild = start * 2 + 1;
        }
        arr[start] = pivot;
    }

    // 因为TreeSet实现了红黑树，TreeSet中的数据会按照插入数据自动升序排列
    public ArrayList<Integer> GetLeastKNumbers(int[] num, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || k == 0 || k > num.length) {
            return result;
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }

        for (Integer elem : set) {
            if (result.size() > k - 1)
                break;
            else
                result.add(elem);
        }
        return result;
    }


    //交换数组中的两个元素
    public void swap(int[] num, int i, int j) {
        int pivot = num[i];
        num[i] = num[j];
        num[j] = pivot;
    }

    public static void main(String[] args) {
        Q040_KLeastNumbers solution = new Q040_KLeastNumbers();

        int[] num = {4, 5, 1, 6, 2, 7, 3, 8};
//        int[] res = solution.getKLeastNumbers(num, 4);
        int[] res = solution.findKLeastNum(num, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
