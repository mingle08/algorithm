package algo.leetCode;

/**
 *  121   true
 *  -121  false
 *  10    false
 *
 */
public class LeetCode009_PalindromeNumber {

    public static boolean isPalindrome(int x) {
        // 如果是负数，false
        if(x < 0){
            return false;
        }
        
        // 数字逆转之后的值，为了不溢出，使用long
        long result = 0;
        int temp = x;
        while(temp > 0){
//            result *= 10;
//            result += temp % 10;
            result = result * 10 + temp % 10;
            if(result > Integer.MAX_VALUE){
                result = 0;
            }
            temp /= 10;
        }
        
        return x == result;
    }

    /**
     * 判断字符串是否是回文
     * @param str
     * @return
     */
    public static boolean isPalindrome(String str){
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if(str.charAt(i) != str.charAt(len-1-i))
                return false;
        }
        return true;
    }
    
    public static void main(String[] args){
        System.out.println(isPalindrome(10));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(-121));
    }
}
