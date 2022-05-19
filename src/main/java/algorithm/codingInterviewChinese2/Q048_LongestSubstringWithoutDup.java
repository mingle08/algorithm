package algorithm.codingInterviewChinese2;

/**
 * 最长不含重复字符的子字符串
 * 输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
 * 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4。
 */
public class Q048_LongestSubstringWithoutDup {

    public int maxLength(String str){
        if (str == null || str.length() == 0)
            return 0;

//        int preLength = 0;  // f(i-1)
        int curLength = 0;  // f(i)
        int maxLength = 0;
        int[] pos = new int[26];
        for (int i = 0; i < 26; i++)
            pos[i] = -1;

        for (int k = 0; k < str.length(); k++) {
            int letterVal = str.charAt(k) - 'a';
            if (pos[letterVal] < 0 || k - pos[letterVal] > curLength) {
                curLength++;
            } else {
                if (curLength > maxLength)
                    maxLength = curLength;

                curLength = k - pos[letterVal];
            }
            pos[letterVal] = k;
        }

        if (curLength > maxLength)
            maxLength = curLength;

        return maxLength;
    }

    public int maxLength2(String str){
        if (str == null || str.length() == 0)
            return 0;

        int[] lastPos = new int[26];
        for (int i = 0; i < 26; i++)
            lastPos[i] = -1;

        char[] S = str.toCharArray();
        int i = -1;
        int res = 0;
        for (int k = 0; k < S.length; k++) {
            // 字母在26个字母中的位置，下标从0开始计算
            int j = S[k] - 'a';

            // 如果重复出现，i更新到新出现的位置
            if (lastPos[j] > -1) {
//                i = Math.max(i, lastPos[j]);
                if (lastPos[j] > i) i = lastPos[j];
            }
            // 记录当前字母出现的位置
            lastPos[j] = k;
            res = Math.max(res, k - i);
        }

        return res;
    }

    public static void main(String[] args){
        Q048_LongestSubstringWithoutDup solution = new Q048_LongestSubstringWithoutDup();
        String str = "arabcacfr";
        int cnt = solution.maxLength2(str);
        System.out.println(cnt);
    }
}
