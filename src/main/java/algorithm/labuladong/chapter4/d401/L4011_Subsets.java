package algorithm.labuladong.chapter4.d401;

import java.util.ArrayList;
import java.util.List;

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
    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> subsets2(int[] nums) {
        List<Integer> temp = new ArrayList<Integer>();
        dfs(temp, nums, 0);
        return res;
    }

    private static void dfs(List<Integer> temp, int[] nums, int start) {
        res.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);  //① 加入 nums[i]
            dfs(temp, nums, i + 1);  //② 递归
            temp.remove(temp.size() - 1);  //③ 移除 nums[i]
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        List<List<Integer>> res2 = subsets2(nums);
        System.out.println("子集的个数：" + res.size() + ", " + res2.size());
    }

}
