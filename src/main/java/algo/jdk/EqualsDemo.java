package algo.jdk;

/**
 * Java中为什么字符串的比较常量放前面好？
 * (1) 当("a").equals(str)时，如果str为null的时候返回false；
 * (2) 当str.equals("a")时，如果str为null时会抛NullPointerException空指针异常；
 * 因为调用equals方法的，是一个对象，null是不能调用方法的
 * 所有我们一般都将常量放前面。
 */
public class EqualsDemo {

/**
 * String类中的equals方法
    public boolean equals(Object anObject) {
        if (this == anObject) {
            return true;
        }
        if (anObject instanceof String) {
            String anotherString = (String)anObject;
            int n = value.length;
            if (n == anotherString.value.length) {
                char v1[] = value;
                char v2[] = anotherString.value;
                int i = 0;
                while (n-- != 0) {
                    if (v1[i] != v2[i])
                        return false;
                    i++;
                }
                return true;
            }
        }
        return false;
    }

 */

    public static void main(String[] args){

        String name = "tom";
        if("tom".equals(name)){
            System.out.println("猜中了，他叫tom");
        }
    }
}
