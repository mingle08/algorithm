package algorithm.leetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();    //行数
        if(row == 0)
            return 0;

        int[] res = new int[row+1];   //倒着求，求最后一行到第一行最小和，这样就可以用o(n)空间了

        for(int i = row - 1; i >= 0; i--){
            List<Integer> list = triangle.get(i);
            for(int j = 0;j < list.size(); j++){
                res[j] = (Math.min(res[j+1],res[j]) + list.get(j));//最后一行的最小值就是当前数
            }
        }

        return res[0];
    }

    private static void clearList(List<Integer> list){
        Iterator<Integer> iter = list.iterator();
        while (iter.hasNext()){
            int next = iter.next();
            iter.remove();
        }

    }

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        list.add(2);
        // 注意，要用new ArrayList<>(list)
//        triangle.add(list);
        triangle.add(new ArrayList<>(list));

        clearList(list);
        System.out.println(list);
        System.out.println(triangle);

        clearList(list);
        list.add(3);
        list.add(4);
        triangle.add(new ArrayList<>(list));

        clearList(list);
        list.add(6);
        list.add(5);
        list.add(7);
        triangle.add(new ArrayList<>(list));

        clearList(list);
        list.add(4);
        list.add(1);
        list.add(8);
        list.add(3);
        triangle.add(new ArrayList<>(list));

        System.out.println(triangle);

        LeetCode120_Triangle solution = new LeetCode120_Triangle();
        int min = solution.minimumTotal(triangle);
        System.out.println(min);
    }
}
