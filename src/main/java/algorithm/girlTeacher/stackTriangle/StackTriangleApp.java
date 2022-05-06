package algorithm.girlTeacher.stackTriangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 消除递归：  将三角数字相加的算法，由递归改为非递归
 * @author huxm
 *
 */
public class StackTriangleApp {

	static int num;
	static int sum;
	static StackX stackX;
	static int codePart;
	static Param param;

	public static void main(String[] args) throws IOException {
		System.out.println("Enter a number: ");
		num = getInt();
		recTriangle();
		System.out.println("Triangle=" + sum);

	}

	public static void recTriangle() {
		stackX = new StackX(10000);
		codePart = 1;  // 开始计算三角数字
		while(!step()) {  // step()返回true就是计算结算

		}

	}

	public static boolean step() {
		switch(codePart) {
		case 1: // 开始计算三角数字
			param = new Param(num, 6);  // 6表示当前灵气是栈中最底层的一个
			stackX.push(param);
			codePart = 2; // 表示读取下一列数值
			break;
		case 2: // 读取下一列数值
			param = stackX.peek();
			if(param.n == 1) { // 全部列数都放入栈中，要进行求和了
				sum = 1;
				codePart = 5;  // 从栈里取数据，开始求和
			}else {
				codePart = 3;  // 将当前数值放入栈中
			}
			break;
		case 3:  // 将当前数值放入栈中
			Param newParam = new Param(param.n - 1, 4);  // 4表示运算求和
			stackX.push(newParam);
			codePart = 2;
			break;
		case 4:  // 表示计算求和
			param = stackX.peek();
			sum = sum + param.n;
			codePart = 5;  // 再从栈中取下一个数据
			break;
		case 5:  // 从栈中取数据
			param = stackX.peek();
			codePart = param.returnAddress;
			stackX.pop();
			break;
		case 6: // 到达栈底
			return true;
		}
		return false;
	}

	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static int getInt() throws IOException {
		String str = getString();
		int i = Integer.parseInt(str);
		return i;
	}
}
