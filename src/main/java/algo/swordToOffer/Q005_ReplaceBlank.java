package algo.swordToOffer;

public class Q005_ReplaceBlank {

    public static String replaceBlank(char[] target){
        if (target == null)
            return null;

        int oldLen = target.length;
        int blankCount = 0;

        for(int i=0; i < oldLen; i++){
            if(target[i] == ' '){
                blankCount++;
            }
        }

        System.out.println("空格的数量=" + blankCount);

        int newLen = oldLen + 2 * blankCount;  // 因为%20有三个字符，比空格多2个字符

        int pos1 = oldLen - 1;
        int pos2 = newLen - 1;

        char[] tmp = new char[newLen];
        while (pos1 >= 0 && pos2 >= 0){
            if (target[pos1] == ' '){
                tmp[pos2--] = '0';
                tmp[pos2--] = '2';
                tmp[pos2--] = '%';
            } else {
                tmp[pos2--] = target[pos1];
            }
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