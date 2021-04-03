package algo.codingInterviewChinese2;

/**
 * 丑数
 * 题目：我们把只包含因子2、3、5的数称作丑数（Ugly Number）。
 * 求按从小到大的顺序的第1500个丑数。例如，6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把 1 当作第一个丑数
 */
public class Q049_UglyNumber {

    public int getRes(int index){
        if (index < 0)
            return 0;

        int[] res = new int[index];
        res[0] = 1;
        int next = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (next < index){
            int num2 = res[p2] * 2;
            int num3 = res[p3] * 3;
            int num5 = res[p5] * 5;
            int min = Math.min(num2, Math.min(num3, num5));
            res[next] = min;

//            if (res[next] == num2) p2++;
//            if (res[next] == num3) p3++;
//            if (res[next] == num5) p5++;

            // 只要小于或等于，就一直找，直到找到大于的
            while (res[p2] * 2 <= res[next])
                p2++;

            while (res[p3] * 3 <= res[next])
                p3++;

            while (res[p5] * 5 <= res[next])
                p5++;

            next++;
        }
        return res[index - 1];
    }

    public static void main(String[] args){
        Q049_UglyNumber solution = new Q049_UglyNumber();
        int number = solution.getRes(1500);
        System.out.println(number);  // 859963392
    }
}
