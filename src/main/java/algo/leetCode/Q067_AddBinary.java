package algo.leetCode;

public class Q067_AddBinary {
    public static void main(String[] args){
        Q067_AddBinary solution = new Q067_AddBinary();
        String s1 = "11";
        String s2 = "1";
        String res = solution.addBinary(s1,s2);
        System.out.println(res);
    }

    public String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        // carry 为初始进制位数
        int val, tempA, tempB, carry = 0;
        StringBuffer sb = new StringBuffer();
        int maxLength = lengthA >= lengthB ? lengthA : lengthB;
        for (int i = 0; i < maxLength; i++) {
            // 从右边开始逐位取出字符串 a、b 的字符值 tempA 和 tempB，如果长度不足，则用0替代
            tempA = lengthA > i ? a.charAt(lengthA - i - 1) - '0' : 0;
            tempB = lengthB > i ? b.charAt(lengthB - i - 1) - '0' : 0;
            val = tempA + tempB + carry;
            carry = val / 2;
            val = val % 2;
            sb.append(val + "");
        }
        // 如果最高位有进位，则最高位还要加一位 1
        if (carry == 1)
            sb.append(carry);
        // 翻转结果
        return sb.reverse().toString();
    }

}
