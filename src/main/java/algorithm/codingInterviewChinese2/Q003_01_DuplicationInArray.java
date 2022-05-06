package algorithm.codingInterviewChinese2;

/**
 * 题目一：找出数组中重复的数字
 * 在一个长度为n的数组里，所有数字都在0~n-1的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3
 */
public class Q003_01_DuplicationInArray {

    public static int duplicate(int[] nums){
        if(nums == null || nums.length < 0){
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] < 0 || nums[i] > nums.length - 1){
                return -1;
            }

        }

        // 多次循环，交换之后，数组变成{0,1,2,3,2,5,3}
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i){// 当i为4时，nums[4] == 2,
                if(nums[i] == nums[nums[i]]){// 比较nums[4] 与nums[nums[4]]（即nums[2] == 2）
                    return nums[i];
                }

                // 交换nums[i] 与 nums[nums[i]]
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }

        return -1;
    }


    public static void main(String[] args){
        int[] arr = {2,3,1,0,2,5,3};
        int dup = duplicate(arr);
        System.out.println("重复的数据为：" + dup);
    }


}
