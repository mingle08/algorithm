package algo.swordToOffer;

public class Q015_JudgeNumber2Power {

    private static boolean numberIs2Power(int num) {
        boolean flag = false;
        num &= num - 1;
        if (num == 0) {
            flag = true;
        }
        return flag;
    }

    public static void main(String[] args) {
        // 直接使用二进制表示
        int num = 0b0100;
        boolean flag = numberIs2Power(num);
        System.out.println(flag);
    }
}
