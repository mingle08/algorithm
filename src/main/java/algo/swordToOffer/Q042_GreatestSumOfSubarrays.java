package algo.swordToOffer;

public class Q042_GreatestSumOfSubarrays {
    boolean invalidInput = false;
    public int findGreatestSumOfSubarrays(int[] arr){
        if (arr == null || arr.length <= 0){
            invalidInput = true;
            return 0;
        }

        invalidInput = false;
        int curSum = 0;
        int greatestSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (curSum <= 0)
                curSum = arr[i];
            else
                curSum += arr[i];

            if (curSum > greatestSum)
                greatestSum = curSum;
        }
        return greatestSum;
    }

    public static void main(String[] args){
        Q042_GreatestSumOfSubarrays solution = new Q042_GreatestSumOfSubarrays();
        int[] num = {1, -2, 3, 10, -4, 7, 2, -5};
        int sum = solution.findGreatestSumOfSubarrays(num);
        System.out.println(sum);
    }
}
