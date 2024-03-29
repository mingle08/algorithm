package algorithm.codingInterviewChinese2;

public class Q038_3_3_EightQueen {

	private int[][] board; // 棋盘
	private int specialRow; // 特殊点的行下标
	private int specialCol; // 特殊点的列下标
	private int size;
	private int type = 0;
	public Q038_3_3_EightQueen(int specialRow, int specialCol, int size) {
		super();
		this.board = new int[size][size];
		this.specialRow = specialRow;
		this.specialCol = specialCol;
		this.size = size;
	}

	/**
	 *
	 * @param specialRow   特殊点的行下标
	 * @param specialCol   特殊点的列下标
	 * @param leftRow      矩阵的左边起点的行下标
	 * @param leftCol      矩阵的左边起点的列下标
	 * @param size         矩阵的宽或者高
	 */
	private void chessBoard(int specialRow, int specialCol, int leftRow, int leftCol, int size) {
		if(size == 1) {
			return;
		}
		int subSize = size / 2;
		type = type % 4 + 1;
		int n = type;
		// 假设特殊点在左上角区域
		if(specialRow < leftRow + subSize && specialCol < leftCol + subSize) {
			chessBoard(specialRow, specialCol, leftRow, leftCol,subSize);
		}else {
			// 不在左上角，左上角矩阵的右下角就是特殊点
			board[leftRow + subSize - 1][leftCol + subSize - 1] = n;
			chessBoard(leftRow + subSize - 1, leftCol + subSize - 1, leftRow, leftCol, subSize);
		}

		// 特殊点在右上角区域
		if(specialRow < leftRow + subSize && specialCol >= leftCol + subSize) {
			chessBoard(specialRow, specialCol, leftRow, leftCol + subSize,subSize);
		}else {
			// 不在右上角，右上角矩阵的左下角就是特殊点
			board[leftRow + subSize - 1][leftCol + subSize] = n;
			chessBoard(leftRow + subSize - 1, leftCol + subSize, leftRow, leftCol + subSize, subSize);
		}

		// 特殊点在左下角区域
		if(specialRow >= leftRow + subSize && specialCol < leftCol + subSize) {
			chessBoard(specialRow, specialCol, leftRow + subSize, leftCol,subSize);
		}else {
			// 不在左下角，左下角矩阵的右上角就是特殊点
			board[leftRow + subSize][leftCol + subSize - 1] = n;
			chessBoard(leftRow + subSize, leftCol + subSize - 1, leftRow + subSize, leftCol, subSize);
		}

		// 特殊点在右下角区域
		if(specialRow >= leftRow + subSize && specialCol >= leftCol + subSize) {
			chessBoard(specialRow, specialCol, leftRow + subSize, leftCol + subSize, subSize);
		}else {
			// 不在右下角，右下角矩阵的左上角就是特殊点
			board[leftRow + subSize][leftCol + subSize] = n;
			chessBoard(leftRow + subSize, leftCol + subSize, leftRow + subSize, leftCol + subSize, subSize);
		}
	}

	public void printBoard(int specialRow, int specialCol, int size) {
		chessBoard(specialRow, specialCol, 0, 0, size);
		printResult();
	}

	private void printResult() {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(board[i][j] + " ");  // print，不是println
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int size = 4;
		int specialRow = 0;
		int specialCol = 1;
		Q038_3_3_EightQueen problem = new Q038_3_3_EightQueen(specialRow, specialCol, size);
		problem.printBoard(specialRow, specialCol, size);
	}

}
