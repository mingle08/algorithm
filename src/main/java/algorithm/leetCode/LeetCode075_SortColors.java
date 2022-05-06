package algorithm.leetCode;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
 * 并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
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
