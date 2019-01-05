package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<String> item = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();

        if(s==null||s.length()==0)
            return res;

        dfs(s,0,item,res);
        return res;
    }

    public void dfs(String s, int start, List<String> item, List<List<String>> res){
        if (start == s.length()){
            res.add(new ArrayList<String>(item));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String str = s.substring(start, i+1);
            if (isPalindrome(str)) {
                item.add(str);
                dfs(s, i+1, item, res);
                item.remove(item.size() - 1);
            }
        }
    }


    public boolean isPalindrome(String s){
        int low = 0;
        int high = s.length()-1;
        while(low < high){
            if(s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args){
        LeetCode131_PalindromePartitioning solution = new LeetCode131_PalindromePartitioning();
        String str = "aab";
        List<List<String>> res = solution.partition(str);
        System.out.println(res);
    }
}


