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
                prefix = prefix.substring(0, prefix.length() - 1);
            }

        }
        return prefix;
    }

    public static void main(String[] args){
        String[] a = {"flower","flow","flight"};
        long startTime = System.nanoTime();
        String pre = longestCommonPrefix(a);
        long endTime = System.nanoTime();
        System.out.println((endTime-startTime) + "ns");  // 纳秒
        System.out.println(pre);
    }
}
