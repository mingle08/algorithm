package algo.codingInterviewChinese2;

public class Q048_LongestSubstringWithoutDup {

    public int maxLength(String str){
        if (str == null || str.length() == 0)
            return 0;

        int preLength = 0;  // f(i-1)
        int curLength = 0;  // f(i)
        int maxLength = 0;
        int[] pos = new int[26];
        for (int i = 0; i < 26; i++)
            pos[i] = -1;

        for (int i = 0; i < str.length(); i++) {
            int letterVal = str.charAt(i) - 'a';
            if (pos[letterVal] < 0 || i - pos[letterVal] > preLength)
                curLength = preLength + 1;
            else
                curLength = i - pos[letterVal];

            pos[letterVal] = i;
            if (curLength > maxLength)
                maxLength = curLength;

            preLength = curLength;
        }
        return maxLength;
    }

    public static void main(String[] args){
        Q048_LongestSubstringWithoutDup solution = new Q048_LongestSubstringWithoutDup();
        String str = "arabcacfr";
        int cnt = solution.maxLength(str);
        System.out.println(cnt);
    }
}
