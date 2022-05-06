package algorithm.sort;

/**
 * 排序算法
 * 1，内部排序：使用内存
 * 1.1 比较排序
 * （1）插入排序
 * a, 简单插入排序
 * b, 希尔排序
 * （2）选择排序
 * a, 简单选择排序
 * b, 堆排序
 * （3）交换排序
 * a, 冒泡排序
 * b, 快速排序
 * （4）归并排序
 * 1.2 非比较排序
 * （1）计数排序
 * （2）桶排序
 * （3）基数排序
 * <p>
 * 2，外部排序：内存和外存相结合
 *
 * 算法的稳定性是什么意思？
 * 百度百科：假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些记录的相对次序保持不变，
 * 即在原序列中，r[i]=r[j]，且r[i]在r[j]之前，而在排序后的序列中，r[i]仍在r[j]之前，则称这种排序算法是稳定的；否则称为不稳定的。
 */
public class ComparisonSort {

    /**
     * 1, 插入排序（从小到大排列）
     * （1）基本思想：每步将一个待排序的纪录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
     * （2）算法适用于少量数据的排序，时间复杂度为O(n^2)。
     * （3）稳定的排序方法
     */

    public static void insertSort(int[] arr) {
        /*
        for(int i = 1;i < arr.length;i++) {
            int tmp = arr[i];   // 手中待插入的牌
            int index = i-1;
            while (index >= 0 && tmp < arr[index]) {    // 后面的牌比前面的（位置在index)小，插到前面
                arr[index + 1] = arr[index];    // 刚才前面的数 向后移了一位
                index--;    // 继续往前比较
            }
            arr[index + 1] = tmp;
        }
        */

        /*
         参考Arrays归并排序时 当length < INSERTIONSORT_THRESHOLD， 则用插入排序
         */
        // 拿第2张牌，跟第1张牌比较，下次循环拿第3张牌跟前面的2张牌比较，下次拿第4张牌与前面的3张牌比较，依次类推
        for (int i = 1; i < arr.length; i++) {
            // 只有要排序的牌小于前面的牌，才交换
            // j必须>=1
            for (int j = i; j >= 1 && arr[j - 1] > arr[j]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    /**
     * 2, 希尔排序
     * （1）基本思想：将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次再将gap折半减小，
     * 循环上述操作；当gap=1时，利用直接插入，完成排序。
     * （2）时间复杂度 平均时间 O(nlogn) 最差时间O(n^2)
     * （3）不稳定
     */
    public static void shellSort(int[] arr) {
        int length = arr.length;
        int step = 1;
        while (step < length / 3) {
            step = 3 * step + 1;
        }

        while (step >= 1) {
            // 从索引step开始往后依次找分组，所以是i++
            for (int i = step; i < arr.length; i++) {
                // 根据后面的索引j，找它前面的组员j-step
                for (int j = i; j - step >= 0; j -= step) {
                    if (arr[j] < arr[j - step]) {
                        swap(arr, j, j - step);
                    }
                }
            }
            step /= 3;
        }
    }

    /**
     * 3, 选择排序
     * （1）基本思想：每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
     * （2）时间复杂度 O(n^2)。
     * （3）不稳定的排序方法。
     */

    public static void selectionSort(int[] arr) {
        for (int a = 0; a < arr.length - 1; a++) {
            // 参照物
            int minIndex = a;
            // 1，找出比参照物更小的数，for循环能找出最小的
            for (int b = a + 1; b < arr.length; b++) {
                // 找出比最小的数还要小的数
                if (arr[b] < arr[minIndex]) {
                    minIndex = b;
                }
            }

            // 2, 最小的数（arr[minIndex]）与 参照数 交换
            if (a != minIndex) {
                swap(arr, a, minIndex);
            }
        }
    }

    /**
     *  4, 堆排序
     * （1）基本思想：在排序过程中，将R[l..n]看成是一棵完全二叉树的顺序存储结构，利用完全二叉树中双亲结点和孩子结点之间的内在关系【参见二叉树的顺序存储结构】，在当前无序区中选择关键字最大(或最小)的记录。堆排序利用了大根堆(或小根堆)堆顶记录的关键字最大(或最小)这一特征，使得在当前无序区中选取最大(或最小)关键字的记录变得简单。
     * （2）是一种选择排序,其时间复杂度为O(nlogn)。
     * （3）不稳定
     *
     * 调整最大堆，交换根元素和最后一个元素。
     *
     * /

     /**
    参考jdk中的PriorityQueue
     private void siftDown(int k, E x) {
        if (comparator != null)
            siftDownUsingComparator(k, x);
        else
            siftDownComparable(k, x);
    }

    @SuppressWarnings("unchecked")
    private void siftDownComparable(int k, E x) {
        Comparable<? super E> key = (Comparable<? super E>)x;
        int half = size >>> 1;        // loop while a non-leaf
        while (k < half) {
            int child = (k << 1) + 1; // assume left child is least
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                ((Comparable<? super E>) c).compareTo((E) queue[right]) > 0)
                c = queue[child = right];
            if (key.compareTo((E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = key;
    }

    @SuppressWarnings("unchecked")
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = c;
            k = child;
        }
        queue[k] = x;
    }

    /**
     * Establishes the heap invariant (described above) in the entire tree,
     * assuming nothing about the order of the elements prior to the call.
     */
    /**
    @SuppressWarnings("unchecked")
    private void heapify() {
        for (int i = (size >>> 1) - 1; i >= 0; i--)
            siftDown(i, (E) queue[i]);
    }
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;
        int i, k;
        /*
         从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
         为什么i设置为n/2-1，因为堆是按照数组的下标顺序，从上到下，从左至右来建堆的，所以靠下靠右的索引比较大。
         n/2-1是最靠下靠右的非叶子结点（下标最大的非叶子节点），随着for循环i递减，就可以往左往上遍历堆，形成大顶堆

         for循环控制往上浮，因为i是递减，但sink方法里面是往下沉，因为找i的左子节点和右子节点
         */
        for (i = n / 2 - 1; i >= 0; i--) {
            sink(arr, i, n - 1);
        }
        System.out.println("heapSort构建的大顶堆，顶为：" + arr[0]);
        // 数组的最后一个位置n-1，放置最大的数，即arr[0]，之后最后一位不再参与堆调整
        for (k = n - 1; k >= 0; k--) {
            // 交换arr[0]和arr[k]。
            swap(arr, 0, k);
            /*
             arr[0]是arr[0...k]中最大的，换下来之后倒序放在数组中，不再参与堆的比较
             为什么start为0？ 因为其它部分都满足父结点大于子结点，刚换上来的0索引的数要调整，使堆还是大顶堆
             */
            // 再交换0与k-1位置，因为上一个循环，已经把k位置放置了上一个堆顶元素
            sink(arr, 0, k - 1);
        }
    }

    /**
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     * 其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     * <p>
     * start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     * end   -- 截至范围(一般为数组中最后一个元素的索引)
     * 注意， < end ，不是<=，
     */
    public static void sink(int[] arr, int start, int end) {
        // 当前(parentent)节点的大小
        int tmp = arr[start];
        for (int leftChild = 2 * start + 1; leftChild <= end; leftChild = 2 * leftChild + 1) {
            if (leftChild + 1 <= end && arr[leftChild] < arr[leftChild + 1]) {
                leftChild++;
            }

            if (tmp >= arr[leftChild]) {
                // 调整结束
                break;
            } else {// 交换值
                //将较大值赋给当前节点
                arr[start] = arr[leftChild];
                arr[leftChild] = tmp;
                //指针移向子节点，这是往下沉
                start = leftChild;
            }
        }
    }

    /**
     * 5, 冒泡排序
     * （1）基本思想：持续比较相邻的元素。如果第一个比第二个大，就交换他们两个。直到没有任何一对数字需要比较。
     * （2）冒泡排序最好的时间复杂度为O(n)。冒泡排序的最坏时间复杂度为O(n^2)。因此冒泡排序总的平均时间复杂度为O(n^2)。
     * （3）算法适用于少量数据的排序，是稳定的排序方法。
     */
    public static void bubbleSort(int[] arr) {
        for (int a = 0; a < arr.length - 1; a++) {
            /**
             * 为什么b < arr.length - 1 - a这个条件要减a，因为每完成一趟比较，就有一个较大的数放置好了，
             * 剩下需要比较的数字的个数就要减去已排好序的个数
             */
            for (int b = 0; b < arr.length - 1 - a; b++) {
                if (arr[b] > arr[b + 1]) {    // 比较相邻的2个数
                    swap(arr, b, b + 1);
                }
            }
        }
    }

    /**
     * 6, 快速排序
     * （1）基本思想：
     * a, 选择基准值：在待排序列中，按照某种方式挑出一个元素，作为基准值。
     * b, 分割操作：以该基准值在序列中的实际位置，把序列分成两个子序列，一边是比它大的值，另外一边是比它小的值。
     * c, 递归：对两个子序列进行快排，直到序列为空或者只有一个元素。
     * （2）平均时间复杂度为O(nlogn)，最坏情况为O(n^2)，n越大，速度越快。
     * （3）不是稳定的排序算法。
     */

    public static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }

        int left = low;
        int right = high;
        // 选择第一个数作为基准pivot，使用下标low，而不是left
        int pivot = arr[low];
        while (left < right) {
            // 1, 从右指针往左遍历，如果大于基准，不处理，指针往左走，直到找到小于基准的数
            // arr[right] >= pivot 加入=可使指针从pivot处走开
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            // 2, 左指针往右遍历，如果小于基准，不处理，指针往右走，直到遇到大于基准的数
            // arr[left] <= pivot 加入=可使指针从pivot处走开
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            // 3, 交换左右指针的值
            if (left < right) {
                swap(arr, left, right);
            }
        }

        // 此时 left == right，交换pivot和left现在位置的数
        arr[low] = arr[left];
        arr[left] = pivot;

        quickSort(arr, low, left - 1);
        quickSort(arr, right + 1, high);

    }

    /**
        7, 归并排序
        （1）创建在归并操作上的一种有效的排序算法。算法是采用分治法（Divide and Conquer）的一个非常典型的应用，且各层分治递归可以同时进行。
            归并排序思路简单，速度仅次于快速排序，为稳定排序算法，一般用于对总体无序，但是各子项相对有序的数列。
            归并排序是用分治思想，分治模式在每一层递归上有三个步骤：
            a, 分解（Divide）：将n个元素分成个含n/2个元素的子序列。
            b, 解决（Conquer）：用合并排序法对两个子序列递归的排序。
            c, 合并（Combine）：合并两个已排序的子序列已得到排序结果。
        （2）平均时间复杂度：O(nlogn)，最佳时间复杂度：O(n)，最差时间复杂度：O(nlogn)，空间复杂度：O(n)
        （3）稳定的算法
        （4）实现逻辑
            a, 迭代法
                ① 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
                ② 设定两个指针，最初位置分别为两个已经排序序列的起始位置
                ③ 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
                ④ 重复步骤③直到某一指针到达序列尾
                ⑤ 将另一序列剩下的所有元素直接复制到合并序列尾

            b, 递归法
                ① 将序列每相邻两个数字进行归并操作，形成floor(n/2)个序列，排序后每个序列包含两个元素
                ② 将上述序列再次归并，形成floor(n/4)个序列，每个序列包含四个元素
                ③ 重复步骤②，直到所有元素排序完毕
     */
    public static void mergeSort(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            //归并
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        // 左一半的开始索引
        int left = low;
        // 右一半的开始索引
        int right = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        // 把左边剩余的数移入临时数组
        while (left <= mid) {
            temp[k++] = arr[left++];
        }
        // 把右边剩余的数移入临时数组
        while (right <= high) {
            temp[k++] = arr[right++];
        }
        // 用临时数组中的数覆盖原数组
        for (int i = 0; i < temp.length; i++) {
            arr[i + low] = temp[i];
        }
    }


    private static void swap(int[] arr, int m, int n) {
        int tmp = arr[m];
        arr[m] = arr[n];
        arr[n] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 8, 9, 1, 2, 10, 6};
//        bubbleSort(nums);
//        selectionSort(nums);
//        insertSort(nums);
//        shellSort(nums);
//        heapSort(nums);
//        mergeSort(nums, 0, nums.length - 1);
        quickSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + "\t");
        }
    }

}
