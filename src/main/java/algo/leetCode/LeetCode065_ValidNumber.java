package algo.leetCode;

public class LeetCode065_ValidNumber {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    
    public boolean isNumber(String s) { 
        //num记录数字个数，words记录字母个数，dot记录点的个数 
        int num = 0, words = 0, dot = 0, i = 0; 
        s = s.trim(); 
        int len = s.length(); 
        //先排除 "", "xxe", "xxe+", "xxe-" 情况 
        if (s.length() == 0 || s.charAt(s.length() - 1) == 'e' || s.charAt(s.length() - 1) == '+' || s.charAt(s.length() - 1) == '-') 
            return false; 
        //如果是"-xxx"或"+xxx"，第一个带有正或负的符号，下标后移跳过第一个符号。 
        if (s.charAt(0) == '-' || s.charAt(0) == '+') { 
            len--; 
            i++; 
        } 
        for (; i < s.length(); i++) { 
                //排除 "+e", "-e" 
            if ((len == 1 && s.charAt(i) == 'e') || (len == 1 && s.charAt(i) == '.')) { 
                return false; 
            } else if ((s.charAt(i) == 'e' && words != 1) && num != 0) { 
                //遍历到"e"时，前面没有其他字母并且有数字，就算是合格的，做下记录 
                words++; 
            } else if ((s.charAt(i) == '.' && dot != 1) && words != 1) { 
                //遍历到"."时，前面没有"."并且没有"e"，就算是合格的，做下记录 
                dot++; 
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') { 
                //记录数字
                num++; 
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') { 
                // 排除 "xxe+"，"xxe-" 情况 
                if (s.charAt(i - 1) != 'e') { 
                    return false; 
                } 
            } else { 
                return false; 
            } 
        } 
        //排除 "xxe." 
        if (s.charAt(s.length() - 1) == '.' && words != 0) 
            return false; 
        
        return true; 
    }
}
