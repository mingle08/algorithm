package algo.leetCode;

/**
 * 创建一个二维数组paths，与给定的obstacleGrid二维数组维数相同
 * 各元素的默认值是0
 * 如果obstacleGrid的第0行和第0列的元素的值不为1，就将paths对应的元素设为1
 * obstacleGrid
 *      0 0 0 0
 *      0 1 0 0 
 *      0 0 0 0
 * 
 * paths
 *      1 1 1 1
 *      1 0 A B
 *      1 C D E
 * A,B,C,D,E位置都是默认值0，通过 A左 + A上得到1
 * 同理得到B=2, C=1, D=2, E=4
 */
public class Q063_UniquePathsII {

    public static void main(String[] args) {
        Q063_UniquePathsII solution = new Q063_UniquePathsII();
        int[][] obstacleGrid = {{0,0,0,0},
                                {0,1,0,0},
                                {0,0,0,0}};
        int row = obstacleGrid.length;  // 行
        int col = obstacleGrid[0].length;  // 列
        System.out.println("二维数组obstacleGrid的有 " + row +" 行，" + col + " 列。");
        int num = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(num);

    }
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //动态规划，使用二维数组
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        
        // 列
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] != 1){
                paths[i][0] = 1;
            } else {
                break;
            }
        }
        
        // 行
        for (int j = 0; j < n; j++){
            if (obstacleGrid[0][j] != 1){
                paths[0][j] = 1;
            } else{
                break;
            }
        }
        
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                if (obstacleGrid[i][j] != 1){
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                } else {// 有障碍就是0
                    paths[i][j] = 0;
                }
            }
        }
        return paths[m-1][n-1];
        
    }
     

}
