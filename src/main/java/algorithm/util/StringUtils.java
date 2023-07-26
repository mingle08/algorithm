package algorithm.util;

public class StringUtils {
    
    public static String toEncodeX(String str, String encodeX) {
        String newStr = null;
        try {
            newStr = new String(str.getBytes(), encodeX);
        } catch (Exception e) {
            System.out.println("construct new String throws exception");
        }
        
        return newStr;
    }

    public static void main(String[] args) {
        String abc = "abcd<”>";
        String newStr = toEncodeX(abc, "ASCII");
        if (abc.equals(newStr)) {
            System.out.println("equal");
        } else {
            System.out.println("old str=" + abc + ", new str=" + newStr + " are not equal");
        }
        
    }
}
