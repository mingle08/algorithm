package algo.leetCode;

public class Q033_SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2,3};
        int target = 2;
//		int index = search(arr, target);
        int index = search_2(arr, target);
        System.out.println(index);

    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length-1);
    }

    private static int search(int[] nums, int target, int left, int right) {
        if(left == right){
            if(nums[left] == target){
                return left;
            }else{
                return -1;
            }
        }
        int mid = (left + right)/2;
        if(nums[mid] >= nums[left]){
            if(nums[left] <= target && target <= nums[mid]){
                return binarySearch(nums,target,left,mid);
            }else{
                return search(nums,target,mid+1,right);
            }
        }else{
            if(nums[mid] <= target && target <= nums[right]){
                return binarySearch(nums,target,mid,right);
            }else{
                return search(nums,target,left,mid);
            }
        }
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
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

    public static int search_2(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[mid] >= A[left]) {
                if (A[mid] > target && A[left] <= target) {// target在左半边
                    right = mid - 1;
                } else { // target在右半边
                    left = mid + 1;
                }
            } else {
                if (A[mid] < target && A[right] >= target) {// target在右半边
                    left = mid + 1;
                } else { // target在左半边
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
