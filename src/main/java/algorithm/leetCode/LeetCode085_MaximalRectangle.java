package algorithm.leetCode;

import java.util.Stack;

public class LeetCode085_MaximalRectangle {


    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int [] heights = new int[n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j]+1;
            }

            res = Math.max(res, largestRec(heights));
        }

        return res;
    }

    private int largestRec(int [] heights){
        if(heights == null || heights.length == 0){
            return 0;
        }

        int res = 0;

        Stack<Integer> stk = new Stack<Integer>();
        stk.push(-1);
        for(int i = 0; i<heights.length; i++){
            while(stk.peek()!=-1 && heights[stk.peek()]>=heights[i]){
                int h = heights[stk.pop()];
                res = Math.max(res, h*(i-stk.peek()-1));
            }

            stk.push(i);
        }

        while(stk.peek() != -1){
            res = Math.max(res, heights[stk.pop()]*(heights.length-stk.peek()-1));
        }

        return res;
    }
}
