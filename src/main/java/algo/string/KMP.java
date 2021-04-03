package algo.string;

public class KMP {


    /**
     * 朴素模式匹配
     *
     * @param source  目标串
     * @param pattern 模式串
     */
    private static void plain(String source, String pattern) {
        int res = 0;
        int sourceLength = source.length();
        int patternLength = pattern.length();
        for (int i = 0; i <= (sourceLength - patternLength); i++) {
            res++;
            String str = source.substring(i, i + patternLength);
            if (str.equals(pattern)) {
                print("朴素模式：匹配成功");
                break;
            }
        }
        print("朴素模式：一共匹配" + res + "次数");
    }

    //KMP算法实现
    private static void KMP(String source, String pattern) {
        int[] N = getN(pattern);
        int res = 0;
        int sourceLength = source.length();
        int patternLength = pattern.length();
        for (int i = 0; i <= (sourceLength - patternLength); ) {
            res++;
            String str = source.substring(i, i + patternLength);//要比较的字符串
            print(str);
            int count = getNext(pattern, str, N);
            print("移动" + count + "步");
            if (count == 0) {
                print("KMP：匹配成功");
                break;
            }
            i = i + count;
        }
        print("KMP：一共匹配" + res + "次数");
    }

    /**
     * 得到下一次要移动的次数
     *
     * @param pattern
     * @param str
     * @param N
     * @return 0, 字符串匹配；
     */
    private static int getNext(String pattern, String str, int[] N) {
        int n = pattern.length();
        char v1[] = str.toCharArray();
        char v2[] = pattern.toCharArray();
        int x = 0;
        while (n-- != 0) {
            if (v1[x] != v2[x]) {
                if (x == 0) {
                    return 1;//如果第一个不相同，移动1步
                }
                return x - N[x - 1];//x:第一次出现不同的索引的位置，即j
            }
            x++;
        }
        return 0;
    }

    private static int[] getN(String pattern) {
        char[] pat = pattern.toCharArray();
        int j = pattern.length() - 1;
        int[] N = new int[j + 1];
        for (int i = j; i >= 2; i--) {
            N[i - 1] = getK(i, pat);
        }
        for (int a : N) {
            print(a);
        }
        return N;
    }

    private static int getK(int j, char[] pat) {
        int x = j - 2;
        int y = 1;
        while (x >= 0 && compare(pat, 0, x, y, j - 1)) {
            x--;
            y++;
        }
        return x + 1;
    }

    private static boolean compare(char[] pat, int b1, int e1, int b2, int e2) {
        int n = e1 - b1 + 1;
        while (n-- != 0) {
            if (pat[b1] != pat[b2]) {
                return true;
            }
            b1++;
            b2++;
        }
        return false;
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }

    public static int KMP2(String s1,String s2) {
        if (s1.length() < s2.length() || s2.length() == 0 || null == s2)
            return -1;
        //求模式串的next数组
        int[] next = new int[s2.length()];

        //进行匹配
        for (int i = 0, j = 0; i < s1.length(); ) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (next[j] == -1)
                    i++;
                else
                    j = next[j];
            } else {
                if (j == s2.length() - 1)
                    return i - s2.length() + 1;
                i++;
                j++;
            }
        }
        return -1;
    }

    /**
     *  next表 的生成
     *  我们也可以看作是字符串匹配的过程：即原模式串和原模式串自身前缀进行匹配的过程。
     * @param partialMatchText
     * @param pattern
     * 定义两个指针i和j，
     * k：指向前缀终止位置（严格来说是终止位置减一的位置），
     * i：指向后缀终止位置
     *
     * 后缀是不包括第一个位置的，所以i的初始值为1
     * String pattern = "ABCDABD";
     *     －　"A"的前缀和后缀都为空集，共有元素的长度为0；
     *
     * 　　－　"AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；
     *
     * 　　－　"ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
     *
     * 　　－　"ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
     *
     * 　　－　"ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；
     *
     * 　　－　"ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；
     *
     * 　　－　"ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
     *
     * 如果 i = 1, pattern为 AB,  后缀子串 B, pattern.charAt(i)=B, k = 0,  前缀子串 A,  pattern.charAt(k)=A, 二者的相同序列：无，所以 next[1]= 0，  k = 0
     *          2           ABC           BC                   C      0           AB                    A                  无       next[2]= 0       0
     *          3           ABCD          BCD                  D      0           ABC                   A                  无       next[3]= 0        0
     *          4           ABCDA         BCDA                 A      0           ABCD                  A                  A       next[4]= 1         1
     *          5           ABCDAB        BCDAB                B      1           ABCDA                 B                  AB      next[5]= 2        2
     *          6           ABCDABD       BCDABD               D      2           ABCDAB                C                  无      next[6]= 0        2
     *
     */
    static void getPmt(int[] partialMatchText, String pattern) {
        int k = 0;
        partialMatchText[0] = 0;
        int len = pattern.length();
        for(int i = 1; i < len; i++) {
            while (k > 0 && pattern.charAt(i) != pattern.charAt(k)) {   // j要保证大于0，因为下面有取 k-1 作为数组下表的操作
                k = partialMatchText[k - 1];   // 注意这里，是要找前一位的对应的回退位置了
            }
            if (pattern.charAt(i) == (pattern.charAt(k))) {
                k++;
            }
            partialMatchText[i] = k;
        }
    }

    /**
     * next数组是pmt数组整体后移一位，0位设为-1
     * @param next
     * @param pattern
     */
    static void getNext(int[] next, String pattern) {
        next[0] = -1;
        int j = 0;
        int i = 1;
        while (i < pattern.length() - 1) {    // 注意要减 1
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                j++;
                i++;
                next[i] = j;
            } else {
                j = next[j] ;
            }
        }
    }

    public int kmp(char[] str, char[] p, int[] next) {
        int i = 0, j = 0;
        int n = str.length;
        int m = p.length;
        for (i = 0; i < n; i++) {
            while ((j > -1 && str[i] != p[j])) {
                j = next[j];
            }
            if (j == -1 || str[i] == p[j]) {
                j++;
            }
            if (j == m) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String source = "ABCABCABCDABDCA";
        String pattern = "ABCDABD";
        System.out.println(pattern);
        int[] pmt = new int[pattern.length()];
        getPmt(pmt, pattern);
        for (int num : pmt) {
            System.out.print(num + "\t");
        }
        System.out.println();
        int[] next = new int[pattern.length()];
        getNext(next, pattern);
        for (int num : next) {
            System.out.print(num + "\t");
        }

    }


}
