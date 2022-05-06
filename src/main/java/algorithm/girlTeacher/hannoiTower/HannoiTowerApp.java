package algorithm.girlTeacher.hannoiTower;
/**
 * 汉诺塔
 * @author huxm
 *
 */
public class HannoiTowerApp {
	static int n = 3;

	public static void main(String[] args) {
		hannoiRec(n, 'A', 'B', 'C');
		double step = Math.pow(2, n) - 1;
		int stepInt = (int) step;
		System.out.println("总共需要的步数：2^n - 1 = " + stepInt);

	}

	public static void hannoiRec(int n, char from, char inter, char to) {
		if(n == 1) {
			move(n, from, to);
		}else {
			hannoiRec(n-1, from, to, inter);
			move(n, from, to);
			hannoiRec(n-1, inter, from, to);
		}
	}

	private static void move(int n, char from, char to) {
		System.out.println("盘子 " + n + " 从 " + from + " 移动到 " + to);
	}

}
