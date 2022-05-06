package algorithm.divideAndConquer;

public class DivideAndConquer {

	/**
	 * 8支球队，两两比赛,7天打完比赛
	 *
	 */

	private void divideAndConquer(int[][] table, int m) {
		if(m == 1) {
			table[0][0] = 1;
		}else {
			// 填充左上区域
			int n = m / 2;
			divideAndConquer(table, n);

			// 填充右上区域
			for(int i = 0; i < n; i++) {
				for(int j = n; j < m; j++) {
					table[i][j] = table[i][j-n] + n;
				}
			}

			// 填充左下区域
			for(int i = n; i < m; i++) { // i是行
				for(int j = 0; j < n; j++) { // j是列
					table[i][j] = table[i-n][j] + n;
				}
			}
			// 填充右下区域
			for(int i = n; i < m; i++) { // i是行
				for(int j = n; j < m; j++) { // j是列
					table[i][j] = table[i-n][j-n];
				}
			}
		}
	}
	public static void main(String[] args) {

		int m = 16;
		int[][] table = new int[m][m];
		DivideAndConquer dac = new DivideAndConquer();
		dac.divideAndConquer(table, m);
		int c = 0;
		for(int i = 0;i<m;i++){
			for(int j = 0;j<m;j++){
				System.out.print(table[i][j]+" ");
				c++;
				if(c%m == 0){// 每m个数换行
					System.out.println();
				}
			}
		}

	}

}
