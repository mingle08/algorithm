package algo.leetCode;

/**
 * 解法：动态规划，用一个数组来存储每个格子上的路径数量，规则是：
 * 每个格子上的数量为上面格子的数量加上左边格子的数量（因为机器人
 * 只能往又走和往下走），所以一定是通过上面一个格子或者左边一个格
 * 子走到当前格子的，因此当前格子的数量为：
 *   从左边走过来的路径数+从上面走过来的路径数。
 *   1  1  1   1   1   1   1
 *   1  2  3   4   5   6   7
 *   1  3  6  10  15  21  28
 * 
 */
public class Q062_UniquePaths {

    public static void main(String[] args) {
        Q062_UniquePaths solution = new Q062_UniquePaths();
        int x = 3, y = 7;
        int z = solution.uniquePaths(x, y);
        System.out.println(z);

    }
    
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 || j==0) {// 第1行和第1列全部为1
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }
        
        return paths[m-1][n-1];
    }

}
