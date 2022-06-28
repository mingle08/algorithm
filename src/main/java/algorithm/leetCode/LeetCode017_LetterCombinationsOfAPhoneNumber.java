package algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 方法2
    public static List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");


        combinate(phoneMap, digits, 0, new StringBuilder(), res);

        return res;
    }

    private static void combinate(Map<Character, String> phoneMap, String digits, int index, StringBuilder sb, List<String> res) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char digit = digits.charAt(index);
        String str = phoneMap.get(digit);
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            combinate(phoneMap, digits, index + 1, sb, res);
            sb.deleteCharAt(index);
        }

    }

    public static void main(String[] args){

        String str = "23";

        List<String> list = letterCombinations2(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
    }
}
