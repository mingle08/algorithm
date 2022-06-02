package algorithm.codingInterviewChinese2;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目二：和为s的连续正数序列
 * 输入一个正数s，打印出所有和为s的连续正数序列（至少含有二个数）。
 * 例如，输入15，由于1+2+3+4+5 = 4+5+6=7+8 = 15，所以打印出三个连续序列：
 * 1~5，4~6， 7~8
 */
public class Q057_02_ContinousSequencesWithSum {

    public static List<List<Integer>> findNumbersWithSum(int target){
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (target < 3)
            return null;

        /**
         * 2个指针不后退，只右移不左移
         * 与二分查找的不同之处：
         * （1）起始位置不同：二分查找的2个指针，一个在下标0，一个在下标 length - 1，而此处2个指针，都在最左边，二者一前一后
         * （2）移动方向不同：二分查找左指针向右移动，右指针向左移动，是相向运动，而此处2个指针，都是向右移动
         * （3）查找的数据不同：二分查找有给定的数组，而此处，数组是从1开始递增的自然数
         */
        int lo = 1;
        int hi = 2;
        int curSum = lo + hi;
        while (lo < hi) {
            // 连续正整数的和
//            int curSum = (lo + hi) * (hi - lo + 1) / 2;
            if (curSum == target){
                packListIntoList(res, list, lo, hi);
                curSum -= lo;
                // 指针右移，不能后退（左指针右移）
                lo++;
            }
            // 多退
            else if (curSum > target) {
                // 舍弃lo所指的数
                curSum -= lo;
                // 指针右移，不能后退（左指针右移）
                lo++;
            }
            // 少补
            else {
                // 指针右移，不能后退（右指针右移）
                hi++;
                curSum += hi;
            }
        }

        return res;
    }

    private static void packListIntoList(List<List<Integer>> res, List<Integer> list, int start, int end){
        list.clear();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        res.add(new ArrayList<>(list));
    }

    public static void main(String[] args){
        List<List<Integer>> res = findNumbersWithSum(15);
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
