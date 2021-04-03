package algo.util;

public class SwapUtil {

    public static void swap(char[] c, int a, int b) {
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
