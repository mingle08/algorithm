package algorithm.labuladong.chapter5;

/**
 * Koko吃香蕉
 * 输入一个长度为N的正整数数组piles，代表N堆香蕉
 * piles[i]代表第i堆香蕉的数量，现在，Koko要在H小时内吃完这些香蕉
 * Koko吃香蕉的速度为每小时K根，而且每小时最多吃一堆香蕉，如果吃不下的话留到下一个小时再吃；
 * 如果吃完了还有胃口，他也只能等到下一个小时才吃下一堆。
 *
 * 请你写一个算法，计算Koko每小时至少吃几根香蕉，才能在H小时内把这些香蕉都吃完
 */
public class L503_EatingBanana {

    /**
     *
     * @param piles  香蕉的堆数
     * @param H  Koko要在H小时内吃完这些香蕉
     * @return
     */
    int minEatingBanana(int[] piles, int H) {
        // speed最小值是1，最大为max(piles)
        int left = 1, right = getMax(piles) + 1;
        while (left < right) {
            // speed的中间值
            int mid = left + (right - left) / 2;
            if (canFinish(piles, mid, H)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 时间复杂度O(N)
     * 吃完每一堆消耗的时间，相加的总和，是否小于规定时间H
      */
    boolean canFinish(int[] piles, int speed, int H) {
        int time = 0;
        for (int n : piles) {
            time += timeOf(n, speed);
        }
        return time <= H;
    }

    // 以speed的速度吃n个香蕉，要多久
    int timeOf(int n, int speed) {
        return (n / speed) + ((n % speed > 0) ? 1 : 0);
    }

    // 计算数组的最大值
    int getMax(int[] piles) {
        int max = 0;
        for (int n : piles)
            max = Math.max(n, max);

        return max;
    }


}
