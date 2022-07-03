package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 *
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode051_N_Queens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        // 第i个位置存放的数表示row行，而值表示哪一列
        int[] queen = new int[n];
        //在第0行开始放Q
        placeQueen(queen, 0, n, res);
        return res;
    }
    private void placeQueen(int[] queen, int row, int n, List<List<String>> res) {
        //如果已经填满，就生成结果
        if (row == n) {
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = "";
                for (int col = 0; col < n; col++){
                    if(queen[i] == col) {
                        str += "Q";
                    } else {
                        str += ".";
                    }
                }
                list.add(str);
            }
            res.add(list);
        }
        //循环每一列
        for (int col = 0; col < n; col++) {
            //如果在该列放入Q不冲突的话
            if (isValid(queen, row, col)) {
                queen[row] = col;
                // 递归
                placeQueen(queen, row + 1, n, res);
            }
        }
    }

    private boolean isValid(int[] queen, int row, int col) {
        for (int i = 0; i < row; i++) {
            // i代表行，pos代表列
            int pos = queen[i];
            if (pos == col) { //和新加入的Q处于同一列
                return false;
            }
            int d = row - i;
            //在新加入的Q的右对角线上
            if (pos + d == col) {
                return false;
            }
            //在新加入的Q的左对角线上
            if (pos - d == col) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        LeetCode051_N_Queens solution = new LeetCode051_N_Queens();
        List<List<String>> result = solution.solveNQueens(5);
        System.out.println(result.size());
    }
}
