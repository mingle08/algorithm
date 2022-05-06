package algorithm.leetCode;

/**
 * Given nums = [0,0,1,1,1,2,2,3,3,4],

 Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

 It doesn't matter what values are set beyond the returned length.
 */
public class LeetCode026_RemoveDupFromSortedArray {

    public static int removeDup(int[] arr){
        if(arr.length == 0 || arr == null){
            return 0;
        }

        int len = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]){ // 当相邻二个不相等时，
                if (arr[i] != arr[len])   // 当下标i的元素 不等于 下标len的元素时
                    arr[len] = arr[i];
                len++;
            }
        }
        return len;
    }

    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDup(nums);
        System.out.println(len);

        /**
         * 去除重复的元素之后的nums为  {0,1,2,3,4,2,2,3,3,4}
         */
    }
}
