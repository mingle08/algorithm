package algorithm.codingInterviewChinese2;

import java.util.*;

import static algorithm.util.SwapUtil.swap;

/**
 * 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如，输入字符串abc，则打印出由字符a, b, c所能排列出的所有字符串abc, acb, bac, bca, cab和cba。
 *
 * 详解abc全排列:
 *
 * abc第一次进入方法
 * 1，第一层递归
 *   begin 0 _ _
 *   i     0 _ _
 *   因为i == begin，不交换，递归进入下一层：begin + 1
 *
 * 2，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   因为i == begin，不交换，递归进入下一层：begin + 1
 *
 * 3，第三层递归
 *   begin _ _ 2
 *   因为 begin == S.length - 1，得到一个结果，退回上层递归
 *
 * 4，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，进入下次循环
 *
 * 5，第二层递归中的循环：i1++
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换S[1]，S[2]，S变成acb
 *   递归进入下一层：begin + 1
 *
 * 6，第三层递归
 *   begin _ _ 2
 *   因为 begin == S.length - 1，得到一个结果，退回上层递归
 *
 * 7，第二层递归
 *   begin _ 1 _
 *   i1    _ _ 2
 *   执行交换还原，S又恢复成abc
 *   因为i1 == 2，本次循环结束，退回上层递归
 *
 * 8，第一层递归
 *   begin 0 _ _
 *   i     0 _ _
 *   不交换，进入下次循环
 *
 * 9，第一层递归中的循环：i++
 *   begin 0 _ _
 *   i     _ 1 _
 *   交换S的0和1位，S变成bac
 *   递归进入下一层：begin + 1
 *
 * 8，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，递归进入下一层：begin + 1
 *
 * 9，第三层递归
 *   begin _ _ 2
 *   因为 begin == S.length - 1，得到一个结果，退回上层递归
 *
 * 10，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换还原，进入下一次循环
 *
 * 11，第二层递归中的循环：i++
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换S的1和2位，S变成bca
 *   递归进入下一层
 *
 * 12，第三层递归
 *   begin _ _ 2
 *   因为 begin == S.length - 1，得到一个结果，退回上层递归
 *
 * 13，第二层递归
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换还原，S变成bac
 *   因为i1为2，循环结束，退回上层递归
 *
 * 14，第一层递归
 *   begin 0 _ _
 *   i     _ 1 _
 *   交换还原，S变成abc
 *   开始下一次循环
 *
 * 15，第一层递归中的循环：i++
 *   begin 0 _ _
 *   i     _ _ 2
 *   因为 i != begin，交换S的0和2位，S变成cba
 *   递归进入下一层：begin + 1
 *
 * 16，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，递归进入下一层：begin + 1
 *
 * 17，第三层递归
 *   begin _ _ 2
 *   因为 begin == S.length - 1，得到一个结果，退回上层递归
 *
 * 18，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，进入下次循环
 *
 * 19，第二层递归中的循环：i++
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换，S变为cab
 *   递归进入下一层
 *
 * 20，第三层递归
 *   begin _ _ 2
 *   因为 begin == S.length - 1，得到一个结果，退回上层递归
 *
 * 21，第二层递归
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换还原，S变为cba
 *   循环结束，返回上层递归
 *
 * 22，第一层递归
 *   begin 0 _ _
 *   i     _ _ 2
 *   交换还原，S变为abc
 *   循环结束，退出递归
 *
 *
 *
 */
public class Q038_StringPermutation {

    public static List<String> solution1(String str) {
        List<String> list = new ArrayList<>();
        permutation(list, str.toCharArray(), 0);
        Collections.sort(list);
        return list;
    }

    /**
     * 固定第一位，排列后面的位
     * 
     * @param list
     * @param S
     * @param begin
     */
    private static void permutation(List<String> list, char[] S, int begin) {
        if (begin == S.length - 1) {
            list.add(new String(S));
            return;
        }
        /**
         * 第一次循环，都是 i = begin，直接进入下一层递归
         * 如果递归到最后一位，即begin == S.length - 1，表明得到结果，返回上一层递归
         *
         */
        for (int i = begin; i < S.length; i++) {
            // 如果值相等，不交换
            if (i != begin && S[i] == S[begin]) {
                continue;
            }
            // 做选择
            if (i != begin) swap(S, begin, i);
            permutation(list, S, begin + 1);
            // 撤消选择
            if (i != begin) swap(S, begin, i);

        }
    }

    /**
     * 回溯法
     * 模板的伪代码如下：
     * if (已选择列表的长度 == 元素列表长度)
     * 	  得到一个全排列
     * for 元素 in 元素列表
     * 	  判断元素是否在可选列表
     * 	  # 做选择
     * 	  已选列表.add(元素)
     * 	  backTrace(元素列表, 已选择列表)
     * 	  # 撤销选择
     * 	  已选列表.remove(元素)
     * @param s
     * @return
     */
    public String[] solution2(String s) {
        // Set去重
        Set<String> set = new HashSet<>();
        char[] S = s.toCharArray();
        // 记录已经访问过的字符
        boolean[] visited = new boolean[s.length()];
        char[] temp = new char[s.length()];
        backTrace(0, S, set, visited, temp);
        StringBuilder sb = new StringBuilder();
        set.stream().forEach(str -> {
            sb.append(str + ",");
        });
        return sb.substring(0, sb.length() - 1).toString().split(",");
    }

    // 回溯法
    private void backTrace(int index, char[] S, Set<String> set, boolean[] visited, char[] temp) {
        if (index == S.length) {
            set.add(new String(temp));
            return;
        }

        for (int i = 0; i < S.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[index] = S[i];
                backTrace(index + 1, S, set, visited, temp);
                visited[i] = false;
            }
        }
    }

    /**
     * labuladong的解法
     * 简单易懂，但效率并不高
     */
    static List<List<Character>> res = new LinkedList<>();

    public static List<List<Character>> solution3(String str) {
        LinkedList<Character> track = new LinkedList<>();
        char[] S = str.toCharArray();
        backtrace(S, track);
        return res;
    }

    static void backtrace(char[] S, LinkedList<Character> track) {
        if (track.size() == S.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < S.length; i++) {
            if (track.contains(S[i])) {
                continue;
            }
            track.add(S[i]);
            backtrace(S, track);
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        String abc = "abc";
        List<String> list = solution1(abc);
        for (String str : list) {
            System.out.println(str);
        }

        List<List<Character>> res = solution3(abc);
        for (List<Character> S : res) {
            for (Character c : S) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
