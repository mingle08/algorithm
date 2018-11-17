package algo.leetCode;

public class Q037_SudokuSolver {
    public void solveSudoku(char[][] grid) {
        if (grid == null || grid.length == 0) return;
        solve(grid);
    }

    private boolean solve(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(grid, i, j, ch)) {
                            grid[i][j] = ch;
                            if (solve(grid)) return true;
                            else grid[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValid(char[][] grid, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            if (grid[i][col] == ch) return false;
            if (grid[row][i] == ch) return false;
            if (grid[row/3*3+i/3][col/3*3+i%3] == ch) return false;
        }
        return true;
    }
}
