package algo.codingInterviewChinese2;

public class Q038_3_2_Queen {

    public static int num = 0; // 累计方案
    public static final int MAXQUEEN = 8;
    public static int[] cols = new int[MAXQUEEN];

    public static void getCount(int n) {
        //遍历该列所有不合法的行，并用rows数组记录，不合法即rows[i]=true
        boolean[] rows = new boolean[MAXQUEEN];
        for (int m = 0; m < n; m++) {
            rows[cols[m]] = true;    // cols[m] 表示第m列，第cols[m]行
            int d = n - m; // 两列之间的间距
            /**
             * 因为是n * n的棋盘，两列之间的间距（横向），同等间距在行上（纵向），向上和向下，都能构成一个45度的直角三角形             *
             * cols[m] - d 得到的正对角线方向的点
             * cols[m] + d 得到的反对角线方向的点
             */
            // slash方向 /
            if (cols[m] - d >= 0) {// 正对角线的格子如果存在（如果在第一行，不存在正对角线方向的格子，因为它超出棋盘了）
                rows[cols[m] - d] = true;
            }

            // back slash 方向 \
            if (cols[m] + d <= (MAXQUEEN - 1)) {// 反对角线的格子如果存在（如果在最后一行，不存在反对角线方向的格子，因为它超出棋盘了）
                rows[cols[m] + d] = true;
            }
        }

        // 到此知道了哪些位置不能放置皇后
        for (int i = 0; i < MAXQUEEN; i++) {
            if (rows[i]) {
                // 不能放
                continue;
            }
            //设置当前列合法棋子所在行数
            cols[n] = i;
            // 下面可能仍然有合法位置
            if (n < MAXQUEEN - 1) {
                getCount(n + 1);
            } else {
                // 找到完整的一套方案
                num++;
                printQueen();
            }
        }

    }

    private static void printQueen() {
        System.out.println("第" + num + "种方案！");
        for (int i = 0; i < MAXQUEEN; i++) {
            for (int j = 0; j < MAXQUEEN; j++) {
                if (i == cols[j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        getCount(0);    // n表示第n列

    }

}
