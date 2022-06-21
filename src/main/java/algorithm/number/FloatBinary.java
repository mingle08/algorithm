package algorithm.number;

public class FloatBinary {

	/**
	 *    seee eeee  emmm mmmm mmmm mmmm mmmm mmmm
	 *   符号位   8位                23个
	 *           表示指数            尾数
	 *   小数点在最后一个e和第一个m之间
	 *   e 如果全是0，尾数附加位为0，否则尾数附加位为1（附加位的计算：0 或者 1 * 2^0)
	 *   s * m * 2^(e-127)
	 *
	 *   其中m的计算：从左到右，第一个m是m * 2^-1，第二个m的值为 m * 2^-2，第三个m的值为 m * 2^-3。
	 *
	 *   例如 -5F
	 *   1  1000 0001 0100 0000 0000 0000 0000 000
	 *   s  eeee eeee mmmm mmmm mmmm mmmm mmmm mmm
	 *   -1 * (1 * 2^0 + 1 * 2^-2) * 2^(129-127)
	 * @param args
	 */
	public static void main(String[] args) {
//		-1 * (1 * 2^0 + 1 * 2^(-2)) * 2^(129-127);
		double x = -1 * (1 * Math.pow(2, 0) + 1 * Math.pow(2, -2)) * Math.pow(2, (129-127));

		System.out.println("-6的二进制代表的值：" + x);

	}

}
