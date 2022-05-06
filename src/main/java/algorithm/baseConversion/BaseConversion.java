package algorithm.baseConversion;

public class BaseConversion {

	public static void main(String[] args) {
		toBin(6);		// 110
		toBin(-6);		// 11111111 11111111 11111111 11111010
		toOct(60);		// 74
		toHex(60);		// 3C
		toHex(-60);		// FFFFFFC4
		toBin(15);
		toHex(15);
	}

	/**
	 * 通用方法
	 * @param num
	 * @param base  进制的最大数
	 * @param offset  偏移量
	 */
	public static void trans(int num, int base, int offset) {
		// 查表法
		char[] chs = {'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F'};
		char[] arr = new char[32];
		int pos = arr.length;

		if(num == 0) {
			System.out.println(0);
		}
		while(num != 0) {
			int temp = num & base;
			arr[--pos] = chs[temp];	// 用此数组，代替StringBuilder
			num = num >>> offset;
		}
		for(int x = pos; x < arr.length; x++) {
			System.out.print(arr[x]);
		}
		System.out.println();
	}

	/**
	 * 十进制 ---> 二进制
	 * @param num
	 */
	public static void toBin(int num) {
		trans(num, 1, 1);
	}

	/**
	 * 十进制 ---> 八进制
	 * @param num
	 */
	public static void toOct(int num) {
		trans(num, 7, 3);
	}

	/**
	 * 十进制 ---> 十六进制
	 * @param num
	 */
	public static void toHex(int num) {
		trans(num, 15, 4);
	}

}
