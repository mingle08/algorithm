package algorithm.codingInterviewChinese2;

/**
 * 题目一：翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student."，则输出"student. a am I"。
 */
public class Q058_01_ReverseWordsInSentence {

    /**
     * 从后往前遍历，当i不为空时，将j移动到i处，i继续往前移动，直到遇到空字符
     * 保存i和j之前的字符
     * @param str
     * @return
     */
    public static String reverseSentence(String str) {
        if (str == null) return null;
        char[] S = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = str.length() - 1, j;
        while (i >= 0) {
            if (S[i] != ' ') {
                j = i;
                while (i >= 0 && S[i] != ' ') {
                    i--;
                }
                /*int len = j - i;
                char[] temp = new char[len];
                // 从后往前遍历，便于理解
                for (int k = j; k > i; k--) {
                    temp[len-1] = S[k];
                    len--;
                }*/
                /**
                 * 如果是StringBuilder, append方法可以截取字符串，不必使用String的substring方法
                 */
                sb.append(str, i + 1, j + 1);
            } else {
                i--;
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "I am a student.";
        String s = reverseSentence(str);
        System.out.print(s);
    }
}
