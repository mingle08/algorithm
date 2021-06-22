package jdk;

import org.openjdk.jol.info.ClassLayout;

/**
 * JOL工具的使用
 */
public class JolUtil {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

    /**
     * java.lang.Object object internals:
     * OFF  SZ   TYPE DESCRIPTION               VALUE
     *   0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
     *   8   4        (object header: class)    0xf80001e5
     *  12   4        (object alignment gap)
     * Instance size: 16 bytes
     * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
     */
}
