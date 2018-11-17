package algo.leetCode;

public class Q053_MaximumSubarray {

    public static void main(String[] args) {
        Q053_MaximumSubarray solution = new Q053_MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        int max = solution.maxSubarray(nums);
        int max = solution.maxSubarrayD(nums);
        System.out.println(max);

    }
    
    public int maxSubarray(int[] arr){
        int max = arr[0];
        int sum = max;
        for(int i=1;i<arr.length;i++){
            sum = Math.max(sum + arr[i], arr[i]);
            max = Math.max(sum, max);
        }
        return max;
    }
    
    public int maxSubarrayD(int[] nums) {
        int len=nums.length;
        if(nums==null || len==0)return 0;
        //dp[i]代表以nums[i]为结尾的最大和。
        int[] dp=new int[len];
        dp[0]=nums[0];
        int MAX=dp[0];
        for(int i=1;i<len;i++){
            if(dp[i-1]<0){
                dp[i]=nums[i];
            }else{
                dp[i]=dp[i-1]+nums[i];
            }
            MAX=Math.max(dp[i],MAX);
        }
        return MAX;
    }

}
