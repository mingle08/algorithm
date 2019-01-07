package algo.leetCode;

public class LeetCode041_FirstMissingPositive {

	public static void main(String[] args) {
	    LeetCode041_FirstMissingPositive solution = new LeetCode041_FirstMissingPositive();
//		int[] nums = {1,2,0};
		int[] nums = {5,8,9};
		int num = solution.firstMissingPositive(nums);
		System.out.println(num);

	}
	
	
    public int firstMissingPositive(int[] nums) {
        if(nums == null){
            throw new IllegalArgumentException("Input array is null.");
        }
        
        for(int i = 0; i<nums.length; i++){
            int temp = nums[i]-1;
            if(temp>=0 && temp < nums.length && nums[i] != nums[temp]){
                swap(nums, i, temp);
                i--;
            }
        }
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        
        return nums.length+1;
    }
    
    private void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
