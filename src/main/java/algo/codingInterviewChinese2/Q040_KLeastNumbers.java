package algo.codingInterviewChinese2;

import java.util.ArrayList;
import java.util.TreeSet;

public class Q040_KLeastNumbers {

    /**
     * 分析1：O(n)的算法，只有当我们可以修改输入的数组时可用
     * 我们可以基于Partition函数来解决这个问题。可以基于数组的第k个数字来调整，使得比第k个数字小的所有数字
     * 都位于数组的左边，比第k个数字大的所有数字都位于数组的右边。这样调整之后，位于数组中左边的k个数字就是
     * 最小的k个数字。
     *
     */
    public int[] findKLeastNum(int[] numbers, int k){
        if (numbers == null || numbers.length == 0 || k < 0)
            return null;

        int[] result = new int[k];
        int low = 0;
        int high = numbers.length - 1;
        int index = partition(numbers, low, high);
        while (index != k - 1){
            if (index > k - 1){
                high = index - 1;
                index = partition(numbers, low, high);
            } else {
                low = index + 1;
                index = partition(numbers, low, high);
            }
        }

        for (int i = 0; i < k; i++) {
            result[i] = numbers[i];
        }

        return result;
    }

    public int partition(int[] arr, int low, int high){
        int temp = arr[low];  // 以temp为基数
        while(low < high) {
            // 1. 如果arr[high]大于temp, high指针往左移
            while(low < high && arr[high] >= temp) {
                high--;
            }
            // 2. 否则，如果arr[high] <= temp，把小的值存在arr[low]
            arr[low] = arr[high];

            // 3. 如果arr[low] < temp，low指针往右移
            while(low < high && arr[low] <= temp) {
                low++;
            }
            // 4. 否则，如果arr[low] >= temp, 把大的值存在arr[high]
            arr[high] = arr[low];

        }
        arr[high] = temp;
        return high;
    }

    // 分析2：O(nlogk)的算法，特别适用处理海量数据
    public int[] getKLeastNumbers(int[] num, int k) {
        while(num == null || k <= 0 || k > num.length)
            return null;

        int[] res = new int[k];  //用于放最小的k个数
        for(int i=0; i<k; i++)
            res[i] = num[i];//先放入前k个数

        for(int i = k/2-1; i >= 0; i--)
            adjustHeap(res, i,k-1);   //将数组构造成最大堆形式

        for(int i = k; i < num.length; i++){
            if(num[i] < res[0]){    //存在更小的数字时
                res[0] = num[i];
                adjustHeap(res,0,k-1);   //重新调整最大堆
            }
        }

        return res;
    }

    // 最大堆的调整方法 
    private void adjustHeap(int[] arr, int start, int end){
        // 父节点
        int temp = arr[start];
        // 左孩子
        int leftChild = start * 2 + 1;
        // 右孩子
        int rightChild = leftChild + 1;
        while(leftChild <= end){
            if(rightChild <= end && arr[rightChild] > arr[leftChild])
                leftChild++;

            if(arr[leftChild] < temp)
                break;

            // 走到这里，说明上一步没有break，即arr[leftChild] >= temp，需要交换
            arr[start] = arr[leftChild];
            start = leftChild;
            leftChild = start * 2 + 1;
        }
        arr[start] = temp;
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
    public void swap(int[] num, int i ,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args){
        Q040_KLeastNumbers solution = new Q040_KLeastNumbers();

        int[] num = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] res = solution.getKLeastNumbers(num, 4);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

}
