package algo.recursion;

public class HannoiTower {

	private int i = 1;
	public static void main(String[] args) {
		HannoiTower hannoiTower = new HannoiTower();
		hannoiTower.hannoiRec(5, 'A', 'B', 'C');
		System.out.println("总共需要的步数：2^n -1" );
	}
	
	public void hannoiRec(int n, char from, char dependOn, char to) {
		if(n == 1) {
			move(1, from, to);
		}else {
			hannoiRec(n-1, from, to, dependOn);
			move(n, from, to);
			hannoiRec(n-1, dependOn, from, to);
		}
		
	}

	private void move(int n, char from, char to) {
		System.out.println("第" + (i++) + "步从" + from + "到" + to);
		
	}

}
