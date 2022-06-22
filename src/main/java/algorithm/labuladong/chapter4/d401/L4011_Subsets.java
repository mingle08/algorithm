package algorithm.labuladong.chapter4.d401;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个不包含重复数字的数组，要求算法输出这些数字的所有子集
 */
public class L4011_Subsets {

    /**
     * 数学归纳法
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp;
        res.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int len = res.size();
            for (int j = 0; j < len; j++) {
                tmp = new ArrayList<>(res.get(j));
                tmp.add(nums[i]);
                res.add(new ArrayList<>(tmp));
                tmp.clear();
            }
        }
        return res;
    }


    /**
     * 回溯法
     */
    static List<List<Integer>> res = new LinkedList<List<Integer>>();

    public static List<List<Integer>> subsets2(int[] nums) {
        // LinkedList可以方便地removeLast
        LinkedList<Integer> temp = new LinkedList<Integer>();
        dfs(temp, nums, 0);
        return res;
    }

    private static void dfs(LinkedList<Integer> temp, int[] nums, int start) {
        // 直接添加，不需要判断
        res.add(new LinkedList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            //① 加入 nums[i]
            temp.add(nums[i]);
            //② 递归
            dfs(temp, nums, i + 1);
            //③ 移除 nums[i]
            temp.removeLast();
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        List<List<Integer>> res2 = subsets2(nums);
        System.out.println("子集的个数：" + res.size() + ", " + res2.size());
        for (List<Integer> list : res) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (List<Integer> list : res2) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
