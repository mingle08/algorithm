package algorithm.labuladong.chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 贪心算法
 * 区间调度问题
 * 给你很多形如[start, end]的闭区间，请设计一个算法，算出这些区间中最多有几个互不相交的区间
 * 举个例子，intvs = [[1,3],[2,4],[3,6]]，这些区间最多有2个区间互不相交，即[[1,3],[2,4]]，
 * 你的算法应该返回2.
 * 注意，边界相同并不算相交
 *
 * 思路很简单，分三步：
 * 1 从区间集合intvs中选择一个区间x，这个x是在当前所有区间中结束最早的（end最小）
 * 2 把所有与x区间相交的区间从区间集合intvs中删除
 * 3 重复步骤1和2，直到intvs为空。之前选出的那些x就是最大不相交子集
 */
public class L508_IntervalSchedule {

    int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return  0;
        // 按end升序排序
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        // 至少有一个区间不相交
        int count  = 1;
        // 排序后，第一个区间就是x
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            if (start >= x_end) {
                // 找到下一个选择的区间了
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }

    /**
     * 输入一个区间的集合，请计算，要拿其中的区间互不重叠，至少需要移除几个区间
     */
    int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        return n - intervalSchedule(intervals);
    }

    /**
     * 用最少的箭头射爆气球🎈
     * 假设在二维平面上有很多圆形的气球，这些圆形投影到x轴上会形成一个区间，
     * 那么给你输入这些区间，沿着x轴前进，可以垂直向上射箭，请问至少要射几箭才能把这些气球全部射爆？
     */
    int findMinArrowShots(int[][] intvs) {
        if (intvs.length == 0) return 0;
        Arrays.sort(intvs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int count = 1;
        int x_end = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            // 把 >= 改成 > 就行了
            if (start > x_end) {
                count++;
                x_end = interval[1];
            }
        }
        return count;
    }
}
