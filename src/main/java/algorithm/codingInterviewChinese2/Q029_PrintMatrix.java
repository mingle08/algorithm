package algorithm.codingInterviewChinese2;

/**
 * 顺时针方向打印矩阵
 * 二维数组第一个数组表示行，第二个数组表示列
 */
public class Q029_PrintMatrix {

    public static void PrintMatrixClockwisely(int[][] numbers){
        int rows = numbers.length;
        int cols = numbers[0].length;
        if (numbers == null || cols <= 0 || rows <= 0)
            return;

        int start = 0;
        while (cols > start * 2 && rows > start * 2){
            printMatrixCircle(numbers, rows, cols, start);
            start++;
        }
    }

    public static void printMatrixCircle(int[][] numbers, int rows, int cols, int start){
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        // 从左到右打印一行 numbers[start][i]，表示二维数组第start行第i个数
        for (int i = start; i <= endX ; i++) {
            int number = numbers[start][i];
            printNumber(number);
        }

        // 从上到下打印一列 numbers[j][endX]，表示二维数组第j行第endX个数
        if (start < endY){
            for (int j = start + 1; j <= endY; j++) {    // 因为第一行已经打印过，所以 j = start + 1
                int number = numbers[j][endX];
                printNumber(number);
            }
        }

        // 从右到左打印一行 numbers[endY][k]，表示第endY行第k个数
        if (start < endX && start < endY){
            for (int k = endX - 1; k >= start ; k--) {
                int number = numbers[endY][k];
                printNumber(number);
            }
        }

        // 从下到上打印一列 numbers[m][start]，表示第m行第start个数
        if (start < endX && start < endY - 1){
            for (int m = endY - 1; m >= start + 1 ; m--) {    // 因为第一行已经打印过，所以 m >= start + 1
                int number = numbers[m][start];
                printNumber(number);
            }
        }
    }

    public static void printNumber(int num){
        System.out.print(num + " ");
    }

    public static void main(String[] args) {
        /**
         * 1    2    3    4
         * 5    6    7    8
         * 9    10   11   12
         * 13   14   15   16
         */
        int[][] nums = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        PrintMatrixClockwisely(nums);
    }
}
