package algorithm.codingInterviewChinese2;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 * 动态规划
 * 定义dp的意义：dp[row][col] 是走到 [row][col] 位置时的最大值
 */
public class Q047_MaxValueOfGifts {

    public int getMaxValue1(int[][] grid, int rows, int cols) {
        if (grid == null || rows <= 0 || cols <= 0)
            return 0;
        // 二维数组
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                // 上方
                if (i > 0)
                    up = dp[i - 1][j];

                // 左方
                if (j > 0)
                    left = dp[i][j - 1];

                // 求出上方和左方的最大值，加上此格的值
                dp[i][j] = Math.max(left, up) + grid[i][j];
            }
        }
        return dp[rows - 1][cols - 1];
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
    public int getMaxValue2(int[][] grid, int rows, int cols) {
        if (grid == null || rows <= 0 || cols <= 0)
            return 0;

        int[] dp = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                // 此刻是grid[i - 1][j]，只要i > 0，up的横坐标 i-1才不报错
                if (i > 0)
                    up = dp[j];
                // 同样此刻是grid[i][j - 1]，只要j > 0，left的纵坐标 j-1才不报错
                if (j > 0)
                    left = dp[j - 1];

                dp[j] = Math.max(left, up) + grid[i][j];
            }
        }
        return dp[cols - 1];
    }

    public static void main(String[] args) {
        Q047_MaxValueOfGifts solution = new Q047_MaxValueOfGifts();
        int[][] grid = {{1, 10, 3, 8},
                        {12, 2, 9, 6},
                        {5, 7, 4, 11},
                        {3, 7, 16, 5}};
        int rows = grid.length;
        int cols = grid[0].length;
        int dpue1 = solution.getMaxValue1(grid, rows, cols);
        int dpue2 = solution.getMaxValue2(grid, rows, cols);
        System.out.println(dpue1 + ", " + dpue2);
    }
}
