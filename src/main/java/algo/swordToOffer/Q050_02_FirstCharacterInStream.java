package algo.swordToOffer;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，
 * 当从字符流中只读出前一个字符”g”时，第一个只出现一次的字符是”g”;
 * 当从字符流中只读出前两个字符”go”时，第一个只出现一次的字符是”g”;
 * 当从字符流中只读出前三个字符"goo"时，第一个只出现一次的字符是"g";
 * 当从该字符流中读出前四个字符“goog”时，第一个只出现一次的字符是”#”。
 * 当从该字符流中读出前五个字符“googl”时，第一个只出现一次的字符是”l”。
 * 当从该字符流中读出前六个字符“google”时，第一个只出现一次的字符是”l”。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 * ---------------------
 * 作者：知之可否
 * 来源：CSDN
 * 原文：https://blog.csdn.net/gao1440156051/article/details/51315959
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * 流和串的区别： *
 * 1）串：字符串已经保存下来了，能够读取遍历，因此在字符串中第一个只出现一次的字符中，
 * 只需要存下每个字符出现的个数，然后直接在字符串中遍历； *
 * 2）流：字符流没有存下来，无法进行遍历，因此在本题中，只能在数据容器哈希表中遍历，
 * 而且哈希表中存放的是对应字符的位置，而不是个数。
 */
public class Q050_02_FirstCharacterInStream {
    private int index;
    private int[] occurence;

    public Q050_02_FirstCharacterInStream() {  //在构造函数中初始化成员变量
        index=0;
        occurence = new int[256];
        for(int i=0;i<256;i++) {
            occurence[i]=-1;
        }
    }

    /**
     * 最开始的时候，数组中的所有元素都初始化为-1.
     * 当一个ASCII码为i的字符第一次从字符流中读出时，occurence[i]的值更新为它在字符流中的位置。
     * 当这个字符再次从字符流中读出时（occurence[i]大于或等于0）,ocurrence[i]的值更新为-2.
     * @param ch
     */
    public void insert(char ch) {
        if(occurence[(int)ch]==-1) {
            occurence[(int)ch]=index;   //第一次出现, 记录读出位置
        }else if(occurence[(int)ch]>=0) {
            occurence[(int)ch]=-2;   //已经出现过了
        }
        index++;
    }

    public char getFirst() {
        int minIndex = Integer.MAX_VALUE;  // 非重复字符最早出现的位置
        char ch = '#';
        for(int i = 0; i < 256; i++) {
            if(occurence[i] >= 0 && occurence[i] < minIndex) {
                ch = (char) i;
                minIndex = occurence[i];
            }
        }
        return ch;
    }

    public static void main(String[] args){
        Q050_02_FirstCharacterInStream solution = new Q050_02_FirstCharacterInStream();
        String str = "google";
        for (int i = 0; i < str.length(); i++) {
            solution.insert(str.charAt(i));
            System.out.print(solution.getFirst());  // ggg#ll
        }
    }
}

