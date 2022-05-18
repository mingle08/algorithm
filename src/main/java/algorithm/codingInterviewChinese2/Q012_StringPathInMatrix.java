package algorithm.codingInterviewChinese2;

public class Q012_StringPathInMatrix {

    private static boolean hasPath(char[][] matrix, char[] str) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (matrix == null || rows < 1 || cols < 1 || str == null)
            return false;

        boolean[] visited = new boolean[rows * cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        if (pathLength == str.length) {
            return true;
        }

        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == str[pathLength]
                && !visited[row * cols + col]) {
            pathLength++;
            visited[row * cols + col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength, visited);

            if (!hasPath) {
                pathLength--;
                visited[row * cols + col] = false;
            }
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[3][4];
        matrix[0][0] = 'a';
        matrix[0][1] = 'b';
        matrix[0][2] = 't';
        matrix[0][3] = 'g';

        matrix[1][0] = 'c';
        matrix[1][1] = 'f';
        matrix[1][2] = 'c';
        matrix[1][3] = 's';

        matrix[2][0] = 'j';
        matrix[2][1] = 'd';
        matrix[2][2] = 'e';
        matrix[2][3] = 'h';

        char[] str = new char[4];
        str[0] = 'b';
        str[1] = 'f';
        str[2] = 'c';
        str[3] = 'e';

        boolean hasPath = hasPath(matrix, str);
        System.out.println(hasPath);
    }
}