package algorithm.codingInterviewChinese2;

/**
 * 丑数
 * 题目：我们把只包含因子2、3、5的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第1500个丑数。例如，6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把 1 当作第一个丑数
 *
 * 第1500个丑数是 859963392
 */
public class Q049_UglyNumber {

    public int getRes(int index){
        if (index < 0)
            return 0;

        int[] res = new int[index];
        res[0] = 1;
        int next = 1;
        // 下标
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        while (next < index){
            int num2 = res[i2] * 2;
            int num3 = res[i3] * 3;
            int num5 = res[i5] * 5;
            // 确定最小值
            int min = Math.min(num2, Math.min(num3, num5));
            // 把最小值放在下一个位置
            res[next] = min;

            // 判定刚才的min是谁产生的，就将谁加1
            if (res[i2] * 2 == min) i2++;

            if (res[i3] * 3 == min) i3++;

            if (res[i5] * 5 == min) i5++;

            // 下标往后移
            next++;
        }
        return res[index - 1];
    }

    public static void main(String[] args){
        Q049_UglyNumber solution = new Q049_UglyNumber();
        int number = solution.getRes(10);
        System.out.println(number);
    }
}
