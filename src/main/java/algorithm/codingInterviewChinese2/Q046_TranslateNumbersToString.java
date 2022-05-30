package algorithm.codingInterviewChinese2;

/**
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成"a"，1 翻
 * 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
 * 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和"mzi"。
 * 请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 *
 *
 * 动态规划
 * 定义f(i)为以i开头到末尾的翻译方法的种数
 *
 * 如果按单个字符来翻译，f(0) == f(1) == f(2) ... f(n-1) == 1
 * 现在2个字符如果在10到25内，可以翻译成一个字符
 * f(i) = f(i+1) + g(i, i+1) * f(i+2)
 * 其中g(i, i+1)表示第i和i+1这2个数字是否在10到25范围内，是则为1，不是则为0
 *
 * 比如215
 * i = 0
 * f(i+2) 就是5这个数字的翻译方法，只有1种
 * f(i+1) 是以1开头的翻译方法，即15，可以拿1和5分别翻译，也可以拿15翻译，所以是2种
 * f(i) 就是215的翻译方法，要么215分别拆开，要么21和5，要么2和15，总共3种
 * 此时i和i+1的数字是21，在10和25范围内，所以值是1
 *
 * 比如295
 * i=0
 * f(i+2) 就是5这个数字的翻译方法，只有1种
 * f(i+1) 是95，因为95>26，只能拿9和5分别翻译，是1种
 * f(i) 就是295的翻译方法，只能拿295分别拆开，因为29和95都大于26， 总共1种
 * 此时i和i+1的数字是29，不在10到25范围内，所以值是0
 *
 * 比如245
 *  * i=0
 *  * f(i+2) 就是5这个数字的翻译方法，只有1种
 *  * f(i+1) 是45，因为45>26，只能拿4和5分别翻译，是1种
 *  * f(i) 就是245的翻译方法，可以拿245分别拆开，可以拿24和5， 总共2种
 *  * 此时i和i+1的数字是24，在10到25范围内，所以值是1
 */
public class Q046_TranslateNumbersToString {

    // 方法1
    public int getTranslationCount1(int number) {
        if (number < 0)
            return 0;

        String str = String.valueOf(number);
        return getCount(str);
    }

    private int getCount(String str) {
        int len = str.length();
        char[] S = str.toCharArray();
        int[] counts = new int[len];
        int cnt = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i < len - 1)
                //f(i+1)
                cnt = counts[i + 1];
            else
                cnt = 1;

            if (i < len - 1) {
                int num1 = S[i] - '0';
                int num2 = S[i + 1] - '0';
                int converted = num1 * 10 + num2;
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

    // 方法2
    public int getTranslationCount2(int number) {
        if (number < 0) return 0;

        char[] numChar = String.valueOf(number).toCharArray();
        int length = numChar.length;
        if (length == 1) {
            return 1;
        }

        int f_i2 = 1;
        int f_i1 = 1;
        int f_i = 0;
        /**
         * 从尾到头逆序遍历
         */
        for (int i = length - 2; i >= 0; i--) {
            f_i = f_i1;
            int num = (numChar[i] - '0') * 10 + (numChar[i + 1] - '0');
            if (num > 9 && num < 26) {
                f_i += f_i2;
            }
            // 前移，类似Fibbonacci自下而上递归的方法
            f_i2 = f_i1;
            f_i1 = f_i;
        }

        return  f_i;
    }

    public static void main(String[] args) {
        Q046_TranslateNumbersToString solution = new Q046_TranslateNumbersToString();
        int number = 12258;
        int cnt = solution.getTranslationCount1(number);
        int cnt2 = solution.getTranslationCount2(number);
        System.out.println(cnt);
        System.out.println(cnt2);
    }
}
