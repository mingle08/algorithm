package algorithm.leetCode;

public class LeetCode059_SpiralMatrixII {

    public static void main(String[] args) {
        LeetCode059_SpiralMatrixII solution = new LeetCode059_SpiralMatrixII();
        int num = 4;
        int[][] result = solution.generateMatrix(num);
        System.out.println(result[2][2]);

    }

    public int[][] generateMatrix(int n){
        int[][] res = new int[n][n];
        if(n < 1){
            return res;
        }
        int r1 = 0, r2 = n - 1;
        int c1 = 0, c2 = n - 1;
        int i = 1;
        int size = n * n;
        while(size > 0 && r1 <= r2 && c1 <= c2){
            for(int c = c1; c <= c2; c++){// 左  ---> 右
                res[r1][c] = i;
                i++;
                size--;
            }
            for(int r = r1 + 1; r <= r2; r++){// 上  ---> 下
                res[r][c2] = i;
                i++;
                size--;
            }
            if(r1 < r2 && c1 < c2){
                for(int c = c2 - 1; c > c1; c--){// 左    <--- 右
                    res[r2][c] = i;
                    i++;
                    size--;
                }
                for(int r = r2; r > r1; r--){// 上  <--- 下
                    res[r][c1] = i;
                    i++;
                    size--;
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;

        }
        return res;
    }

}
