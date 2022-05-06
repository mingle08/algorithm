package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode119_PascalsTriangleII {

    public List<Integer> getRow(int row) {

        List<Integer> result = new ArrayList<>();
        //初始化第0行
        result.add(1);
        //开始循环生成每一行
        for(int i = 1; i < row + 1; i++) {
            //每一行的生成取决于前一行的数，j > 0保证了j - 1 >=0访问不越界
            //从高位往低位循环则完美复用了空间
            for(int j = i - 1; j > 0; j--) {
                int temp = result.get(j) + result.get(j - 1);
                result.set(j, temp);
            }
            //每一行最后添加一个1，以便更新下一行的数值
            result.add(1);
        }

        return result;
    }

    public static void main(String[] args){

        LeetCode119_PascalsTriangleII solution = new LeetCode119_PascalsTriangleII();
        List<Integer> res = solution.getRow(3);

        System.out.println(res);
    }
}
