package algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode093_RestoreIPAddress {

    /*
    public List<String> restoreIpAddress(String s){
        List<String> res = new ArrayList<>();
        if(s.length() < 4 || s.length() > 12)
            return res;

        dfs(res, s, "", 0, "", 0);
        return res;
    }

    public void dfs(List<String> result, String str, String temp, int curIndex, String curSum, int count){
        if (count == 4 && curIndex == str.length()){
            result.add(temp + curSum);
        }else if(count < 4 && count > 0){
            temp = temp + curSum + '.';
            curSum = "";
        }

        for (int i = curIndex; i < str.length() && count < 4; i++){
            curSum = curSum + str.charAt(i);
            if (curSum.length() > 1 && curSum.startsWith("0") || Integer.parseInt(curSum) > 256)
                break;
            dfs(result, str, temp,i+1, curSum,count + 1);

        }
    }*/

    public List<String> restoreIpAddress(String s) {
        List<String> ans = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12)
            return ans;
        dfs(ans,0,s,"");
        return ans;
    }

    public void dfs(List<String> ans, int s, String str, String tmp){
        if(s == 3 && check(str)){// 其实取到第三层之后，判断剩下的是否合法，第四层就不用再递归了。
            ans.add(new String(tmp+str));
            return;
        }
        for(int i=0; i<3 && i<str.length()-1; i++){
            String substr = str.substring(0,i+1);
            if(check(substr)){
            dfs(ans,s+1,str.substring(i+1,str.length()),tmp+substr+".");
            }
        }
    }

    public boolean check(String substr){
        if(substr.charAt(0) == '0')
            return "0".equals(substr);
        int num = Integer.parseInt(substr);
        if(num > 255 || num < 1)
            return false;
        return true;
    }

    public static void main(String[] args){
        LeetCode093_RestoreIPAddress solution = new LeetCode093_RestoreIPAddress();

        String ss = "25525511135";
        List<String> res = solution.restoreIpAddress(ss);
        printArray(res);


    }

    public static void printArray(List<String> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
