package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q054_SpiralMatrix {

    public static void main(String[] args) {
        Q054_SpiralMatrix solution = new Q054_SpiralMatrix();
        int[][] matrix = {
                            {1,  2, 3, 4},
                            {5,  6, 7, 8},
                            {9, 10,11,12},
                            {13,14,15,16}
        };
        List<Integer> res = solution.spiralOrder2(matrix);
        for(int i=0; i<res.size();i++){
            System.out.print(res.get(i) + " ");
        }
        
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix.length == 0) return ans;
        int R = matrix.length, C = matrix[0].length;
        boolean[][] seen = new boolean[R][C];
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int r = 0, c = 0, di = 0;
        for (int i = 0; i < R * C; i++) {
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int cr = r + dr[di];
            int cc = c + dc[di];
            if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                r = cr;
                c = cc;
            } else {
                di = (di + 1) % 4;
                r += dr[di];
                c += dc[di];
            }
        }
        return ans;
    }
    
    public List < Integer > spiralOrder2(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;  // 行
        int c1 = 0, c2 = matrix[0].length - 1;  // 列
        while (r1 <= r2 && c1 <= c2) {
            // 向右
            for (int c = c1; c <= c2; c++) 
                ans.add(matrix[r1][c]);
            // 向下
            for (int r = r1 + 1; r <= r2; r++) 
                ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                // 向左
                for (int c = c2 - 1; c > c1; c--) 
                    ans.add(matrix[r2][c]);
                // 向上
                for (int r = r2; r > r1; r--) 
                    ans.add(matrix[r][c1]);
            }
            // 一圈之后，再向右往里转，重复右 -> 下 -> 左  -> 上
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }

}
