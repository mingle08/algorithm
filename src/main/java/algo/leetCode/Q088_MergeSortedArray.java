package algo.leetCode;

public class Q088_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (k >= 0) {
            
            // 大的数，从后往前放置
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }

            /**
             * 当上面循环结束后，num1或者num2可能还有数据，
             * 是或的关系，要么是num1还有剩余的，要么是nums2还有剩余的，不可能二者都有剩余
             *
             */
            //可能是num1中还有数据
            if (i > 0){
                nums1[k--] = nums1[i--];
            }

            // 可能是nums2中还有数据
            if (j > 0){
                nums1[k--] = nums2[j--];
            }
        }
    }
}
