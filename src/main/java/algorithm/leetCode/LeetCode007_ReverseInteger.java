package algorithm.leetCode;


/**
 * input: 123    output: 321
 *        -123           -321
 *        120            21
 */
public class LeetCode007_ReverseInteger {

    /**
     * 求余法
     * @param x
     * @return
     */
    public static int reverse(int x){
        long result = 0;  // 用long来定义result，防止溢出问题
        int temp = Math.abs(x);
        while(temp > 0){
            result *= 10; // 扩大10倍，让个位为0
            result += temp % 10;  // 求余数
            if(result > Integer.MAX_VALUE){
                return 0;
            }

            temp /= 10;  // 求商
        }

        return (int) (x >= 0 ? result : -result);
    }

    public static int reverse2(int x){
        int temp = Math.abs(x);
        // Integer的toString方法，带参数
        String str = Integer.toString(temp);
        // 带参数的构造函数
        StringBuilder sb = new StringBuilder(str);
        String res = sb.reverse().toString();
        if(Long.parseLong(res) > Integer.MAX_VALUE){
            return 0;
        }
        return x > 0 ? Integer.parseInt(res) : -Integer.parseInt(res);
    }

    public static void main(String[] args){
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(120));
    }
}
