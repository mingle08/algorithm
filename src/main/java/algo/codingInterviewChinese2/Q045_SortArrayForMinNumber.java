package algo.codingInterviewChinese2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
 * 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
 * 字能排成的最小数字321323。
 */
public class Q045_SortArrayForMinNumber {
    public String printMinNumber(int[] num){
        if (num == null || num.length == 0 )
            return null;

        List<String> res = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            res.add(String.valueOf(num[i]));
        }

        /**
         * 将数字存入ArrayList中，通过利用Collections.sort方法：
         * Collections.sort(List<T> list, Comparator<? super T> c)方法进行排序。
         * Comparator中重写compare()方法来规定比较规则。
         */
        Collections.sort(res, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1 + o2;
                String str2 = o2 + o1;
                return str1.compareTo(str2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : res) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Q045_SortArrayForMinNumber solution = new Q045_SortArrayForMinNumber();
        int[] arr = {3, 32, 321};
        String str = solution.printMinNumber(arr);
        System.out.println(str);
    }
}
