package algorithm.labuladong.chapter5;

import java.util.LinkedList;

/**
 * 要求算法返回幂运算a^b的计算结果，与1337取模（mod，也就是余数）后的结果。
 * 这个b可以是一个非常大的数，所以b是用数组的形式表示的。
 * 比如输入a = b, b = {1, 2}，让你返回2^12和1337求模的结果，也就是4096 % 1337 = 85.
 */
public class L502_SuperPower {

    int base = 1337;

    int superPow(int a, LinkedList<Integer> b) {
        if (b.isEmpty())
            return 1;
        int last = b.peekLast();
        b.pollLast();

        int part1 = myPow(a, last);
        int part2 = myPow(superPow(a, b), 10);
        // 每次乘法都要求模
        return (part1 * part2) % base;
    }

    private int myPow(int a, int k) {
        if (k == 0)
            return 1;
        // a对base取余
        a %= base;

        if (k % 2 == 1) {
            // k 是奇数
            return (a * myPow(a, k - 1)) % base;
        } else {
            // k 是偶数
            int sub = myPow(a, k / 2);
            return (sub * sub) % base;
        }
    }

    public static void main(String[] args) {
        L502_SuperPower solution = new L502_SuperPower();
        int a = 2;
        int[] b = { 1, 2 };
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : b) {
            list.add(i);
        }
        int res = solution.superPow(a, list);
        System.out.println(res);
    }
}
