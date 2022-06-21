package algorithm.recursion;

/**
 * 最大公约数
 * 
 * @author huxm
 *
 */
public class GreatestCommonDivisor {

	// （m > n ) m 和 n的最大公约数 = n 和 m % n的最大公约数
	// 36 24 ---> 12

	// n(24) m % n(12)
	// 24 12 ---> 12
	public static void main(String[] args) {
		int x = gcd(99, 55);
		System.out.println("x: " + x);

	}

	public static int gcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return gcd(n, m % n);
		}
	}

}
