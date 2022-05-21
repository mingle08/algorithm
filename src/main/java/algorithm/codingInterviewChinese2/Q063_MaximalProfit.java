package algorithm.codingInterviewChinese2;

/**
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9, 11, 8, 5, 7, 12, 16, 14}。如果我们能在价格为5的时候
 * 买入并在价格为16时卖出，则能收获最大的利润11。*
 *
 */
public class Q063_MaximalProfit {
    public int maxDiff(int[] arr) {
        /**
         * 维护2个变量：
         * 最小值，最大利润
         *
         * 每次循环，判断最小值是不是最小的，最大利润是不是最大的
         */
        int min = arr[0];
        int maxDiff = arr[1] - min;

        for (int i = 2; i < arr.length; i++) {
            // min初始值是0下标的，此处i=2，所以要取i-1与min比较
            if (arr[i - 1] < min) {
                min = arr[i -1];
            }
            // 现在的最大利润
            int currMaxDiff = arr[i] - min;
            // 与之前的最大利润比较
            if (currMaxDiff > maxDiff) {
                maxDiff = currMaxDiff;
            }
        }
        return maxDiff;
    }
}
