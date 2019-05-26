package algo.leetCode;

public class LeetCode027_RemoveElement {

    public static int removeElement(int[] arr, int ele){
        int newIndex = 0;
        for (int oldIndex = 0; oldIndex < arr.length; oldIndex++) {
            if (arr[oldIndex] != ele){
                arr[newIndex++] = arr[oldIndex];
            }
        }
        return newIndex;
    }
    
    public static void main(String[] args){
        int[] nums = {0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);
        System.out.println(len);
    }
}
