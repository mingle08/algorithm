package algorithm.leetCode;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *
 */
public class LeetCode080_RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
//        LeetCode080_RemoveDuplicatesFromSortedArray solution = new LeetCode080_RemoveDuplicatesFromSortedArray();
        int[] arr = {1,1,1,2,2,3};
        int n = removeDuplicates(arr, 2);
        System.out.println(n);

    }

    private static int removeDuplicates(int[] nums, int k) {
        //special case
        if (nums == null) return 0;
        //base case;
        if (nums.length <= 2) return nums.length;
        int len = 2;
        //general case
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[len - 1] || nums[i] != nums[len - 2]) {
                nums[len] = nums[i];
                len++;
            }
        }
        return len;

    }
}
