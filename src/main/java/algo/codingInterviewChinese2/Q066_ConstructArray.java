package algo.codingInterviewChinese2;

/**
 * 构建乘积数组
 * 题目：给定一个数组A[0,1,...,n-1]，请构建一个数组B[0,1,...,n-1]，其中B中的元素
 * B[i] = A[0] * A[1] * ... * A[i-1] * A[i+1] * ... * A[n-1].
 * 不能使用除法
 *
 * 思路：
 * 分成两部分：B[i] = C[i] * D[i}
 * 即C[i] = A[0] * A[1] * ... * A[i-1], D[i] = A[i+1] * ... * A[n-1].
 * 而C[i] = C[i-1] * A[i-1], D[i] = D[i-1] * A[i+1]
 */
public class Q066_ConstructArray {

    public void multiply(double[] arr1, double[] arr2) {
        int len1 = arr1.length;
        int len2 = arr2.length;

        if (len1 == len2 && len2 > 1) {
            arr2[0] = 1;
            for (int i = 1; i < len1; i++) {    // 注意i = 1
                arr2[i] = arr2[i-1] * arr1[i-1];    // C[i] = C[i-1] * A[i-1]
            }

            double temp = 1;
            // D[i] = D[i-1] * A[i+1]
            for (int i = len1 - 2; i >= 0; i--) {    // 注意 i = len1 - 2
                temp *= arr1[i+1];
                arr2[i] *= temp;
            }
        }
    }
}
