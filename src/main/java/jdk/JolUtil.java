package jdk;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * JOL工具的使用
 */
public class JolUtil {
    public static void main(String[] args) throws InterruptedException {
        // 此代码可启动偏向锁
//        TimeUnit.SECONDS.sleep(5);
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        /*
         1，joc版本为0.9的打印结果：
         java.lang.Object object internals:
          OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
               0     4        (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
               4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
               8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
              12     4        (loss due to the next object alignment)
         Instance size: 16 bytes
         Space losses: 0 bytes internal + 4 bytes external = 4 bytes total

         2，joc版本为0.16的打印结果：
         java.lang.Object object internals:
         OFF  SZ   TYPE DESCRIPTION               VALUE
           0   8        (object header: mark)     0x0000000000000001 (non-biasable; age: 0)
           8   4        (object header: class)    0xf80001e5
          12   4        (object alignment gap)
         Instance size: 16 bytes
         Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */


        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
        /*
        java.lang.Object object internals:
         OFFSET  SIZE   TYPE DESCRIPTION                               VALUE
              0     4        (object header)                           f8 f0 75 02 (11111000 11110000 01110101 00000010) (41283832)
              4     4        (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
              8     4        (object header)                           e5 01 00 f8 (11100101 00000001 00000000 11111000) (-134217243)
             12     4        (loss due to the next object alignment)
        Instance size: 16 bytes
        Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */
    }


}
