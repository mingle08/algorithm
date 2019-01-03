package algo.leetCode;

public class LeetCode006_ZigZagConversion {

    /**
     * 将给定的字符串“ABCDEFGHIJK”按照给定的行数写成如下Z型：
     * A   E   I
     * B D F H J
     * C   G   K
     * 然后一行一行的读取：“AEIBDFHJCGK”
     */
    public static String convert(String str, int numRows){
        if(str == null || str.length() == 0 || numRows <= 1){
            return str;
        }

        StringBuilder res = new StringBuilder();
        /**
         * a     e
         * b  d  f
         * c     g
         * 从a到d为一个zig，
         * size：一个zig的大小
         */
        int size = 2 * numRows - 2;
        for (int i=0; i < numRows; i++){
            // 外层循环i表示第几行（从0开始）
            // 内层序号j表示第几个zig（从0开始）
            for (int j = i; j < str.length(); j += size){
                res.append(str.charAt(j));
                // zig的第一行和最后一行中间的行
                // 同一行中的两个元素之间的距离是： size - 2 * i (size一个zig的大小，i为当前第几行，从0开始）
                // 同一个zig中的第一个元素在str中的位置是j，第二个元素在str中的位置是： j + size - 2 * i
                if(i > 0 && i < numRows - 1){
                    int mid = j + size - 2 * i;
                    if(mid < str.length()) {
                        res.append(str.charAt(mid));
                    }
                }
            }
        }

        return res.toString();
    }
    
    public static void main(String[] args){
        String str = convert("PAYPALISHIRING", 3);
        System.out.println(str);
    }
}
