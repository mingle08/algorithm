package jdk;

import java.text.SimpleDateFormat;

public class ThreadLocalDemo {
    /**
     * ThreadLocal类中有一个initialValue方法
     */
    public final static ThreadLocal<SimpleDateFormat> SAFE_FORMAT_DATE =
            new ThreadLocal<SimpleDateFormat>() {
                @Override
                protected SimpleDateFormat initialValue() {
                    return new SimpleDateFormat("yyyyMMdd");
                }
            };
    public final static SimpleDateFormat FORMAT_DATE = SAFE_FORMAT_DATE.get();
}
