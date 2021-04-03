package algo.codingInterviewChinese2;

public class Q047_MaxValueOfGifts {
    public int getMaxValue1(int[][] grid, int rows, int cols){
        if (grid == null || rows <=0 || cols <= 0)
            return 0;

        int[][] maxVal = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxVal[i - 1][j];

                if (j > 0)
                    left = maxVal[i][j - 1];

                maxVal[i][j] = Math.max(left, up) + grid[i][j];
            }
        }
        return maxVal[rows - 1][cols - 1];
    }

    /**
     * 优化，用一维数组：
     * 当我们计算到达坐标为(i, j)的格子时，能够拿到的礼物的最大价值f(i,j),
     * 此一维数组中前j个数字分别是f(i,0), f(i,1), ..., f(i,j-1),
     * 数组从下标为j的数字开始到最后一个数字，分别为f(i-1,j), f(i-1,j+1),
     * f(i-1,j+2), ... , f(i-1, n-1).
     * 也就是说，该数组前面j个数字分别是当前第i行前面j个格子礼物的最大价值，
     * 而之后的数字分别保存前面第i-1行n-j个格子礼物的最大价值
     */

    public int getMaxValue2(int[][] grid, int rows, int cols){
        if (grid == null || rows <= 0 || cols <= 0)
            return 0;

        int[] maxVal = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0)
                    up = maxVal[j];

                if (j > 0)
                    left = maxVal[j - 1];

                maxVal[j] = Math.max(left, up) + grid[i][j];
            }
        }
        return maxVal[cols - 1];
    }

    public static void main(String[] args){
        Q047_MaxValueOfGifts solution = new Q047_MaxValueOfGifts();
        int[][] grid = {{1, 10, 3, 8},
                        {12, 2, 9, 6},
                        {5, 7, 4, 11},
                        {3, 7, 16, 5}};
        int rows = grid.length;
        int cols = grid[0].length;
        int maxValue1 = solution.getMaxValue1(grid, rows, cols);
        int maxValue2 = solution.getMaxValue2(grid, rows, cols);
        System.out.println(maxValue1 + ", " + maxValue2);
    }
}
