package algo.leetCode;

public class Q064_MinimumPathSum {

    public static void main(String[] args) {
        Q064_MinimumPathSum solution = new Q064_MinimumPathSum();
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};
        int sum = solution.minimumPathSum(grid);
        System.out.println(sum);
    }
    
    public int minimumPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
 
        int row = grid.length;  // 行
        int col = grid[0].length;  // 列
 
        int[][] dp = new int[row][col];  // 各元素的默认值是 0
 
        dp[0][0] = grid[0][0];
        // 初始化第一行
        for (int i = 1; i < col; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }
 
        // 初始化第一列
        for (int i = 1; i < row; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
 
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                /**
                 *                       dp[i - 1][j] 
                 *      dp[i][j - 1]       dp[i][j] 
                 *      dp[i][j] 等于 上或左 加上grid[i][j]
                 */
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
 
        return dp[row - 1][col - 1];
    }

}
