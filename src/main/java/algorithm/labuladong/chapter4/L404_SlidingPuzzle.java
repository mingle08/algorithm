package algorithm.labuladong.chapter4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * 
 * 参考：https://blog.csdn.net/zml66666/article/details/118231706
 */
public class L404_SlidingPuzzle {

    Queue<String> queue = new LinkedList<>();//待处理的谜版状态
    Set<String> checked = new HashSet<>();//已入队的谜版状态
    String target = "123450";//谜版目标状态

    public int slidingPuzzle(int[][] board) {
        //获得初始状态的字符串表示      
        char[] begin = new char[6];
        for (int i = 0; i < 6; i++)
            begin[i] = (char)(board[i / 3][i % 3] + '0');
        String beginStr = String.valueOf(begin);
        if (beginStr.equals(target))//初始状态为目标状态，直接返回0
            return 0;
        queue.offer(beginStr);
        checked.add(beginStr);

        //广度优先搜索
        int step = 1;
        while (!queue.isEmpty()) {
            int count = queue.size();  //当前移动次数对应的谜版状态数量
            for (int i = 0; i < count; i++) {
                String str = queue.poll();  //取出一个谜版状态
                int posi = 0;
                while (str.charAt(posi) != '0')  //获得‘0’所在位置
                    posi++;
                if (posi != 0 && posi != 3)  //左侧交换
                    if (checkStr(String.valueOf(swap(str.toCharArray(), posi - 1, posi))) == true)
                        return step;
                if (posi != 2 && posi != 5)  //右侧交换
                    if (checkStr(String.valueOf(swap(str.toCharArray(), posi, posi + 1))) == true)
                        return step;
                if (checkStr(String.valueOf(swap(str.toCharArray(), posi, (posi + 3) % 6))) == true)  //上下交换
                    return step;
            }
            step++;//当前移动次数对应的谜版处理完成，步数++
        }
        return -1;//目标状态无法获得
    }

    public boolean checkStr(String str) {
        if (!checked.contains(str)) {//确认该状态未被处理过
            if (str.equals(target))//获得目标状态，返回
                return true;
            queue.offer(str);//入队
            checked.add(str);//记录
        }
        return false;
    }

    public char[] swap(char[] ch, int a, int b) {
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
        return ch;
    }


    public static void main(String[] args) {
        L404_SlidingPuzzle solution = new L404_SlidingPuzzle();
    
        int[][] board = {{4, 1, 2}, {5, 0, 3}};
        int step = solution.slidingPuzzle(board);
        System.out.println(step);
    }
}

