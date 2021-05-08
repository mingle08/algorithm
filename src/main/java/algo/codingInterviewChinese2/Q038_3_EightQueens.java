package algo.codingInterviewChinese2;

/**
 * 一维数组 int[] cols = new int[8]
 * 每一个下标表示一列，模拟二维数组
 * 例如 cols[0] = 7
 * 表示第1列，皇后放在第7行
 */
public class Q038_3_EightQueens {

    private static int total = 0;

    private boolean check(int[] cols, int length) {
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //是否在对角线上
                if (i - j == cols[i] - cols[j]
                        || j - i == cols[i] - cols[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //全排列
    private void permutation(int[] cols, int length, int index) {
        if (length - 1 == index) {
            if (check(cols, length)) {
                total++;
                //打印
                for (int i = 0; i < length; i++) {
                    System.out.printf("%d ", cols[i]);
                }
                System.out.printf("\n---------------------------\n");
            }
        } else {
            for (int i = index; i < length; i++) {
                swap(cols, index, i);
                permutation(cols, length, index + 1);
                swap(cols, index, i);    // 归位，防止重复计算
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        if (x == y)
            return;

        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }


    public void eightQueen() {
        int queens = 8;
        int[] cols = new int[queens];
        for (int i = 0; i < queens; i++) {
            cols[i] = i;
        }
        permutation(cols, queens, 0);
    }

    public static void main(String[] args) {
        Q038_3_EightQueens solution = new Q038_3_EightQueens();

        solution.eightQueen();

        System.out.println(total);   // 92
    }

}






