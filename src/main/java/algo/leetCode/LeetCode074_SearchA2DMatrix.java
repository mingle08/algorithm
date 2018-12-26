package algo.leetCode;

public class LeetCode074_SearchA2DMatrix {

    public static void main(String[] args) {
        LeetCode074_SearchA2DMatrix solution = new LeetCode074_SearchA2DMatrix();
        int[][] nums = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
//        boolean flag = solution.findItem(nums, 11);
        Integer[] index = solution.findIndex(nums, 18);
        if(index != null){
            System.out.println("index[0]: " + index[0] + ", index[1]: " + index[1]);
        }else{
            System.out.println("未找到");
        }
        
    }
    
    public boolean findItem(int[][] matrix, int target){
        int m = matrix.length;  // 行
        int n = matrix[0].length;  // 列
        int left=0, right = m * n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[mid/n][mid%n] > target){
                right = mid - 1;
            }else if(matrix[mid/n][mid%n] == target){
                return true;
            }else if(matrix[mid/n][mid%n] < target){
                left = mid + 1;
            }
        }
        return false;
    }
    
    public Integer[] findIndex(int[][] matrix, int target){
        Integer[] index = null;
        int m = matrix.length;  // 行
        int n = matrix[0].length;  // 列
        int left=0, right = m * n - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(matrix[mid/n][mid%n] > target){
                right = mid - 1;
            }else if(matrix[mid/n][mid%n] == target){
                index = new Integer[2];
                index[0] = mid/n;
                index[1] = mid%n;
                return index;
            }else if(matrix[mid/n][mid%n] < target){
                left = mid + 1;
            }
        }
        return index;
    }

}
