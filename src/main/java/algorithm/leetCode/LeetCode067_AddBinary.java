package algorithm.leetCode;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode067_AddBinary {

    public String addBinary(String a, String b) {
        // 使a是长串，b是短串
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int carry = 0;
        // 方便转变成字符串
        char[] ch = a.toCharArray();
        for (int m = a.length() - 1, n = b.length() - 1; m >= 0; m--, n--) {
            int sum;
            if (n >= 0) {
                sum = (ch[m] - '0') + (b.charAt(n) - '0') + carry;
            } else {
                sum = (ch[m] - '0') + carry;
            }
            ch[m] = (sum % 2 == 0 ? '0' : '1');
            // 进位
            carry = sum / 2;
        }
        String res = new String(ch);
        return carry > 0 ? "1" + res : res;
    }

    public static void main(String[] args){
        LeetCode067_AddBinary solution = new LeetCode067_AddBinary();
        String s1 = "11";
        String s2 = "1";
        String res = solution.addBinary(s1,s2);
        System.out.println(res);
    }
}
