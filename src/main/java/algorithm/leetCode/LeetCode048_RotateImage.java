package algorithm.leetCode;

/**
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class LeetCode048_RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // along the left top to right bottom diagonal line, swap symmetrical pair
        for (int i = 0; i < n; i++) {// for each row
            for (int j = i + 1; j < n; j++) { // for each number
                swap(matrix, i, j, j, i);
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
            }
        }

        // flip each row horizontally
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[i][n-1-j];
//                matrix[i][n-1-j] = temp;
            }
        }
    }

    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                // 暂存上
                temp = matrix[i][j];
                // 左 -> 上 （原来左列转到上行）
                matrix[i][j] = matrix[n - 1 - j][i];
                // 下 -> 左 （原来下行转到左列）
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                // 右 -> 下 （原来右列转到下行）
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                // 上 -> 右 （原来上行转到右列）
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * 矩阵交换元素的值
     *
     * @description
     * @author
     * @date 2018年11月2日下午2:59:50
     */
    private void swap(int[][] matrix, int x, int y, int m, int n) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[m][n];
        matrix[m][n] = temp;
    }

    public static void main(String[] args) {
        LeetCode048_RotateImage solution = new LeetCode048_RotateImage();
        int[][] mat = {{5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        printMatrix(mat);
        solution.rotate(mat);

        System.out.println("=========================");
        printMatrix(mat);

    }
}
