package algorithm.leetCode;

import java.util.*;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode056_MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0][2];
        }
        if (len == 1) return intervals;
        // 排序起点
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        // List保存数组，装的是没有重叠的区间
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            // list中最后一位的end，如果比当前start要小，则无法合并
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < start) {
                merged.add(new int[]{start, end});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], end);
            }
        }
        // List转数组
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        LeetCode056_MergeIntervals solution = new LeetCode056_MergeIntervals();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = solution.merge(intervals);
        for (int[] arr : res) {
            for (int a : arr) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
