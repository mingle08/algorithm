package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode073_SetMatrixZeros {

    public static void main(String[] args) {
        LeetCode073_SetMatrixZeros solution = new LeetCode073_SetMatrixZeros();
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        solution.printMatrix(matrix);
        solution.setZeros(matrix);
        System.out.println("==========================");
        solution.printMatrix(matrix);
    }
    
    public void setZeros(int[][] matrix){
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        for(int i=0; i < rowNum; i++){
            for(int j=0; j< colNum; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for(int m=0; m < rowNum; m++){
            for(int n=0; n< colNum; n++){
                if(rows.contains(m) || cols.contains(n)){
                    matrix[m][n] = 0;
                }
            }
        }
    }
    
    public void printMatrix(int[][] matrix){
        for(int i=0; i < matrix.length; i++){
            for(int j=0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
