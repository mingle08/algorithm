package algo.leetCode;

public class Q034_SearchForARange {
    public static void main(String[] args) {

        Q034_SearchForARange solution = new Q034_SearchForARange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = solution.searchRange(nums, target);
        System.out.println("{" + result[0] + ", " + result[1] + "}");
    }

    public int[] searchRange(int[] nums, int target) {
        // 1. 找到第一个目标值的下标，作为mid
        int mid = binarySearch(nums, target, 0, nums.length-1);
        // 2. 在0，mid-1 之间查找
        int left = mid;
        int left_temp = binarySearch(nums, target, 0, mid-1);
        while(left_temp != -1){
            left = left_temp;
            left_temp = binarySearch(nums, target, 0, left_temp-1);
        }
        // 3. 在mid+1, 最大下标之间查找
        int right = mid;
        int right_temp = binarySearch(nums, target, mid+1, nums.length-1);
        while(right_temp != -1){
            right = right_temp;
            right_temp = binarySearch(nums, target, right_temp+1, nums.length-1);
        }

        int[] result = {left,right};
        return result;
    }
    private int binarySearch(int[] nums, int target, int left, int right) {
        if(left > right)
            return -1;
        if(left == right){
            if(nums[left] == target){
                return left;
            }else{
                return -1;
            }
        }
        int mid = (left + right)/2;
        if(target < nums[mid]){
            return binarySearch(nums,target,left,mid);
        }else if(target == nums[mid]){
            return mid;
        }else{
            return binarySearch(nums,target,mid+1,right);
        }
    }
}
