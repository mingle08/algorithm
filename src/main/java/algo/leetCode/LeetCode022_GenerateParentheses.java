package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * For example, given n = 3, a solution set is:
 * [
     "((()))",
     "(()())",
     "(())()",
     "()(())",
     "()()()"
   ]
 */
public class LeetCode022_GenerateParentheses {

    public static ArrayList<String> generateParentheses(int n){
        ArrayList<String> res = new ArrayList<String>();
        String item = new String();

        if(n <= 0){
            return res;
        }

        dfs(res, item, n, n);
        return res;
    }

    private static void dfs(ArrayList<String> res, String item, int left, int right) {
        if (left >right)
            return;

        if (left == 0 && right == 0){
            res.add(new String(item));
            return;
        }

        if (left > 0)
            dfs(res, item + '(', left - 1, right);
        if (right > 0)
            dfs(res, item + ')', left, right - 1);
    }

    public static void main(String[] args){
        int n = 3;
        List<String> list = generateParentheses(n);
        
        System.out.println(list.size());
    }
}
