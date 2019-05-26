package algo.swordToOffer;

/**
 * 一、Ascii完整码表（256个）
 * 1. ASCII中的0~31为控制字符；32~126为打印字符；127为Delete(删除)命令。
 * 2. ASCII扩展字符——（为了适应更多字符）128~255，或者-128~-1
 * 二、本题中字符a在hashTable中显示为97---2
 * 字符b                  98---1
 * 字符c                  99---2
 * 字符d                 100---1
 */
public class Q050_01_FirstNotRepeatingChar {
    public char firstRepeating(String str){
        if (str == null)
            return '\0';
        char[] chs = str.toCharArray();
        int size = 256;
        // 借助数组，模拟哈希表（256代表所有的数字与大小写字母的总和）
        int[] hashTable = new int[size];
        for (int i = 0; i < chs.length; i++) {
            hashTable[chs[i]]++;  // 先查出hashTable中chs[i]的值，再加1
        }
        for (int i = 0; i < chs.length; i++) {// 按字符数组从前往后遍历，保证字符的先后顺序
            if (hashTable[chs[i]] == 1)
                return chs[i];
        }
        return '\0';
    }

    public static void main(String[] args){
        Q050_01_FirstNotRepeatingChar solution = new Q050_01_FirstNotRepeatingChar();
        String str = "abaccdeff";
        char c = solution.firstRepeating(str);
        System.out.println(c);
    }
}
