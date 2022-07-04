package algorithm.leetCode;

public class LeetCode066_PlusOne {
    public static void main(String[] args) {
        LeetCode066_PlusOne solution = new LeetCode066_PlusOne();
        int[] arr = {9, 8, 9};
        int[] res = solution.plusOne(arr);
        System.out.println(res);
    }

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            // digits.length-1下标对应的是个位数，从个位数往十位数，百位数检查
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                // 比如 125，只需最后一位加上1，得到126，return
                digits[i]++;
                return digits;
            }

        }
        // 全部都是9.如果有一位不是9，就会在上面的else分支加1并return
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}
