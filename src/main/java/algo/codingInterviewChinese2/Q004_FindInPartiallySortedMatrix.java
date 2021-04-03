package algo.codingInterviewChinese2;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 思路：每次选取右上角（或左下角）的元素
 */
public class Q004_FindInPartiallySortedMatrix {

    public boolean find(int[][] matrix, int num){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0){ // 因为row是递增，col是递减

            // matrix[row][col] 是右上角的元素
            if (matrix[row][col] > num){  // 1. 如果右上角的元素比目标大，删除右上角元素所在的这一列
                col--;
            } else if (matrix[row][col] < num){  // 2. 如果右上角的元素比目标小，删除右上角元素所在的这一行
                row++;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Q004_FindInPartiallySortedMatrix solution = new Q004_FindInPartiallySortedMatrix();

        int[][] nums = {{1, 2, 8, 9},
                        {2, 4, 9, 12},
                        {4, 7, 10, 13},
                        {6, 8, 11, 15}};

        boolean flag = solution.find(nums, 7);
        System.out.println(flag);


    }
}
