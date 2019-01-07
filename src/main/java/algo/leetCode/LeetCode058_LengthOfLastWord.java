package algo.leetCode;

public class LeetCode058_LengthOfLastWord {

    public static void main(String[] args) {
        LeetCode058_LengthOfLastWord solution = new LeetCode058_LengthOfLastWord();
        String str = "hello world";
        int num = solution.lengthOfLastWord(str);
        System.out.println(num);

    }
    
    public int lengthOfLastWord(String s) { 
        int count=0; 
        // 统计最后一个单词的字符数 
        for (int i=s.length()-1;i>=0;i--) { 
            if (s.charAt(i)==' ') { 
                continue; 
            } 
            // i>count 放前面, 否则 "a" 这样的字符串会越界 
            while (i>=count && s.charAt(i-count)!=' ') { 
                count++; 
            } 
            return count; 
        } 
        return count; 
    }

}
