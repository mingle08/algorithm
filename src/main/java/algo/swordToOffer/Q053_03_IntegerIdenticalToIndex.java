package algo.swordToOffer;

/**
 * 题目三：数组中数值和下标相等的元素
 */
public class Q053_03_IntegerIdenticalToIndex {
    public int getNumberSameAsIndex(int[] num, int len){
        if (num == null || len <= 0)
            return -1;

        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (num[mid] == mid)
                return mid;

            if (num[mid] > mid)
                right = mid - 1;

            if (num[mid] < mid)
                left = mid + 1;
        }
        return -1;
    }
}
