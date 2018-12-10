package algo.Sword;

public class Q03_01_DuplicationInArray {

    public static boolean duplicate(int[] nums, int length, int duplication){
        if(nums == null || length < 0){
            return false;
        }
        for (int i = 0; i < length; i++) {
            if(nums[i] < 0 || nums[i] > length - 1){
                return false;
            }

        }

        // 多次循环，交换之后，数组变成{0,1,2,3,2,5,3}
        for (int i = 0; i < length; i++) {
            while (nums[i] != i){// 当i为4时，nums[4] == 2,
                if(nums[i] == nums[nums[i]]){// 比较nums[4] 与nums[nums[4]]（即nums[2] == 2）
                    duplication = nums[i];
                    return true;
                }

                // 交换nums[i] 与 nums[nums[i]]
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return false;
    }

    public static void main(String[] args){
        int[] arr = {2,3,1,0,2,5,3};
        for (int i = 0; i < arr.length; i++) {
            boolean dup = duplicate(arr, 7, arr[i]);
        }
    }


}
