package algo.swordToOffer;

/**
 * 题目描述
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 */
public class Q013_RobotMove {

    public int movingCount(int rows, int cols, int threshold){
        if (rows <= 0 || cols <= 0 || threshold < 0)
            return 0;

        /**
         * 每个格子对应一个计算出的数字：row * cols + col
         */
        boolean[] isVisited = new boolean[rows * cols];
        int count = movingCountCore(rows, cols, threshold, 0, 0, isVisited);
        return count;
    }

    private int movingCountCore(int rows, int cols, int threshold, int row, int col, boolean[] isVisited){
        int count = 0;
        if (check(rows, cols, threshold, row, col, isVisited)){
            isVisited[row * cols + col] = true;
            count = 1 + movingCountCore(rows, cols, threshold, row-1, col, isVisited)  // 上
                    + movingCountCore(rows, cols, threshold, row+1, col, isVisited)   // 下
                    + movingCountCore(rows, cols, threshold, row, col-1, isVisited)    // 左
                    + movingCountCore(rows, cols, threshold, row, col+1, isVisited);   // 右
        }
        return count;
    }

    private boolean check(int rows, int cols, int threshold, int row, int col, boolean[] isVisited){
        if (row >= 0 && row <= rows && col >= 0 && col <= cols
                && !isVisited[row * cols + col]
                && getDigitSum(row) + getDigitSum(col) < threshold)
            return true;

        return false;
    }

    private int getDigitSum(int number){
        int sum = 0;
        while (number > 0){
            sum += number % 10;   // 先取个位数
            number /= 10;
        }

        return sum;
    }
}
