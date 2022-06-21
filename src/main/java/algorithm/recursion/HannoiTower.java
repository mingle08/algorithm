package algorithm.recursion;

/**
 * 汉诺塔
 * 又称河内塔）问题是源于印度一个古老传说的益智玩具。大梵天创造世界的时候做了三根金刚石柱子，
 * 在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。大梵天命令婆罗门把圆盘从下面开始按大小
 * 顺序重新摆放在另一根柱子上。并且规定，在小圆盘上不能放大圆盘，在三根柱子之间一次只能移动一个圆盘。
 */
public class HannoiTower {

	private int i = 1;
	public static void main(String[] args) {
		HannoiTower hannoiTower = new HannoiTower();
		hannoiTower.hannoiRec(5, 'A', 'B', 'C');
		System.out.println("总共需要的步数：2^n -1" );
	}

	public void hannoiRec(int n, char from, char helper, char to) {
		if(n == 1) {
			move(1, from, to);
		}else {
			hannoiRec(n-1, from, to, helper);
			move(n, from, to);
			hannoiRec(n-1, helper, from, to);
		}

	}

	private void move(int n, char from, char to) {
		System.out.println("第" + (i++) + "步从" + from + "到" + to);

	}

}
