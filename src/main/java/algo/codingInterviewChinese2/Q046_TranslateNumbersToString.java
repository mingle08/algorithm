package algo.codingInterviewChinese2;

/**
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成"a"，1 翻
 * 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
 * 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和"mzi"。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
public class Q046_TranslateNumbersToString {
    public int getTranslationCount(int number) {
        if (number < 0)
            return 0;

        String str = String.valueOf(number);
        return getCount(str);
    }

    private int getCount(String str) {
        int len = str.length();
        char[] chs = str.toCharArray();
        int[] counts = new int[len];
        int cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            cnt = 0;
            if (i < len - 1)
                //f(i+1)
                cnt = counts[i + 1];
            else
                cnt = 1;

            if (i < len - 1) {
                int digit1 = chs[i] - '0';
                int digit2 = chs[i + 1] - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < len - 2)
                        //f(i) = f(i+1) + f(i+2)
                        cnt += counts[i + 2];
                    else
                        cnt += 1;  //拼接的数字只有一种翻译方式
                }
            }
            counts[i] = cnt;
        }
        cnt = counts[0];
        return cnt;
    }

    public static void main(String[] args) {
        Q046_TranslateNumbersToString solution = new Q046_TranslateNumbersToString();
        int number = 12258;
        int cnt = solution.getTranslationCount(number);
        System.out.println(cnt);
    }
}
