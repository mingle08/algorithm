package algo.codingInterviewChinese2;

public class Q058_02_LeftRotateString {
    private void reverse(char[] chs, int start, int end) {
        if (chs == null || chs.length < 0 || start > end || start < 0 || end > chs.length)
            return;

        while (start < end) {
            char temp = chs[start];
            chs[start] = chs[end];
            chs[end] = temp;

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

    public static void main(String[] args){
        Q058_02_LeftRotateString solution = new Q058_02_LeftRotateString();
        String str = "abcdefg";
        char[] chs = str.toCharArray();
        String rotateStr = solution.leftRotateString(chs, 2);
        System.out.println(rotateStr);
    }
}
