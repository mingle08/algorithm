package algorithm.labuladong.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class L408_PancakeSort {
    // 记录反转操作序列
    LinkedList<Integer> res = new LinkedList<>();

    List<Integer> pancakeSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }

    // 将前n块烧饼排序
    void sort(int[] cakes, int n) {
        // base case
        if (n == 1) return;

        // 寻找最大烧饼的索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }

        // 第一次翻转，将最大烧饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);
        // 记录这一次的翻转
        res.add(maxCakeIndex + 1);
        // 第二次翻转，将最大烧饼翻到最下面
        reverse(cakes, 0, n - 1);
        // 记录这一次翻转
        res.add(n);

        // 递归调用，翻转剩下的烧饼
        sort(cakes, n - 1);
    }

    /* 翻转arr[i...j]的元素 */
    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }

    /**
     * 第二种方法
     * @param A
     * @return
     */
    public List<Integer> pancakeSort2(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int x = A.length, i; x > 0; --x) {
            for (i = 0; A[i] != x; ++i);
            reverse(A, i + 1);
            res.add(i + 1);
            reverse(A, x);
            res.add(x);
        }
        return res;
    }

    public void reverse(int[] A, int k) {
        for (int i = 0, j = k - 1; i < j; i++, j--) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
        }
    }

    public static void main(String[] args) {
        L408_PancakeSort pancakeSort = new L408_PancakeSort();
        int[] arr = {3, 2, 4, 1};
        List<Integer> res = pancakeSort.pancakeSort(arr);
        res.forEach(System.out::println);
//        List<Integer> res = pancakeSort.pancakeSort2(arr);
//        res.forEach(System.out::println);
    }
}
