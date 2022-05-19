package algorithm.codingInterviewChinese2;

/**
 * 题目二：不修改数组，找出重复的数字
 * 在一个长度为n+1的数组里，所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的，
 * 请找出数组中任意一个重复的数字，但不能改变输入的数组。
 * 例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么 对应的输出是重复的数字2或者3.
 *
 * 这个数组把4放在中间容易引起误解，因为下面要求的mid，不是这个处在最中间的数字，而是1~7范围内的数字的中位数
 * 那就是4，所以把数组的元素调换一下，变成{4,3,5,2,3,2,6,7}
 *
 * 思路：利用二分的思想，将数组值1~n分割为1~mid的n1，mid+1 ~ n的n2;
 * 从头开始遍历一遍数组， 统计在1~mid范围内数组中值的个数count，
 * 如果count > mid,那么重复的数字就在该半个数组中(n1)，否则在n2；
 * 直到end = start,找到重复的。时间复杂度为O(nlogn);
 *
 * 4 3 5 2 3 2 6 7
 *
 * 不存在重复数字的理想数组
 * 1 2 3 4 5 6 7 8
 *
 * 遍历的数字是目标数组的，移动的左右指针却是理想数组的
 *
 */
public class Q003_02_DuplicationInArray {
    public int getDup(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int start = 1;
        int end = nums.length - 1;
        while(end >= start){
            // mid是中位数，跟数组最中间的数字没关系，是理想数组的中间数
            int mid = ((end - start) >> 1) + start;
            // 比如第一次mid是4，统计整个数组在1到4之前的数
            int count = countRange(nums, start, mid);
            System.out.println("比" + mid + "小的数字个数为：" + count);
            if(end == start){
                if(count > 1){
                    return start;
                }else{
                    break;
                }
            }
            // 小于中位数的个数大于
            if (count > (mid - start + 1)){
                System.out.println("count的个数大于" + (mid - start + 1) + "，重复的数在理想数组的前面");
                end = mid;
            } else {
                System.out.println("count的个数小于" + (mid - start + 1) + "，重复的数在理想数组的后面");
                start = mid + 1;
            }
        }
        return -1;
    }

    int countRange(int[] nums, int start, int end){
        if(nums == null){
            return 0;
        }
        int count = 0;
        // 遍历整个数组，统计理想数组的前半段或后半段这几个数字在数组中出现的次数
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= start && nums[i] <= end){
                ++count;
            }
        }
        return count;
    }


    public static void main(String[] args){
        Q003_02_DuplicationInArray solution = new Q003_02_DuplicationInArray();
        int[] arr = {4,3,5,2,3,2,6,7};
        int dup = solution.getDup(arr);
        System.out.println(dup);
    }
}
