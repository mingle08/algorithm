package algo.swordToOffer;

/**
 * 题目：打印从1到最大的n位数
 * 输入数字n，按顺序打印出从1到最大的n位十进制数，比如输入3，打印出1、2、3……直到最大的三位数999
 *
 * 数字与char的转化
 * 1. 数字转化成char    =>    n + '0'
 *
 *    比如：字符'0'的ASCII码是48， 1 + '0' 得到 ASCII是49，即字符'1'
 * 2. char转化成数字    =>    'c' - '0'
 *    比如：字符'1'的ASCII码是49，'0'的ASCII码是48， '1' - '0' = 49 - 48 = 1
 *
 */
public class Q017_Print1ToMaxNDigits {

    public void print1ToMaxNDigits(int n){
        if (n <= 0 ){
            return;
        }

        StringBuffer sb = new StringBuffer(n);
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }

        print1ToMaxNDigits_Recursive(sb, n, 0);

    }

    public void print1ToMaxNDigits_Recursive(StringBuffer sb, int n, int index){
        if (index == n){
            printNumber(sb);
            return;
        }

        for (int i = 0; i < 10; i++) {
            sb.setCharAt(index, (char)(i + '0'));
            print1ToMaxNDigits_Recursive(sb, n, index + 1);
        }
    }

    public void printNumber(StringBuffer sb){
        boolean flag = false;
        for (int i = 0; i < sb.length(); i++) {
            if (!flag && sb.charAt(i) != '0'){
                flag = true;
            }

            if (flag){
                System.out.print(sb.charAt(i));
            }
            
        }

        if (flag){
            System.out.println();
        }
    }

    public static void main(String[] args){
        Q017_Print1ToMaxNDigits solution = new Q017_Print1ToMaxNDigits();
        solution.print1ToMaxNDigits(3);
    }
}
