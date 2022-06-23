package algorithm.labuladong.chapter5;

/**
 * 给你一个正整数数组weights和一个正整数D，期中weights代表一系列货物，
 * weights[i]的值代表第i件物品的重量，货物不可分割且必须按顺序运输。
 *
 * 请写一个算法，计算货船能够在D天内运完所有货物的最低运载能力。
 * 比如输入weights = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], D = 5，那么算法需要返回15.
 */
public class L503_2_ShipWithinDays {

    // 寻找左侧边界的二分搜索
    int shipWithinDays(int[] weights, int D) {
        // 载重可能的最小值，是所有货物中最重的那个
        int left = getMax(weights);
        // 载重可能的最大值（所有货物的总重量） + 1
        int right = getSum(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 如果载重为cap，是否能在D天内运完货物
    boolean canFinish(int[] w, int D, int cap) {
        int i = 0;
        for (int day = 0; day < D; day++) {
            // 每1天，都是这个载重
            int maxCap = cap;
            /**
             * 每次减去一个货物的重量
             * 如果装得下w[i]，索引i再往后走，
             * 如果下一个i装不下，就等待另一天的装载
              */
            while ((maxCap -= w[i]) >= 0) {
                i++;
                //
                if (i == w.length)
                    return true;
            }
        }
        return false;
    }

    int getSum(int[] piles) {
        int sum = 0;
        for (int n : piles)
            sum += n;

        return sum;
    }

    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles)
            max = Math.max(n, max);

        return max;
    }

    public static void main(String[] args) {
        L503_2_ShipWithinDays shipWithinDays = new L503_2_ShipWithinDays();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int minCap = shipWithinDays.shipWithinDays(nums, 5);
        System.out.println(minCap);
    }
}
