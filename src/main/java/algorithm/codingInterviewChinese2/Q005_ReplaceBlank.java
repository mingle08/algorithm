package algorithm.codingInterviewChinese2;

/**
 * 请实现一个函数，把字符串中的每个空格替换成"%20"。例如，输入"We are happy."，则输出"We%20are%20happy."
 */
public class Q005_ReplaceBlank {

    public static String replaceBlank(char[] target){
        if (target == null)
            return null;

        int oldLen = target.length;
        int blankCount = 0;

        // 1，统计空格的数量，是为了计算新数组的长度
        for(int i=0; i < oldLen; i++){
            if(target[i] == ' '){
                blankCount++;
            }
        }

        System.out.println("空格的数量=" + blankCount);
        // 2，计算新数组的长度
        int newLen = oldLen + 2 * blankCount;  // 因为%20有三个字符，比空格多2个字符

        // 3，指针起始位置放在最后一位，避免从前往后插入要移动后面的元素
        int pos1 = oldLen - 1;
        int pos2 = newLen - 1;

        char[] tmp = new char[newLen];
        while (pos1 >= 0 && pos2 >= 0){
            if (target[pos1] == ' '){
                // 指针2一直前移
                tmp[pos2--] = '0';
                tmp[pos2--] = '2';
                tmp[pos2--] = '%';
            } else {
                tmp[pos2--] = target[pos1];
            }
            // 指针1前移
            pos1--;
        }
        return new String(tmp);
    }

    public static void main(String[] args){
        String str = "We are happy";
        char[] chars = str.toCharArray();
        String newStr = replaceBlank(chars);
        System.out.println(newStr);
    }
}
