package algorithm.leetCode;
/**
 *                 4 5      (4   index i=0)
 *               1 2 3      (2   index j=1)
 *         ---------------------
 *                 1 5
 *               1 2
 *               1 0
 *             0 8         indices[i + j, i + j + 1]
 *             0 5
 *           0 4
 *
 *   indices[0,1,2,3,4]
 *
 *   2和4相乘，积的字符串形式为08，在积字符串中的索引位置，正好是2的索引值+1，4的索引值加1
 */
public class LeetCode043_MultiplyStrings {



    public String multiply(String num1, String num2){
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {// 乘数123
            for(int j = n - 1; j >= 0; j--){// 被乘数45
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // p1看作十位，p2看作个位
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];  // 乘积加上低位已有的值

                pos[p1] += sum / 10; // 十位
                pos[p2] = sum % 10;  // 个位
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : pos) {
            if(!(num == 0 && sb.length() == 0)){
                sb.append(num);
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        LeetCode043_MultiplyStrings solution = new LeetCode043_MultiplyStrings();
        String str1 = "123";
        String str2 = "45";
        String res = solution.multiply(str1, str2);
        System.out.println(res);
    }
}
