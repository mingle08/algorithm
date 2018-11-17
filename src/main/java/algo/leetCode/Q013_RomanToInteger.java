package algo.leetCode;

import java.util.HashMap;

public class Q013_RomanToInteger {
    public static int romanToInteger(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int val = map.get(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if(map.get(str.charAt(i)) > map.get(str.charAt(i-1))){
                val = val + map.get(str.charAt(i)) - 2 * map.get(str.charAt(i-1));
            }else{
                val = val + map.get(str.charAt(i));
            }
        }
        return val;
    }
    
    public static void main(String[] args){
        String str1 = "MCM";         // 1900
        String str2 = "MCMXCVI";     // 1996
        int s1 = romanToInteger(str1);
        int s2 = romanToInteger(str2);
        System.out.println(s1);
        System.out.println(s2);
    }
}
