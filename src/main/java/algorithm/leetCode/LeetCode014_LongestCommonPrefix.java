package algorithm.leetCode;

/**
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class LeetCode014_LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs){
        if(strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
//            if(prefix.length() > strs[i].length()){
//                prefix = prefix.substring(0, strs[i].length());
//            }
//
//            for(int j = 0; j < prefix.length(); j++){
//                if(prefix.charAt(j) != strs[i].charAt(j)){
//                    prefix = prefix.substring(0, j);
//                }
//            }
            while(strs[i].indexOf(prefix) != 0){// 等于0，才是前缀
                // 每次都去掉最后一个字符
                prefix = prefix.substring(0, prefix.length() - 1);
            }

        }
        return prefix;
    }

    public static void main(String[] args){
        String[] a = {"flower","flow","flight"};
        long startTime = System.nanoTime();
        String pre = longestCommonPrefix2(a);
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime) + "ns");  // 纳秒
        System.out.println(pre);
    }

    public static String longestCommonPrefix2(String[] strs) {
        int count = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (minLen > strs[i].length()) {
                minLen = strs[i].length();
            }
        }

        // 第一个字符串
        String str0 = strs[0];
        boolean flag = true;
        for (int i = 0; i < minLen; i++) {
            // 第i个字符
            char c = str0.charAt(i);
            for (int k = 1; k < strs.length; k++) {
                // 其他字符串的第i个字符
                char d = strs[k].charAt(i);
                if (c != d) {
                    flag = false;
                    // 终止内循环
                    break;
                }
            }
            if (!flag) {
                // 终止外循环
                break;
            }
            count++;
        }

        if (count == -1) return "";
        return strs[0].substring(0, count + 1);
    }
}
