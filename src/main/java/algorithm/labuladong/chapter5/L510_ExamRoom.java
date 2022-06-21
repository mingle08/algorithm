package algorithm.labuladong.chapter5;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 在考场里，一排有 N 个座位，分别编号为 0, 1, 2, …, N-1 。
 *
 * 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，那么学生就坐在 0 号座位上。)
 *
 * 返回 ExamRoom(int N) 类，它有两个公开的函数：
 * (1) 函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位置；
 * (2) 函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。
 * 每次调用 ExamRoom.leave 时都保证有学生坐在座位 p 上。
 *
 */
public class L510_ExamRoom {

    // 将端点p映射到以p为左端点的线段
    private Map<Integer, int[]> startMap;
    // 将端点p映射到以p为右端点的线段
    private Map<Integer, int[]> endMap;
    // 根据线段长度从小到大存放所有线段
    private TreeSet<int[]> pq;
    private int N;

    public L510_ExamRoom(int N) {
        this.N = N;
        startMap = new HashMap<>();
        endMap = new HashMap<>();
        pq = new TreeSet<>((a, b) -> {
            // 算出2个线段的长度
            int distA = distance(a);
            int distB = distance(b);
            // 如果长度相同，就比较索引
            if (distA == distB)
                return b[0] - a[0];
            // 长度更长的更大，排后面
            return distA - distB;
        });
        // 在有序集合中先放一个虚拟线段
        addInterval(new int[] {-1, N});
    }

    /* 去除线段 */
    private void removeInterval(int[] intv) {
        pq.remove(intv);
        startMap.remove(intv[0]);
        endMap.remove(intv[1]);
    }

    /* 增加线段 */
    private void addInterval(int[] intv) {
        pq.add(intv);
        startMap.put(intv[0], intv);
        endMap.put(intv[1], intv);
    }

    /* 计算线段的长度 */
    private int distance(int[] intv) {
//        return intv[1] - intv[0] - 1;
        int x = intv[0];
        int y = intv[1];
        if (x == -1) return y;
        if (y == N) return N - 1 - x;
        // 中点和端点之间的长度
        return (y - x) / 2;
    }

    public int seat() {
        // 从有序集合拿出最长的线段
        int[] longest = pq.last();
        int x = longest[0];
        int y = longest[1];
        int seat;
        if (x == -1) {
            // 情况1，最左边没人的话肯定坐最左边
            seat = 0;
        } else if (y == N) {
            // 情况2，最右边没人的话肯定坐最右边
            seat = N - 1;
        } else {
            // 情况3，不是边界的话，就坐中间
            seat = (y - x) / 2 + x;
        }
        // 将最长的线段分成2段
        int[] left = new int[] {x, seat};
        int[] right = new int[] {seat, y};
        removeInterval(longest);
        addInterval(left);
        addInterval(right);
        return seat;
    }

    public void leave(int p) {
        // 将p左右的线段找出来
        int[] right = startMap.get(p);
        int[] left = endMap.get(p);
        // 将2个线段合并为一条线段
        int[] merged = new int[] {left[0], right[1]};
        // 删除旧线段，插入新线段
        removeInterval(left);
        removeInterval(right);
        addInterval(merged);
    }
}
