package algo.BeautyOfProgramming;

/**
 * 矩阵相乘
 */
public class Q2_09_Fibonacci {
    // 单位矩阵
    private static final int[][] UNIT = {{1,1}, {1,0}};

    public static int fibo(int n){
        if (n == 0){
            return 0;
        }
        int[][] res = fibonacci(n);
        return res[0][1];
    }

    private static int[][] fibonacci(int n){
        if (n == 1){
            return UNIT;
        }
        if (n % 2 == 0){
            int[][] matrix = fibonacci(n / 2);
            return matrixMultiply(matrix, matrix);
        }else {
            int[][] matrix = fibonacci((n-1) / 2);
            return matrixMultiply(UNIT, matrixMultiply(matrix, matrix));
        }
    }

    /*矩阵乘法*/
    private static int[][] matrixMultiply(int[][] a, int[][] b){
        int rows = a.length;
        int cols = b[0].length;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[i].length; k++) {
                    matrix[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return matrix;
    }

    /**
     * 方法2：用一维数组模拟矩阵
     */
    final static int[] A = {1, 1, 1, 0};
    public int fibonacci2(int n){
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        if (n > 1){
            int[] re = power(n-1);
            return re[0];// 矩阵乘积的第00项为所求
        }
        return -1;
    }

    // a^n = a^(n/2) * a^(n/2)   or   a^n = a^(n/2) * a^(n/2) * a
    private int[] power(int n){
        int[] a = new int[4];
        if (n == 1){
            a = A;
        } else if (n % 2 == 0){
            a = matrixMultiply(power(n/2),power(n/2));
        } else if (n % 2 == 1){
            int[] temp = matrixMultiply(power(n/2), power(n/2));
            a = matrixMultiply(A, temp);
        }
        return a;
    }

    //矩阵乘法
    // return A * B
    private int[] matrixMultiply(int[] a,int [] b){
        int[] re = new int[4];
        re[0] = a[0] * b[0] + a[1] * b[2];
        re[1] = a[0] * b[1] + a[1] * b[3];
        re[2] = a[2] * b[0] + a[3] * b[2];
        re[3] = a[2] * b[1] + a[3] * b[3];
        return re;
    }

    public static void main(String[] args){
        Q2_09_Fibonacci solution = new Q2_09_Fibonacci();
        int num = 20;
        int res = solution.fibo(num);
        int res2 = solution.fibonacci2(num);
        System.out.println(res);
        System.out.println(res2);
    }
}
