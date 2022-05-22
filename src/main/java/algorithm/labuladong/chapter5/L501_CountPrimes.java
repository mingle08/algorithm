package algorithm.labuladong.chapter5;

import java.util.Arrays;

/**
 * 高效寻找素数
 * 输入一个整数，输出区间[2, n)
 */
public class L501_CountPrimes {

    // 筛数法
    static boolean[] countPrimes(int n) {
        boolean[] checkPrime = new boolean[n];
        Arrays.fill(checkPrime, true);
        // 注意 i * i
        for (int i = 2; i * i < n; i++) {
            if (checkPrime[i]) {
                // 注意 i * i
                for (int j = i * i; j < n; j += i)
                    checkPrime[j] = false;
            }
        }

        return checkPrime;
    }

    // 判断一个数是不是素数
    static boolean isPrime(int x) {
        // 注意 i * i
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 10;
        boolean[] res = countPrimes(n);

        for (int i = 2; i < n; i++) {
            if (res[i]) System.out.println(i);
        }
    }
}
