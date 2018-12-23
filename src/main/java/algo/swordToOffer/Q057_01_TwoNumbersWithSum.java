package algo.swordToOffer;

public class Q057_01_TwoNumbersWithSum {

    public int[] findNumbersWithSum(int[] num, int len, int sum){
        if (num == null || len < 1)
            return null;

        int[] res = new int[2];
        int start = 0;
        int end = len - 1;
        while (start < end){
            int curSum = num[start] + num[end];
            if (curSum == sum){
                res[0] = num[start];
                res[1] = num[end];
                break;
            } else if (curSum > sum)
                end--;
            else
                start++;
        }
        return res;
    }

    public static void main(String[] args){
        Q057_01_TwoNumbersWithSum solution = new Q057_01_TwoNumbersWithSum();
        int[] arr = {1, 2, 4, 7, 11, 15};
        int length = arr.length;
        int[] res = solution.findNumbersWithSum(arr, length, 15);

        System.out.println(res[0] + ", " + res[1]);
    }
}
