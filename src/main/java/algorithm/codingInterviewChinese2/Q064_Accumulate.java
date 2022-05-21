package algorithm.codingInterviewChinese2;

/**
 * 求1+2+...+n
 * 题目：求1+2+……+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句(A?B:C)
 *
 * 那就只能使用递归了
 */
public class Q064_Accumulate {

    /**
     * 递归
     * @param n
     * @return
     */
    public static int accum(int n) {
        /**
         * 2个条件
         * n > 0
         * n += accum(n - 1) > 0
         */
        boolean x = n > 0 && (n += accum(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        int n = 10;
        int sum = accum(n);
        System.out.println("1加到" + n + "的和是：" + sum);
    }
}
