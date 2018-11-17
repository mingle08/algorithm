package algo.leetCode;

import java.util.HashSet;

public class Q036_ValidSoduku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] grid) {
        for (int i = 0; i < 9; i++) {
            HashSet<Character> row = new HashSet<>();
            HashSet<Character> column = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                // 检查第i行，在横坐标位置
                if (grid[i][j] != '.' && !row.add(grid[i][j]))
                    return false;
                // 检查第i列，在纵坐标位置
                if (grid[j][i] != '.' && !column.add(grid[j][i]))
                    return false;
                // 行号+偏移量
                int RowNum = 3 * (i / 3) + j / 3;
                // 列号+偏移量
                int ColNum = 3 * (i % 3) + j % 3;
                //每个小九宫格，总共9个
                if (grid[RowNum][ColNum] != '.'
                        && !cube.add(grid[RowNum][ColNum]))
                    return false;
            }
        }
        return true;
    }

    /**
     * @param e element to be added to this set
     * @return <tt>true</tt> if this set did not already
     * contain the specified element
    put方法的返回值为null或value；

    调用put方法时，如果已经存在一个相同的key， 则返回的是前一个key对应的value，同时该key的新value覆盖旧value；
    如果是新的一个key，则返回的是null；
    public boolean add(E e) {
    return map.put(e, PRESENT)==null;
    }

     */
}
