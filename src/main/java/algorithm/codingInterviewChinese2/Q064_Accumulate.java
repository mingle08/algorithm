package algorithm.codingInterviewChinese2;

/**
 * 求1+2+...+n
 * 题目：求1+2+……+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句(A?B:C)
 */
public class Q064_Accumulate {

    public static int accum(int n) {
        int sum = 1; //初始为1是作为base case的
        boolean flag = n == 1 || (sum = n + accum(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        int n = 100;
        int sum = accum(n);
        System.out.println("1加到" + n + "的和是：" + sum);
    }
}
