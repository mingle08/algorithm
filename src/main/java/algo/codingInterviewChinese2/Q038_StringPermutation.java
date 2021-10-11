package algo.codingInterviewChinese2;

import java.util.*;

import static algo.util.SwapUtil.swap;

/**
 * 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如，输入字符串abc，则打印出由字符a, b, c所能排列出的所有字符串abc, acb, bac, bca, cab和cba。
 */
public class Q038_StringPermutation {

    public static List<String> solution1(String str) {
        List<String> list = new ArrayList<>();
        permutation(str.toCharArray(), list, 0);
        Collections.sort(list);
        return list;
    }

    // 递归
    private static void permutation(char[] chs, List<String> list, int begin) {
        if (begin == chs.length - 1) {
            list.add(new String(chs));
            return;
        }

        for (int i = begin; i < chs.length; i++) {
            if (i != begin && chs[i] == chs[begin]) {
                continue;
            }
            if (i != begin) swap(chs, begin, i);
            permutation(chs, list, begin + 1);
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

    public static void main(String[] args) {
        String abc = "abc";
        List<String> list = solution1(abc);
        for (String str : list) {
            System.out.println(str);
        }
    }
}
