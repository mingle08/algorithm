package algorithm.BeautyOfProgramming;

import java.math.BigInteger;

public class Q2_07_GreatestCommonDivisor {
    // 1. 欧几里德：辗转相除法
    public int gcd1(int x, int y){
        if (y == 0)
            return x;

        return gcd1(y, x % y);
    }

    // 2. 将除法转变为减法
    public BigInteger gcd2(BigInteger x, BigInteger y){
        if (x.compareTo(y) < 0)
            return gcd2(y, x);

        if (y.compareTo(BigInteger.ZERO) == 0)
            return x;
        else
            return gcd2(x.subtract(y), y);
    }

    // 3. 综合1和2
    public long gcd3(long x, long y){
        if (x < y)
            return gcd3(y, x);

        if (y == 0)
            return x;
        else {
            if (isEven(x)){
                if (isEven(y))
                    return (gcd3(x >> 1, y >> 1) << 1);
                else
                    return gcd3(x >> 1, y);
            } else {
                if (isEven(y))
                    return gcd3(x, y >> 1);
                else
                    return gcd3(y, x - y);
            }
        }
    }

    // 是不是偶数
    private boolean isEven(long num){
        return (num & 1) == 0;
    }

    // 4. 同方法3，只是使用BigInteger
    public BigInteger gcd4(BigInteger x, BigInteger y){
        if (x.compareTo(y) < 0)
            return gcd4(y, x);

        if (y.compareTo(BigInteger.ZERO) == 0)
            return x;
        else {
            if (isEvenBigInteger(x)){
                if (isEvenBigInteger(y))
                    return (gcd4(x.shiftRight(1), y.shiftRight(1)).shiftLeft(1));
                else
                    return gcd4(x.shiftRight(1), y);
            } else {
                if (isEvenBigInteger(y))
                    return gcd4(x, y.shiftRight(1));
                else
                    return gcd4(y, x.subtract(y));
            }
        }
    }

    // 是不是偶数
    private boolean isEvenBigInteger(BigInteger num){
        return (num.and(new BigInteger(String.valueOf(1)))).compareTo(BigInteger.ZERO) == 0;
    }

    public static void main(String[] args){
        Q2_07_GreatestCommonDivisor solution = new Q2_07_GreatestCommonDivisor();
        int num1 = 42;
        int num2 = 30;
        int g1 = solution.gcd1(num1, num2);

        long num3 = 1100100210000L;
        long num4 = 120200020L;

        BigInteger g2 = solution.gcd2(new BigInteger(String.valueOf(num1)), new BigInteger(String.valueOf(num2)));
        long g3 = solution.gcd3(num3, num4);

        BigInteger g4 = solution.gcd4(new BigInteger(String.valueOf(num3)), new BigInteger(String.valueOf(num4)));

        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g3);
        System.out.println(g4);
    }
}
