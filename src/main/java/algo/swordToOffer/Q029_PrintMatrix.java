package algo.swordToOffer;

/**
 * 顺时针方向打印矩阵
 */
public class Q029_PrintMatrix {

    public void PrintMatrixClockwisely(int[][] numbers, int cols, int rows){
        if (numbers == null || cols <= 0 || rows <= 0)
            return;

        int start = 0;
        while (cols > start * 2 && rows > start * 2){
            printMatrixCircle(numbers, cols, rows, start);
            start++;
        }
    }

    public void printMatrixCircle(int[][] numbers, int cols, int rows, int start){
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        
        // 从左到右打印一行
        for (int i = start; i <= endX ; i++) {
            int number = numbers[start][i];
            printNumber(number);
        }
        
        // 从上到下打印一列
        if (start < endY){
            for (int i = start + 1; i <= endY; i++) {
                int number = numbers[i][endX];
                printNumber(number);
            }
        }

        // 从右到左打印一行
        if (start < endX && start < endY){
            for (int i = endX - 1; i >= start ; i--) {
                int number = numbers[endY][i];
                printNumber(number);
            }
        }

        // 从下到上打印一列
        if (start < endX && start < endY - 1){
            for (int i = endY - 1; i >= start + 1 ; i--) {
                int number = numbers[i][start];
                printNumber(number);
            }
        }
    }

    public void printNumber(int num){
        System.out.print(num + " ");
    }
}
