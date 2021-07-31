package jdk.PatternRex;

import java.util.regex.Pattern;

/**
 * 正则表达式
 */
public class PatternDemo {

    public static void main(String[] args) {
        String value = "dubbo, redis, zookeeper";
        // dubbo源码中的ExtensionLoader.java中的正则表达式
        Pattern p = Pattern.compile("\\s*[,]+\\s*");
        String[] arr = p.split(value);
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
