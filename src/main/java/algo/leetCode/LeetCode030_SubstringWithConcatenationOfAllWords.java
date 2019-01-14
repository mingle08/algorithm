package algo.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode030_SubstringWithConcatenationOfAllWords {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> re=new ArrayList<Integer>();
        if(words.length==0 || (words.length!=0 && words[0].length()==0)) return re;
        int wlen=words[0].length();
        int slen=words.length;
        Arrays.sort(words);
        for(int i=0;i<=s.length()-wlen*slen;i++)
        {
            String[] sublist=new String[slen];
            String sub=s.substring(i,i+wlen*slen);
            for(int j=0;j<slen;j++)
            {
                sublist[j]=sub.substring(j*wlen, (j+1)*wlen);
            }
            Arrays.sort(sublist);
            if(Arrays.equals(words, sublist)) re.add(i);
        }
        return re;
    }

}
