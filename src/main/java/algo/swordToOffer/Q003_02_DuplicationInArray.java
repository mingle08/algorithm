package algo.swordToOffer;

/**
 * 利用二分的思想，将数组值1~n分割为1~mid的n1，mid+1 ~ n的n2;
 * 从头开始遍历一遍数组， 统计在1~mid范围内数组中值的个数count，
 * 如果count > mid,那么重复的数字就在该半个数组中(n1)，否者在n2；
 * 直到end = start,找到重复的。时间复杂度为O(nlogn);
 *
 */
public class Q003_02_DuplicationInArray {
    public int getDup(int[] nums, int length){
        if(nums == null || length < 0){
            return -1;
        }
        int start = 1;
        int end = length - 1;
        while(end >= start){
            int mid = ((end - start) >> 1) + start;
            int count = countRange(nums,length, start,mid);  // 统计在左一半的目标数量
            if(end == start){
                if(count > 1){
                    return start;
                }else{
                    break;
                }
            }
            if (count > (mid - start + 1)){
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    int countRange(int[] nums, int length, int start, int end){
        if(nums == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if(nums[i] >= start && nums[i] <= end){
                ++count;
            }
        }
        return count;
    }


    public static void main(String[] args){
        Q003_02_DuplicationInArray solution = new Q003_02_DuplicationInArray();
        int[] arr = {2,3,5,4,3,2,6,7};
        int dup = solution.getDup(arr, 8);
        System.out.println(dup);
    }
}
