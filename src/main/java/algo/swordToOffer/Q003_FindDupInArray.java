package algo.swordToOffer;

/**
 * 根据题目中的信息，数组长度为n，所有数字都在0到n-1之间.
 * 可以利用现有数组设置标志，当一个数字被访问过后，可以设置对应位上的数加n
 * 之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
 * 时间复杂度为O(n)，空间复杂度为O(1)，不需要辅助空间。
 */
public class Q003_FindDupInArray {

    public static int findDup(int[] arr, int length){
        if(length < 0)
            return -1;    // 若数组为空，则返回-1

        for (int i = 0; i < length; i++) {
            int index = arr[i];    // 记录当前数值
            if(length <= index){  // 当前数值大于数组长度，则将其数值减去数组长度
                index -= length;
            }
            if (length <= arr[index])  // 以当前数值为下标的数值大于或等于数组长度，则返回当前数值
                return index;

            arr[index] += length;   // 将以当前数组为下标的数值加上数组长度
        }

        return -1;

    }

    public static void main(String[] args){
        int[] nums = {2,3,1,0,2,5,3};
        int num = findDup(nums, 7);
        System.out.println(num);
    }
}
