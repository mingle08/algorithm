package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode017_LetterCombinationsOfAPhoneNumber {

    public static ArrayList<String> letterCombinations(String digits){
        ArrayList<String> result = new ArrayList<>();
        if(digits == null){
            return result;
        }

        // 0和1上没有英文字母
        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        StringBuilder sb = new StringBuilder();

        int index = 0;
        buildResult(digits, index, sb, keyboard, result);

        return result;
    }

    private static void buildResult(String digits, int index, StringBuilder sb, String[] keyboard, ArrayList<String> result) {
        if(index == digits.length()){
            // 找到一种结果，加入到列表中
            result.add(sb.toString());
            return;
        }

        //
        int num = digits.charAt(index) - '0';
        for (int i = 0; i < keyboard[num].length(); i++) {
            sb.append(keyboard[num].charAt(i));
            // 递归
            buildResult(digits, index + 1, sb, keyboard, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    public static void main(String[] args){

        String str = "23";

        List<String> list = letterCombinations(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
    }
}
