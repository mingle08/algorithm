package designPattern.singleton;

public class Singleton {

    /*
    1, 饿汉式
    private static Singleton instance = new Singleton();
    // 构造方法私有
    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }
     */


    /*
    2, 懒汉式
    private static Singleton instance;
    // 构造方法私有
    private Singleton(){

    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
     */

    // 3，双重检测锁
    private static volatile Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // 4, 静态内部类
    /*
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    private Singleton() {

    }
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

     */
}
