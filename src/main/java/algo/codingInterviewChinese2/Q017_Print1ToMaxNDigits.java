package algo.codingInterviewChinese2;

/**
 * 题目：打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3，打印出1、2、3……直到最大的三位数999
 * <p>
 * 数字与char的转化
 * 1. 数字转化成char    =>    n + '0'
 * <p>
 * 比如：字符'0'的ASCII码是48， 1 + '0' 得到 ASCII是49，即字符'1'
 * 2. char转化成数字    =>    'c' - '0'
 * 比如：字符'1'的ASCII码是49，'0'的ASCII码是48， '1' - '0' = 49 - 48 = 1
 */
public class Q017_Print1ToMaxNDigits {

    // 方法一
    public void solution1(int n) {
        if (n <= 0) {
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }
        while (!increment(number)) {
            printNumber(number);
        }
    }

    private boolean increment(char[] number) {
        boolean isOverflow = false;
        int takeOver = 0;
        int length = number.length;
        for (int i = length - 1; i >= 0; i--) {
            int sum = number[i] - '0' + takeOver;    //
            if (i == length - 1) {
                sum++;
            }
            // if 块中没有break，所以会执行i--
            if (sum >= 10) {    // 输出10的时候，把sum变为0，十位的1交给takeOver
                if (i == 0) {    // 在最左位是10，说明溢出了
                    isOverflow = true;
                } else {
                    sum -= 10;
                    takeOver = 1;
                    number[i] = (char) ('0' + sum);
                }
            } else {    // else 块中有break，不会执行i--
                number[i] = (char) ('0' + sum);
                break;    // break不会执行 i--，所以输出1到9的时候，i一直停在1
            }
        }
        return isOverflow;
    }

    // 方法二：递归
    public void solution2(int n) {
        if (n <= 0) {
            return;
        }

        char[] numbers = new char[n];
        for (int i = 0; i < 10; i++) {
            numbers[0] = (char) (i + '0');    // 先设置最左（最高）位，比如n=2，两位数，先设置十位
            print1ToMaxNDigits_Recursive(numbers, 0);
        }


    }

    public void print1ToMaxNDigits_Recursive(char[] numbers, int index) {
        // 因为从左到右设置，index为数组最后一项，说明个位设置好了
        if (index == numbers.length - 1) {
            printNumber(numbers);
            // 因为个位设置好了，就打印，然后执行return，所以index不会越界
            return;
        }

        for (int i = 0; i < 10; i++) {
            // 依次设置第二位，第三位，直到个位
            numbers[index + 1] = (char) (i + '0');
            print1ToMaxNDigits_Recursive(numbers, index + 1);
        }
    }

    // 不打印最左边的0
    private void printNumber(char[] number) {
        boolean isBegin0 = true;
        int length = number.length;
        for (int i = 0; i < length; i++) {
            if (isBegin0 && number[i] != '0') {
                isBegin0 = false;
            }
            if (!isBegin0) {
                System.out.print(number[i]);
            }
        }
        if (!isBegin0) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Q017_Print1ToMaxNDigits solution = new Q017_Print1ToMaxNDigits();
        solution.solution2(2);
    }
}
