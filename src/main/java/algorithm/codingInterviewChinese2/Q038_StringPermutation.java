package algorithm.codingInterviewChinese2;

import java.util.*;

import jdk.internal.org.objectweb.asm.commons.StaticInitMerger;

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
 *   因为 begin == chs.length - 1，得到一个结果，退回上层递归
 *
 * 4，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，进入下次循环
 *
 * 5，第二层递归中的循环：i1++
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换chs[1]，chs[2]，chs变成acb
 *   递归进入下一层：begin + 1
 *
 * 6，第三层递归
 *   begin _ _ 2
 *   因为 begin == chs.length - 1，得到一个结果，退回上层递归
 *
 * 7，第二层递归
 *   begin _ 1 _
 *   i1    _ _ 2
 *   执行交换还原，chs又恢复成abc
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
 *   交换chs的0和1位，chs变成bac
 *   递归进入下一层：begin + 1
 *
 * 8，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，递归进入下一层：begin + 1
 *
 * 9，第三层递归
 *   begin _ _ 2
 *   因为 begin == chs.length - 1，得到一个结果，退回上层递归
 *
 * 10，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换还原，进入下一次循环
 *
 * 11，第二层递归中的循环：i++
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换chs的1和2位，chs变成bca
 *   递归进入下一层
 *
 * 12，第三层递归
 *   begin _ _ 2
 *   因为 begin == chs.length - 1，得到一个结果，退回上层递归
 *
 * 13，第二层递归
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换还原，chs变成bac
 *   因为i1为2，循环结束，退回上层递归
 *
 * 14，第一层递归
 *   begin 0 _ _
 *   i     _ 1 _
 *   交换还原，chs变成abc
 *   开始下一次循环
 *
 * 15，第一层递归中的循环：i++
 *   begin 0 _ _
 *   i     _ _ 2
 *   因为 i != begin，交换chs的0和2位，chs变成cba
 *   递归进入下一层：begin + 1
 *
 * 16，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，递归进入下一层：begin + 1
 *
 * 17，第三层递归
 *   begin _ _ 2
 *   因为 begin == chs.length - 1，得到一个结果，退回上层递归
 *
 * 18，第二层递归
 *   begin _ 1 _
 *   i1    _ 1 _
 *   不交换，进入下次循环
 *
 * 19，第二层递归中的循环：i++
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换，chs变为cab
 *   递归进入下一层
 *
 * 20，第三层递归
 *   begin _ _ 2
 *   因为 begin == chs.length - 1，得到一个结果，退回上层递归
 *
 * 21，第二层递归
 *   begin _ 1 _
 *   i1    _ _ 2
 *   交换还原，chs变为cba
 *   循环结束，返回上层递归
 *
 * 22，第一层递归
 *   begin 0 _ _
 *   i     _ _ 2
 *   交换还原，chs变为abc
 *   循环结束，退出递归
 *
 *
 *
 */
public class Q038_StringPermutation {

    public static List<String> solution1(String str) {
        List<String> list = new ArrayList<>();
        permutation(0, str.toCharArray(), list);
        Collections.sort(list);
        return list;
    }

    /**
     * 固定第一位，排列后面的位
     * @param chs
     * @param list
     * @param begin
     */
    private static void permutation(int begin, char[] chs, List<String> list) {
        if (begin == chs.length - 1) {
            list.add(new String(chs));
            return;
        }
        /**
         * 第一次循环，都是 i = begin，直接进入下一层递归
         * 如果递归到最后一位，即begin == chs.length - 1，表明得到结果，返回上一层递归
         *
         */
        for (int i = begin; i < chs.length; i++) {
            // 如果值相等，不交换
            if (i != begin && chs[i] == chs[begin]) {
                continue;
            }
            if (i != begin) swap(chs, begin, i);
            permutation(begin + 1,chs, list);
            if (i != begin) swap(chs, begin, i);

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
        char[] chs = s.toCharArray();
        // 记录已经访问过的字符
        boolean[] visited = new boolean[s.length()];
        char[] temp = new char[s.length()];
        backTrace(0, chs, set, visited, temp);
        StringBuilder sb = new StringBuilder();
        set.stream().forEach(str -> {
            sb.append(str + ",");
        });
        return sb.substring(0, sb.length() - 1).toString().split(",");
    }

    // 回溯法
    private void backTrace(int index, char[] chs, Set<String> set, boolean[] visited, char[] temp) {
        if (index == chs.length) {
            set.add(new String(temp));
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[index] = chs[i];
                backTrace(index + 1, chs, set, visited, temp);
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
        char[] chs = str.toCharArray();
        backtrace(chs, track);
        return res;
    }

    static void backtrace(char[] chs, LinkedList<Character> track) {
        if (track.size() == chs.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < chs.length; i++) {
            if (track.contains(chs[i])) {
                continue;
            }
            track.add(chs[i]);
            backtrace(chs, track);
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
        for (List<Character> chs : res) {
            for (Character c : chs) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
