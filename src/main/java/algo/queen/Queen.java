package algo.queen;

public class Queen {

	public static int num = 0; // 累计方案
	public static final int MAXQUEEN = 8;
	public static int[] cols = new int[MAXQUEEN];
	
	public static void getCount(int n) {
		// 记录每列每个方格是否可以放置皇后
		boolean[] rows = new boolean[MAXQUEEN];
		for(int m = 0; m < n; m++) {
			rows[cols[m]] = true;
			int d = n - m; // 二列之间的间距
			// slash方向 /
			if(cols[m] - d >= 0) {
				rows[cols[m] - d] = true;
			}
			
			// back slash 方向 \
			if(cols[m] + d <= (MAXQUEEN - 1)) {
				rows[cols[m] + d] = true;
			}
		}
		
		// 到此知道了哪些位置不能放置皇后
		for(int i = 0; i < MAXQUEEN; i++) {
			if(rows[i]) {
				// 不能放
				continue;
			}
			
			cols[n] = i;
			// 下面可能仍然有合法位置
			if(n < MAXQUEEN -1) {
				getCount(n + 1);
			}else {
				// 找到完整的一套方案
				num++;
				printQueen();
			}
		}
		
	}
	private static void printQueen() {
		System.out.println("第" + num + "种方案！");
		for(int i = 0; i < MAXQUEEN; i++) {
			for(int j = 0; j < MAXQUEEN; j++) {
				if(i == cols[j]) {
					System.out.print("0 ");
				}else {
					System.out.print("+ ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getCount(0);

	}

}
