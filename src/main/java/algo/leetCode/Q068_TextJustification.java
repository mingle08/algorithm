package algo.leetCode;

import java.util.ArrayList;
import java.util.List;

public class Q068_TextJustification {
    public static void main(String[] args){
        Q068_TextJustification solution = new Q068_TextJustification();
        String[] strs = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> list = solution.fullJustify(strs, 16);
        System.out.println(list.size());
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words==null || words.length==0)
            return res;
        int count = 0;
        int last = 0;

        for(int i=0;i<words.length;i++){
            //count是上一次计算的单词的长度，words[i].length()是当前尝试放的一个单词的长度，
            //假设当前放上了这个单词，那么这一行单词跟单词间的间隔数就是i-last
            //判断这些总的长度加起来是不是大于L（超行数了）
                if(count + words[i].length() + (i-last) > maxWidth){        //超过了单行最多数
                int space = 0;      //平均的空格数
                int extraSpace = 0;      //多余的空格数
                if(i-last-1 >0){
                    space = (maxWidth - count) / (i-last - 1);      //平均的空格数
                    extraSpace = (maxWidth - count) % (i-last-1);      //多余的空格数}
                }

                StringBuilder stringBuilder = new StringBuilder();
                for(int j=last;j<i;j++){
                    stringBuilder.append(words[j]);
                    if(j < i-1){        //words[i-1]的话后面就不用填空格了，所以这里j<i-1
                        for(int m=0;m<space;m++){
                            stringBuilder.append(" ");
                        }
                        if(extraSpace >0)
                            stringBuilder.append(" ");
                        extraSpace--;
                    }
                }

                //当一行只有一个单词，且没有填满时
                for(int j=stringBuilder.length();j<maxWidth;j++)
                    stringBuilder.append(" ");

                res.add(stringBuilder.toString());
                count = 0;
                last = i;
            }
            count += words[i].length();
        }

        //对最后一行单独处理
        StringBuilder str = new StringBuilder();
        for(int i=last;i<words.length;i++){
            str.append(words[i]);
            if(str.length()<maxWidth)
                str.append(" ");
        }
        for(int i=str.length();i<maxWidth;i++)
            str.append(" ");

        res.add(str.toString());
        return res;
    }
}
