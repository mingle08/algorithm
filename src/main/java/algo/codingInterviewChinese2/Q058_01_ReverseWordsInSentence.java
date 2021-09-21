package algo.codingInterviewChinese2;

/**
 * 题目一：翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class Q058_01_ReverseWordsInSentence {

    // 1, 先翻转整个句子
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

    public String reverseSentence(String str) {
        char[] chs = str.toCharArray();
        if (str == null || str.length() < 0)
            return null;

        // 翻转整个句子
        reverse(chs, 0, str.length() - 1);
        System.out.println(chs);

        // 翻转句子中的单词
        int start = 0;
        int end = 0;
        while (start < chs.length) {
            // 遇到下一个单词
            if (chs[start] == ' ') {
                start++;
                end++;
            } else if (end == chs.length || chs[end] == ' ') {
                // 翻转单词
                reverse(chs, start, end - 1);
                end++;
                start = end;  // 进入下一个单词
            } else
                end++;
        }

        // toString()方法得不到想要的字符串，而是地址
//        return chs.toString();   // [C@66d3c617
        return new String(chs);
    }

    public static void main(String[] args) {
        Q058_01_ReverseWordsInSentence solution = new Q058_01_ReverseWordsInSentence();
        String str = "I am a student.";
        String reverseStr = solution.reverseSentence(str);
        System.out.println(reverseStr);
    }
}
