package algorithm.labuladong.chapter4;

import java.util.ArrayList;
import java.util.List;

public class L403_GenerateParenthesis {
    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();
    String[] arr;

    public List<String> generateParenthesis(int n) {
        arr = new String[]{"(", ")"};
        backtrack(n, n, track);
        return res;
    }

    //可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    public void backtrack(int left, int right, StringBuilder track) {
        // 若左括号剩下的多，说明不合法
        if (left > right) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(new String(track));
        }
        // 尝试放一个左括号
        track.append(arr[0]);
        backtrack(left - 1, right, track);
        /*
         删除最后一个
         注意StringBuilder的2个方法
         删除指定索引的元素：deleteCharAt(int index)
         获取长度：length()
         */
        track.deleteCharAt(track.length() - 1);

        // 尝试放一个右括号
        track.append(arr[1]);
        backtrack(left, right - 1, track);
        // 删除最后一个
        track.deleteCharAt(track.length() - 1);
    }

    public static void main(String[] args) {
        L403_GenerateParenthesis solution = new L403_GenerateParenthesis();
        List<String> res = solution.generateParenthesis(3);
        for (String str : res) {
            System.out.println(str);
        }
    }
}

