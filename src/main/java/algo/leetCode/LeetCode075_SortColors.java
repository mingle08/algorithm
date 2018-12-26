package algo.leetCode;

public class LeetCode075_SortColors {

    public static void main(String[] args) {
        LeetCode075_SortColors solution = new LeetCode075_SortColors();
        int[] arr = {0, 0, 0, 1, 1, 1, 2, 1, 0, 2, 1, 2, 2, 2};
        solution.setColors(arr);

        solution.printArr(arr);
    }
    
    public void setColors(int[] nums){
        int j = 0, k = nums.length - 1;
        for (int i = 0; i <= k; i++) {
            // 遇到0和前面的交换
            if (nums[i] == 0 && j < nums.length-1)
                swap(nums, i, ++j);
            // 遇到2和后面的交换
            else if (nums[i] == 2)
                swap(nums, i--, k--);
        }
    }
    
    public void swap(int[] arr, int x, int y){
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    
    public void printArr(int[] num){
        for(int i = 0; i < num.length; i++){
            System.out.print(num[i] + " ");
        }
    }

}
