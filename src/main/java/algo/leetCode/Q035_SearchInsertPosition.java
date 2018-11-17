package algo.leetCode;

public class Q035_SearchInsertPosition {
    public static void main(String[] args) {

        Q035_SearchInsertPosition solution = new Q035_SearchInsertPosition();
        int[] nums = {1,3,5,7};
        int target = 6;
        int index = solution.binarySearch(nums, target, 0, nums.length - 1);
        System.out.println(index);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        if(left > right)
            return -1;
        if(left == right){// 插入位置的判断
            if(nums[left] >= target){
                return left;
            }else{
                return right + 1;
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
