package algorithm.leetCode;

/**
 * Symbol       Value
 *  I             1
 *  V             5
 *  X             10
 *  L             50
 *  C             100
 *  D             500
 *  M             1000
 *
 *
 *  I can be placed before V (5) and X (10) to make 4 and 9.
 *  X can be placed before L (50) and C (100) to make 40 and 90.
 *  C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 */
public class LeetCode012_IntegerToRoman {

    /**
     * 递归
     * @param num
     * @return
     */
    public static String integerToRoman(int num){
        if(num >= 1000) return "M" + integerToRoman(num - 1000);
        if(num >= 900) return "CM" + integerToRoman(num - 900);
        if(num >= 500) return "D" + integerToRoman(num - 500);
        if(num >= 400) return "CD" + integerToRoman(num - 400);
        if(num >= 100) return "C" + integerToRoman(num - 100);
        if(num >= 90) return "XC" + integerToRoman(num - 90);
        if(num >= 50) return "L" + integerToRoman(num - 50);
        if(num >= 40) return "CL" + integerToRoman(num - 40);
        if(num >= 10) return "X" + integerToRoman(num - 10);
        if(num >= 9) return "IX" + integerToRoman(num - 9);
        if(num >= 5) return "V" + integerToRoman(num - 5);
        if(num >= 4) return "IV" + integerToRoman(num -4);
        if(num >= 1) return "I" + integerToRoman(num - 1);
        return "";

    }

    public static String intToRoman(int num){
        String str = "";
        // 总共13个
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; num != 0; i++) {
            while(num >= val[i]){
                num -= val[i];
                str += symbol[i];
            }
        }
        return str;
    }

    public static void main(String[] args){

        int a = 234;
//        String s = integerToRoman(234);
        String s = intToRoman(1994);
        System.out.println(s);
    }
}
