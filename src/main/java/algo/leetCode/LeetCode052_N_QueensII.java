package algo.leetCode;


public class LeetCode052_N_QueensII {

    public static int num = 0;  // 累计方案
    public static final int MAX_QUEEN = 8;
    public static int[] cols = new int[MAX_QUEEN];  
    
    public static void main(String[] args) {
        LeetCode052_N_QueensII queen = new LeetCode052_N_QueensII();
//        queen.getCount(0);
        num = queen.totalNQueens(MAX_QUEEN);
        System.out.println(num);

    }
    
    /**
     * 方法1
     * 以列来放置，先放第0列，再放第1列
     * @description
     * @author 
     * @date 2018年11月14日上午11:20:17
     */
    public void getCount(int n){// n是从哪一列开始遍历填皇后
        boolean[] rows = new boolean[MAX_QUEEN];  // 记录每列每个方格是否可以放皇后
        for(int i = 0; i<n; i++){
            rows[cols[i]] = true;  // true表示已经有皇后
            int d = n - i;  // 对角线
            // slash方向
            if(cols[i] - d >= 0){
                rows[cols[i] - d] = true;
            }
            // backslash方向
            if(cols[i] + d <= MAX_QUEEN - 1){
                rows[cols[i] + d] = true;
            }
        }
        // 到此知道了哪些位置不能放皇后
        for(int i=0; i<MAX_QUEEN;i++){
            if(rows[i]){
                // 不能放
                continue;
            }
            cols[n] = i;
            // 下面可能还有其它合适位置
            if(n < MAX_QUEEN - 1){
                getCount(n+1);
            }else{
                // 找到了完整的一套方案
                num++;
                printQueen();
            }
        }
        
    }
    
    private void printQueen(){
        System.out.println("第" + num + "种方案！");
        for(int i=0; i<MAX_QUEEN; i++){
            for(int j=0; j<MAX_QUEEN; j++){
                if(i == cols[j]){
                    System.out.print("Q ");
                }else{
                    System.out.print("+ ");
                }
            }
            // 换行
            System.out.println();
        }
    }
    
    public int totalNQueens(int n) {
        // 第i个位置存放的数表示row行时，Q的列
        int[] queenList = new int[n];
        // 从第0行开始放
        placeQueen(queenList, 0, n);
        return num;
    }
    
    /**
     * 方法2
     * 以行来放置，先放第0行，再放第1行
     * @description
     * @author 
     * @date 2018年11月14日上午11:21:03
     */
    private void placeQueen(int[] queenList, int row, int n) {
        // 如果已经填满，就生成结果
        if (row == n) {
            num++;
            printQueen2(queenList);
        }
        // 按照行进行放置
        for (int col = 0; col < n; col++) {// 循环每一列
            if (isValid(queenList, row, col)) { // 如果在该列放入Q不冲突的话
                // 没有回溯，因为没有修改原结果集
                // 只是临时记录结果
                queenList[row] = col;
                placeQueen(queenList, row + 1, n);
            }
        }
    }
 
    private boolean isValid(int[] queenList, int row, int col) {
        for (int i = 0; i < row; i++) {
            int d = row - i;
            // pos为列
            int pos = queenList[i];
            if (pos == col) { // 和新加入的Q处于同一列
                return false;
            }
            if (pos + d == col) { // 在新加入的Q的右对角线上
                return false;
            }
            if (pos - d == col) { // 在新加入的Q的左对角线上
                return false;
            }
        }
        return true;
    }
    
    private void printQueen2(int[] queenList){
        System.out.println("第" + num + "种方案！");
        for(int i=0; i<MAX_QUEEN; i++){
            for(int j=0; j<MAX_QUEEN; j++){
                if(i == queenList[j]){
                    System.out.print("Q ");
                }else{
                    System.out.print("+ ");
                }
            }
            // 换行
            System.out.println();
        }
    }

}
