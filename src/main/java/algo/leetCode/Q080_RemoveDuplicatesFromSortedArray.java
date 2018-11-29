package algo.leetCode;

public class Q080_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Q080_RemoveDuplicatesFromSortedArray solution = new Q080_RemoveDuplicatesFromSortedArray();
        int[] arr = {1,1,1,2,2,3};
        int n = solution.removeDuplicates(arr, 2);
        System.out.println(n);

    }
    
    private int removeDuplicates(int[] nums, int k) {
        int repeat= k; 
        if(nums.length<=repeat)
            return nums.length; 
        int len=1; 
        int cnt=1; 
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[len-1]){ 
                cnt=1;
                nums[len++]=nums[i]; 
            } else{ 
                cnt++; 
                if(cnt>repeat){ 
                    continue; 
                } else{ 
                    nums[len++]=nums[i]; 
                } 
            } 
        } 
        return len;
      
    }
   
}
