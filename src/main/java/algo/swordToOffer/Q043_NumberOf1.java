package algo.swordToOffer;

/**
 * 从1到n整数中1出现的次数
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如输入12，从1到12这些整数中包含1
 * 的数字有1，10，11和12，1一共出现了5次。
 *
 * 主要思路：
 * 为了找规律，使用例子来分析：
 * 取n=21345，为了递归，把数字分成两段：1~1345和1346~21345
 * 1.先分析1346~21345：
 * 1）1出现在首位的情况：
 * 若n>=20000，则1出现在10000~19999这10000个数字中的首位，出现次数
 * 为10000（10^4）。
 * 若n<20000，那么1出现在首位的次数为n-10000+1（即去除首位后剩下的数字+1），
 * 加1的原因是1在10000中出现1次。
 *
 * 2）1出现在除首位外剩余位数中的情况：再把1346~21345分成两段：1346~11345和11346~21345，
 * 各有1万个数字（段数=首位数字）。在每一段剩下的4位数字中，任选一位为1(C14，其中4=段长度-1），
 * 其余三位从0-9这10个数字中选(103，其中3=段长度-2)，
 * 则根据排列组合公式，总共出现的次数为：  段数×C14×103
 *
 * 。
 *
 * 2.剩下的数字1~1345：直接使用递归。
 */
public class Q043_NumberOf1 {
    public static void main(String[] args) {
        int result = NumberOf1Between1AndN(21345);
        System.out.println(result);     //18821
    }
    private static int NumberOf1Between1AndN(int n) {
        if (n <= 0) return 0;
        String strNumber = String.valueOf(n);
        int length = strNumber.length();
        int firstDigit = strNumber.charAt(0) - '0';
        //只有个位
        if (length == 1 && firstDigit == 0)
            return 0;
        if (length == 1 && firstDigit > 0)
            return 1;
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


}
