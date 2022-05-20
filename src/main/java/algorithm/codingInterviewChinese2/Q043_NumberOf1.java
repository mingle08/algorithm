package algorithm.codingInterviewChinese2;

/**
 * 从1到n整数中1出现的次数 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 *
 * 主要思路： 为了找规律，使用例子来分析： 取n=21345，为了递归，把数字分成两段：1~1345和1346~21345 1.先分析1346~21345： 1）1出现在首位的情况：
 * 若n>=20000，则1出现在10000~19999这10000个数字中的首位，出现次数 为10000（10^4）。 若n<20000，那么1出现在首位的次数为n-10000+1（即去除首位后剩下的数字+1），
 * 加1的原因是1在10000中出现1次。
 *
 * 2）1出现在除首位外剩余位数中的情况：再把1346~21345分成两段：1346~11345和11346~21345， 各有1万个数字（段数=首位数字）。在每一段剩下的4位数字中，任选一位为1(C14，其中4=段长度-1），
 * 其余三位从0-9这10个数字中选(103，其中3=段长度-2)， 则根据排列组合公式，总共出现的次数为：  段数×C14×103。
 *
 * 2.剩下的数字1~1345：直接使用递归。
 */
public class Q043_NumberOf1 {

    private static int NumberOf1Between1AndN(int n) {
        if (n <= 0) {
            return 0;
        }
        String strNumber = String.valueOf(n);
        int length = strNumber.length();
        int firstDigit = strNumber.charAt(0) - '0';
        //只有个位
        if (length == 1 && firstDigit == 0) {
            return 0;
        }
        if (length == 1 && firstDigit > 0) {
            return 1;
        }
        //除首位外，剩下的数字
        String remainedString = strNumber.substring(1);
        int remainedNumber = Integer.parseInt(remainedString);
        //1出现在首位的次数
        int countOfFirstDigit;
        if (firstDigit == 1) {
            countOfFirstDigit = remainedNumber + 1;
        } else {
            countOfFirstDigit = (int) Math.pow(10, length - 1);
        }
        //(length - 1):任选一位为1
        //10^(length - 2):其余位从0-9中选
        //firstDigit:首位可选的数字
        int countOfOtherDigit = firstDigit * (length - 1) * (int) Math.pow(10, length - 2);
        //递归求在剩下数字中1出现的次数
        int remainedCount = NumberOf1Between1AndN(remainedNumber);
        int result = countOfFirstDigit + countOfOtherDigit + remainedCount;
        return result;
    }

    /**
     * 参考b站博主：香辣鸡排蛋包饭
     * 数字分成  a cur b三部分
     * 比如数字 21345
     * 当base = 1时，a = 2134, cur = 5, b = 0
     * 当base = 10时，a = 213, cur = 4, b = 5
     * 当base = 100时，a = 21, cur = 3, b = 45
     * <p>
     * 分三种情况：
     * （1）当cur = 0，cur位置为 1 的数字的个数
     * （2）当cur = 1，cur位置为 1 的数字的个数
     * （3）当cur > 1，cur位置为 1 的数字的个数
     *
     * 例如，3101592
     * 一、[3101] 5 [92]
     *   base = 100
     * 1, [0-3101] 1 [0-99]
     * (a + 1) * base
     * 二、[310] 1 [ 592]
     *   base = 1000
     * 1, [0-309] 1 [0-999]
     * 2, [310] 1 [0-592]
     * a * base + (b + 1)
     * 三、[31] 0 [1592]
     * 1, [0-30] 1 [0-9999]
     * a * base
     *
     * @param n
     * @return
     */
    public static int howManyOne(int n) {
        // 如果是个位数，只出现1次
        if (n < 10) {
            return 1;
        }
        int base = 1;
        int res = 0;
        int a, cur, b;
        while (base <= n) {
            // cur后面的部分
            b = n % base;
            // 此时的a并不是真正的a，是包含了a和cur，所以下面要继续%，继续/运算
            a = n / base;
            // 得到cur和cur前面的a
            cur = a % 10;
            // cur前面的部分
            a /= 10;
            if (cur > 1) {
                res += (a + 1) * base;
            } else if (cur == 1) {
                res += a * base + b + 1;
            } else {
                res += a * base;
            }

            base *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        int result = NumberOf1Between1AndN(21345);
        int res = howManyOne(21345);
        System.out.println(result + ", " + res);     //18821
    }

}
