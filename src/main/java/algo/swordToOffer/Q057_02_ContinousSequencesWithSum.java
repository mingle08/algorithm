package algo.swordToOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 和为s的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有二个数）。
 * 例如，输入15，由于1+2+3+4+5 = 4+5+6=7+8 = 15，所以打印出三个连续序列：
 * 1~5，4~6， 7~8
 */
public class Q057_02_ContinousSequencesWithSum {

    public List<List<Integer>> findNumbersWithSum(int sum){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (sum < 3)
            return null;

        int small = 1;
        int big = 2;
        int mid = (1 + sum) / 2;
        int curSum = small + big;

        while (small < big){
            if (curSum == sum){
                packListIntoList(res, list, small, big);
            }

            while (curSum > sum && small < mid){
                curSum -= small;
                small++;

                if (curSum == sum){
                    packListIntoList(res, list, small, big);
                }
            }

            big++;
            curSum += big;
        }

        return res;
    }

    private void packListIntoList(List<List<Integer>> res, List<Integer> list, int start, int end){
        list.clear();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        res.add(new ArrayList<>(list));
    }

    public static void main(String[] args){
        Q057_02_ContinousSequencesWithSum solution = new Q057_02_ContinousSequencesWithSum();
        List<List<Integer>> res = solution.findNumbersWithSum(15);
        System.out.println(res);
    }
}
