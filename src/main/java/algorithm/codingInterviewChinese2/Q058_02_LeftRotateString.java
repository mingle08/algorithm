package algorithm.codingInterviewChinese2;

/**
 * 题目二：左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 */
public class Q058_02_LeftRotateString {

    private void reverse(char[] S, int start, int end) {
        if (S == null || S.length < 0 || start > end || start < 0 || end > S.length)
            return;

        while (start < end) {
            char temp = S[start];
            S[start] = S[end];
            S[end] = temp;

            start++;
            end--;
        }
    }

    public String leftRotateString(char[] chars, int n) {
        if(chars==null || chars.length <= 0)
            return null;
        if(n<=0 || n > chars.length)
            return null;

        // 翻转字符串的前n个字符
        reverse(chars,0,n-1);

        // 翻转字符串的后面部分
        reverse(chars,n,chars.length-1);

        // 翻转整个字符串
        reverse(chars,0,chars.length-1);

        return String.valueOf(chars);
    }


    /*
    public static String leftRotate(String str, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(str, n, str.length()).append(str, 0, n);
        return sb.toString();
    }

     */

    public static void main(String[] args){
        Q058_02_LeftRotateString solution = new Q058_02_LeftRotateString();
        String str = "abcdefg";
        char[] S = str.toCharArray();
        String rotateStr = solution.leftRotateString(S, 2);
        System.out.println(rotateStr);

//        String s = leftRotate(str, 2);
//        System.out.println(s);
    }
}
